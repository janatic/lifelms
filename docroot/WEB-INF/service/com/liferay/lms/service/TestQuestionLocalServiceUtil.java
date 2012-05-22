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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the test question local service. This utility wraps {@link com.liferay.lms.service.impl.TestQuestionLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author cvicente
 * @see TestQuestionLocalService
 * @see com.liferay.lms.service.base.TestQuestionLocalServiceBaseImpl
 * @see com.liferay.lms.service.impl.TestQuestionLocalServiceImpl
 * @generated
 */
public class TestQuestionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.lms.service.impl.TestQuestionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the test question to the database. Also notifies the appropriate model listeners.
	*
	* @param testQuestion the test question
	* @return the test question that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.TestQuestion addTestQuestion(
		com.liferay.lms.model.TestQuestion testQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTestQuestion(testQuestion);
	}

	/**
	* Creates a new test question with the primary key. Does not add the test question to the database.
	*
	* @param questionId the primary key for the new test question
	* @return the new test question
	*/
	public static com.liferay.lms.model.TestQuestion createTestQuestion(
		long questionId) {
		return getService().createTestQuestion(questionId);
	}

	/**
	* Deletes the test question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionId the primary key of the test question
	* @throws PortalException if a test question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTestQuestion(long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTestQuestion(questionId);
	}

	/**
	* Deletes the test question from the database. Also notifies the appropriate model listeners.
	*
	* @param testQuestion the test question
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTestQuestion(
		com.liferay.lms.model.TestQuestion testQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTestQuestion(testQuestion);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.liferay.lms.model.TestQuestion fetchTestQuestion(
		long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTestQuestion(questionId);
	}

	/**
	* Returns the test question with the primary key.
	*
	* @param questionId the primary key of the test question
	* @return the test question
	* @throws PortalException if a test question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.TestQuestion getTestQuestion(
		long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTestQuestion(questionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the test questions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of test questions
	* @param end the upper bound of the range of test questions (not inclusive)
	* @return the range of test questions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.TestQuestion> getTestQuestions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTestQuestions(start, end);
	}

	/**
	* Returns the number of test questions.
	*
	* @return the number of test questions
	* @throws SystemException if a system exception occurred
	*/
	public static int getTestQuestionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTestQuestionsCount();
	}

	/**
	* Updates the test question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param testQuestion the test question
	* @return the test question that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.TestQuestion updateTestQuestion(
		com.liferay.lms.model.TestQuestion testQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTestQuestion(testQuestion);
	}

	/**
	* Updates the test question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param testQuestion the test question
	* @param merge whether to merge the test question with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the test question that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.TestQuestion updateTestQuestion(
		com.liferay.lms.model.TestQuestion testQuestion, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTestQuestion(testQuestion, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static com.liferay.lms.model.TestQuestion addQuestion(long actId,
		java.lang.String text, long questionType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addQuestion(actId, text, questionType);
	}

	public static java.util.List<com.liferay.lms.model.TestQuestion> getQuestions(
		long actid) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getQuestions(actid);
	}

	public static void clearService() {
		_service = null;
	}

	public static TestQuestionLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TestQuestionLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					TestQuestionLocalService.class.getName(), portletClassLoader);

			_service = new TestQuestionLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(TestQuestionLocalServiceUtil.class,
				"_service");
			MethodCache.remove(TestQuestionLocalService.class);
		}

		return _service;
	}

	public void setService(TestQuestionLocalService service) {
		MethodCache.remove(TestQuestionLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(TestQuestionLocalServiceUtil.class,
			"_service");
		MethodCache.remove(TestQuestionLocalService.class);
	}

	private static TestQuestionLocalService _service;
}