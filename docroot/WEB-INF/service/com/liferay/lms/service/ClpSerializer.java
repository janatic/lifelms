/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.lms.service;

import com.liferay.lms.model.LearningActivityClp;
import com.liferay.lms.model.LearningActivityResultClp;
import com.liferay.lms.model.LearningActivityTryClp;
import com.liferay.lms.model.LearningTypeClp;
import com.liferay.lms.model.TestAnswerClp;
import com.liferay.lms.model.TestQuestionClp;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"liferaylms-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"liferaylms-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "liferaylms-portlet";
			}

			return _servletContextName;
		}
	}

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(LearningActivityClp.class.getName())) {
			return translateInputLearningActivity(oldModel);
		}

		if (oldModelClassName.equals(LearningActivityResultClp.class.getName())) {
			return translateInputLearningActivityResult(oldModel);
		}

		if (oldModelClassName.equals(LearningActivityTryClp.class.getName())) {
			return translateInputLearningActivityTry(oldModel);
		}

		if (oldModelClassName.equals(LearningTypeClp.class.getName())) {
			return translateInputLearningType(oldModel);
		}

		if (oldModelClassName.equals(TestAnswerClp.class.getName())) {
			return translateInputTestAnswer(oldModel);
		}

		if (oldModelClassName.equals(TestQuestionClp.class.getName())) {
			return translateInputTestQuestion(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputLearningActivity(BaseModel<?> oldModel) {
		LearningActivityClp oldCplModel = (LearningActivityClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.liferay.lms.model.impl.LearningActivityImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setUuid",
						new Class[] { String.class });

				String value0 = oldCplModel.getUuid();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setActId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getActId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getCompanyId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getUserId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getGroupId());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setUserName",
						new Class[] { String.class });

				String value5 = oldCplModel.getUserName();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getCreateDate();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value7 = oldCplModel.getModifiedDate();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setStatus",
						new Class[] { Integer.TYPE });

				Integer value8 = new Integer(oldCplModel.getStatus());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setStatusByUserId",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getStatusByUserId());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setStatusByUserName",
						new Class[] { String.class });

				String value10 = oldCplModel.getStatusByUserName();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setStatusDate",
						new Class[] { Date.class });

				Date value11 = oldCplModel.getStatusDate();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setTitle",
						new Class[] { String.class });

				String value12 = oldCplModel.getTitle();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value13 = oldCplModel.getDescription();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setTypeId",
						new Class[] { Integer.TYPE });

				Integer value14 = new Integer(oldCplModel.getTypeId());

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setStartdate",
						new Class[] { Date.class });

				Date value15 = oldCplModel.getStartdate();

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setEnddate",
						new Class[] { Date.class });

				Date value16 = oldCplModel.getEnddate();

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setPrecedence",
						new Class[] { Integer.TYPE });

				Integer value17 = new Integer(oldCplModel.getPrecedence());

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setTries",
						new Class[] { Long.TYPE });

				Long value18 = new Long(oldCplModel.getTries());

				method18.invoke(newModel, value18);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputLearningActivityResult(
		BaseModel<?> oldModel) {
		LearningActivityResultClp oldCplModel = (LearningActivityResultClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.liferay.lms.model.impl.LearningActivityResultImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setUuid",
						new Class[] { String.class });

				String value0 = oldCplModel.getUuid();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setLarId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getLarId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setActId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getActId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getUserId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setResult",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getResult());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setStartDate",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getStartDate();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setEndDate",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getEndDate();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setLatId",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getLatId());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setComments",
						new Class[] { String.class });

				String value8 = oldCplModel.getComments();

				method8.invoke(newModel, value8);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputLearningActivityTry(
		BaseModel<?> oldModel) {
		LearningActivityTryClp oldCplModel = (LearningActivityTryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.liferay.lms.model.impl.LearningActivityTryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setUuid",
						new Class[] { String.class });

				String value0 = oldCplModel.getUuid();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setLatId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getLatId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setActId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getActId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getUserId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setStartDate",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getStartDate();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setResult",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getResult());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setEndDate",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getEndDate();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setTryData",
						new Class[] { String.class });

				String value7 = oldCplModel.getTryData();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setTryResultData",
						new Class[] { String.class });

				String value8 = oldCplModel.getTryResultData();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setComments",
						new Class[] { String.class });

				String value9 = oldCplModel.getComments();

				method9.invoke(newModel, value9);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputLearningType(BaseModel<?> oldModel) {
		LearningTypeClp oldCplModel = (LearningTypeClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.liferay.lms.model.impl.LearningTypeImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setUuid",
						new Class[] { String.class });

				String value0 = oldCplModel.getUuid();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setTypeId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getTypeId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value2 = oldCplModel.getName();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setClassName",
						new Class[] { String.class });

				String value3 = oldCplModel.getClassName();

				method3.invoke(newModel, value3);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputTestAnswer(BaseModel<?> oldModel) {
		TestAnswerClp oldCplModel = (TestAnswerClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.liferay.lms.model.impl.TestAnswerImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setUuid",
						new Class[] { String.class });

				String value0 = oldCplModel.getUuid();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setAnswerId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getAnswerId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setQuestionId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getQuestionId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setActId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getActId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setPrecedence",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getPrecedence());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setAnswer",
						new Class[] { String.class });

				String value5 = oldCplModel.getAnswer();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setIsCorrect",
						new Class[] { Boolean.TYPE });

				Boolean value6 = new Boolean(oldCplModel.getIsCorrect());

				method6.invoke(newModel, value6);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputTestQuestion(BaseModel<?> oldModel) {
		TestQuestionClp oldCplModel = (TestQuestionClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.liferay.lms.model.impl.TestQuestionImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setUuid",
						new Class[] { String.class });

				String value0 = oldCplModel.getUuid();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setQuestionId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getQuestionId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setActId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getActId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setText",
						new Class[] { String.class });

				String value3 = oldCplModel.getText();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setQuestionType",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getQuestionType());

				method4.invoke(newModel, value4);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.liferay.lms.model.impl.LearningActivityImpl")) {
			return translateOutputLearningActivity(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.lms.model.impl.LearningActivityResultImpl")) {
			return translateOutputLearningActivityResult(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.lms.model.impl.LearningActivityTryImpl")) {
			return translateOutputLearningActivityTry(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.lms.model.impl.LearningTypeImpl")) {
			return translateOutputLearningType(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.lms.model.impl.TestAnswerImpl")) {
			return translateOutputTestAnswer(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.lms.model.impl.TestQuestionImpl")) {
			return translateOutputTestQuestion(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutputLearningActivity(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				LearningActivityClp newModel = new LearningActivityClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUuid");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setUuid(value0);

				Method method1 = oldModelClass.getMethod("getActId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setActId(value1);

				Method method2 = oldModelClass.getMethod("getCompanyId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value2);

				Method method3 = oldModelClass.getMethod("getUserId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setUserId(value3);

				Method method4 = oldModelClass.getMethod("getGroupId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value4);

				Method method5 = oldModelClass.getMethod("getUserName");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setUserName(value5);

				Method method6 = oldModelClass.getMethod("getCreateDate");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value6);

				Method method7 = oldModelClass.getMethod("getModifiedDate");

				Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value7);

				Method method8 = oldModelClass.getMethod("getStatus");

				Integer value8 = (Integer)method8.invoke(oldModel,
						(Object[])null);

				newModel.setStatus(value8);

				Method method9 = oldModelClass.getMethod("getStatusByUserId");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setStatusByUserId(value9);

				Method method10 = oldModelClass.getMethod("getStatusByUserName");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setStatusByUserName(value10);

				Method method11 = oldModelClass.getMethod("getStatusDate");

				Date value11 = (Date)method11.invoke(oldModel, (Object[])null);

				newModel.setStatusDate(value11);

				Method method12 = oldModelClass.getMethod("getTitle");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setTitle(value12);

				Method method13 = oldModelClass.getMethod("getDescription");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setDescription(value13);

				Method method14 = oldModelClass.getMethod("getTypeId");

				Integer value14 = (Integer)method14.invoke(oldModel,
						(Object[])null);

				newModel.setTypeId(value14);

				Method method15 = oldModelClass.getMethod("getStartdate");

				Date value15 = (Date)method15.invoke(oldModel, (Object[])null);

				newModel.setStartdate(value15);

				Method method16 = oldModelClass.getMethod("getEnddate");

				Date value16 = (Date)method16.invoke(oldModel, (Object[])null);

				newModel.setEnddate(value16);

				Method method17 = oldModelClass.getMethod("getPrecedence");

				Integer value17 = (Integer)method17.invoke(oldModel,
						(Object[])null);

				newModel.setPrecedence(value17);

				Method method18 = oldModelClass.getMethod("getTries");

				Long value18 = (Long)method18.invoke(oldModel, (Object[])null);

				newModel.setTries(value18);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputLearningActivityResult(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				LearningActivityResultClp newModel = new LearningActivityResultClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUuid");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setUuid(value0);

				Method method1 = oldModelClass.getMethod("getLarId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setLarId(value1);

				Method method2 = oldModelClass.getMethod("getActId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setActId(value2);

				Method method3 = oldModelClass.getMethod("getUserId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setUserId(value3);

				Method method4 = oldModelClass.getMethod("getResult");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setResult(value4);

				Method method5 = oldModelClass.getMethod("getStartDate");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setStartDate(value5);

				Method method6 = oldModelClass.getMethod("getEndDate");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setEndDate(value6);

				Method method7 = oldModelClass.getMethod("getLatId");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setLatId(value7);

				Method method8 = oldModelClass.getMethod("getComments");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setComments(value8);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputLearningActivityTry(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				LearningActivityTryClp newModel = new LearningActivityTryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUuid");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setUuid(value0);

				Method method1 = oldModelClass.getMethod("getLatId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setLatId(value1);

				Method method2 = oldModelClass.getMethod("getActId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setActId(value2);

				Method method3 = oldModelClass.getMethod("getUserId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setUserId(value3);

				Method method4 = oldModelClass.getMethod("getStartDate");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setStartDate(value4);

				Method method5 = oldModelClass.getMethod("getResult");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setResult(value5);

				Method method6 = oldModelClass.getMethod("getEndDate");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setEndDate(value6);

				Method method7 = oldModelClass.getMethod("getTryData");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setTryData(value7);

				Method method8 = oldModelClass.getMethod("getTryResultData");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setTryResultData(value8);

				Method method9 = oldModelClass.getMethod("getComments");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setComments(value9);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputLearningType(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				LearningTypeClp newModel = new LearningTypeClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUuid");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setUuid(value0);

				Method method1 = oldModelClass.getMethod("getTypeId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setTypeId(value1);

				Method method2 = oldModelClass.getMethod("getName");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setName(value2);

				Method method3 = oldModelClass.getMethod("getClassName");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setClassName(value3);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputTestAnswer(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				TestAnswerClp newModel = new TestAnswerClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUuid");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setUuid(value0);

				Method method1 = oldModelClass.getMethod("getAnswerId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setAnswerId(value1);

				Method method2 = oldModelClass.getMethod("getQuestionId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setQuestionId(value2);

				Method method3 = oldModelClass.getMethod("getActId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setActId(value3);

				Method method4 = oldModelClass.getMethod("getPrecedence");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setPrecedence(value4);

				Method method5 = oldModelClass.getMethod("getAnswer");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setAnswer(value5);

				Method method6 = oldModelClass.getMethod("getIsCorrect");

				Boolean value6 = (Boolean)method6.invoke(oldModel,
						(Object[])null);

				newModel.setIsCorrect(value6);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputTestQuestion(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				TestQuestionClp newModel = new TestQuestionClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUuid");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setUuid(value0);

				Method method1 = oldModelClass.getMethod("getQuestionId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setQuestionId(value1);

				Method method2 = oldModelClass.getMethod("getActId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setActId(value2);

				Method method3 = oldModelClass.getMethod("getText");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setText(value3);

				Method method4 = oldModelClass.getMethod("getQuestionType");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setQuestionType(value4);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
	private static String _servletContextName;
}