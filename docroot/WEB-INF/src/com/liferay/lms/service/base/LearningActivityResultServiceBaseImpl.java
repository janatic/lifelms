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

package com.liferay.lms.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.lms.model.LearningActivityResult;
import com.liferay.lms.service.LearningActivityLocalService;
import com.liferay.lms.service.LearningActivityResultLocalService;
import com.liferay.lms.service.LearningActivityResultService;
import com.liferay.lms.service.LearningActivityService;
import com.liferay.lms.service.LearningActivityTryLocalService;
import com.liferay.lms.service.LearningActivityTryService;
import com.liferay.lms.service.LearningTypeLocalService;
import com.liferay.lms.service.LearningTypeService;
import com.liferay.lms.service.TestAnswerLocalService;
import com.liferay.lms.service.TestAnswerService;
import com.liferay.lms.service.TestQuestionLocalService;
import com.liferay.lms.service.TestQuestionService;
import com.liferay.lms.service.persistence.LearningActivityPersistence;
import com.liferay.lms.service.persistence.LearningActivityResultPersistence;
import com.liferay.lms.service.persistence.LearningActivityTryPersistence;
import com.liferay.lms.service.persistence.LearningTypePersistence;
import com.liferay.lms.service.persistence.TestAnswerPersistence;
import com.liferay.lms.service.persistence.TestQuestionPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the learning activity result remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.lms.service.impl.LearningActivityResultServiceImpl}.
 * </p>
 *
 * @author cvicente
 * @see com.liferay.lms.service.impl.LearningActivityResultServiceImpl
 * @see com.liferay.lms.service.LearningActivityResultServiceUtil
 * @generated
 */
public abstract class LearningActivityResultServiceBaseImpl
	extends PrincipalBean implements LearningActivityResultService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.lms.service.LearningActivityResultServiceUtil} to access the learning activity result remote service.
	 */

	/**
	 * Returns the learning activity local service.
	 *
	 * @return the learning activity local service
	 */
	public LearningActivityLocalService getLearningActivityLocalService() {
		return learningActivityLocalService;
	}

	/**
	 * Sets the learning activity local service.
	 *
	 * @param learningActivityLocalService the learning activity local service
	 */
	public void setLearningActivityLocalService(
		LearningActivityLocalService learningActivityLocalService) {
		this.learningActivityLocalService = learningActivityLocalService;
	}

	/**
	 * Returns the learning activity remote service.
	 *
	 * @return the learning activity remote service
	 */
	public LearningActivityService getLearningActivityService() {
		return learningActivityService;
	}

	/**
	 * Sets the learning activity remote service.
	 *
	 * @param learningActivityService the learning activity remote service
	 */
	public void setLearningActivityService(
		LearningActivityService learningActivityService) {
		this.learningActivityService = learningActivityService;
	}

	/**
	 * Returns the learning activity persistence.
	 *
	 * @return the learning activity persistence
	 */
	public LearningActivityPersistence getLearningActivityPersistence() {
		return learningActivityPersistence;
	}

	/**
	 * Sets the learning activity persistence.
	 *
	 * @param learningActivityPersistence the learning activity persistence
	 */
	public void setLearningActivityPersistence(
		LearningActivityPersistence learningActivityPersistence) {
		this.learningActivityPersistence = learningActivityPersistence;
	}

	/**
	 * Returns the learning activity result local service.
	 *
	 * @return the learning activity result local service
	 */
	public LearningActivityResultLocalService getLearningActivityResultLocalService() {
		return learningActivityResultLocalService;
	}

	/**
	 * Sets the learning activity result local service.
	 *
	 * @param learningActivityResultLocalService the learning activity result local service
	 */
	public void setLearningActivityResultLocalService(
		LearningActivityResultLocalService learningActivityResultLocalService) {
		this.learningActivityResultLocalService = learningActivityResultLocalService;
	}

	/**
	 * Returns the learning activity result remote service.
	 *
	 * @return the learning activity result remote service
	 */
	public LearningActivityResultService getLearningActivityResultService() {
		return learningActivityResultService;
	}

	/**
	 * Sets the learning activity result remote service.
	 *
	 * @param learningActivityResultService the learning activity result remote service
	 */
	public void setLearningActivityResultService(
		LearningActivityResultService learningActivityResultService) {
		this.learningActivityResultService = learningActivityResultService;
	}

	/**
	 * Returns the learning activity result persistence.
	 *
	 * @return the learning activity result persistence
	 */
	public LearningActivityResultPersistence getLearningActivityResultPersistence() {
		return learningActivityResultPersistence;
	}

	/**
	 * Sets the learning activity result persistence.
	 *
	 * @param learningActivityResultPersistence the learning activity result persistence
	 */
	public void setLearningActivityResultPersistence(
		LearningActivityResultPersistence learningActivityResultPersistence) {
		this.learningActivityResultPersistence = learningActivityResultPersistence;
	}

	/**
	 * Returns the learning activity try local service.
	 *
	 * @return the learning activity try local service
	 */
	public LearningActivityTryLocalService getLearningActivityTryLocalService() {
		return learningActivityTryLocalService;
	}

	/**
	 * Sets the learning activity try local service.
	 *
	 * @param learningActivityTryLocalService the learning activity try local service
	 */
	public void setLearningActivityTryLocalService(
		LearningActivityTryLocalService learningActivityTryLocalService) {
		this.learningActivityTryLocalService = learningActivityTryLocalService;
	}

	/**
	 * Returns the learning activity try remote service.
	 *
	 * @return the learning activity try remote service
	 */
	public LearningActivityTryService getLearningActivityTryService() {
		return learningActivityTryService;
	}

	/**
	 * Sets the learning activity try remote service.
	 *
	 * @param learningActivityTryService the learning activity try remote service
	 */
	public void setLearningActivityTryService(
		LearningActivityTryService learningActivityTryService) {
		this.learningActivityTryService = learningActivityTryService;
	}

	/**
	 * Returns the learning activity try persistence.
	 *
	 * @return the learning activity try persistence
	 */
	public LearningActivityTryPersistence getLearningActivityTryPersistence() {
		return learningActivityTryPersistence;
	}

	/**
	 * Sets the learning activity try persistence.
	 *
	 * @param learningActivityTryPersistence the learning activity try persistence
	 */
	public void setLearningActivityTryPersistence(
		LearningActivityTryPersistence learningActivityTryPersistence) {
		this.learningActivityTryPersistence = learningActivityTryPersistence;
	}

	/**
	 * Returns the learning type local service.
	 *
	 * @return the learning type local service
	 */
	public LearningTypeLocalService getLearningTypeLocalService() {
		return learningTypeLocalService;
	}

	/**
	 * Sets the learning type local service.
	 *
	 * @param learningTypeLocalService the learning type local service
	 */
	public void setLearningTypeLocalService(
		LearningTypeLocalService learningTypeLocalService) {
		this.learningTypeLocalService = learningTypeLocalService;
	}

	/**
	 * Returns the learning type remote service.
	 *
	 * @return the learning type remote service
	 */
	public LearningTypeService getLearningTypeService() {
		return learningTypeService;
	}

	/**
	 * Sets the learning type remote service.
	 *
	 * @param learningTypeService the learning type remote service
	 */
	public void setLearningTypeService(LearningTypeService learningTypeService) {
		this.learningTypeService = learningTypeService;
	}

	/**
	 * Returns the learning type persistence.
	 *
	 * @return the learning type persistence
	 */
	public LearningTypePersistence getLearningTypePersistence() {
		return learningTypePersistence;
	}

	/**
	 * Sets the learning type persistence.
	 *
	 * @param learningTypePersistence the learning type persistence
	 */
	public void setLearningTypePersistence(
		LearningTypePersistence learningTypePersistence) {
		this.learningTypePersistence = learningTypePersistence;
	}

	/**
	 * Returns the test answer local service.
	 *
	 * @return the test answer local service
	 */
	public TestAnswerLocalService getTestAnswerLocalService() {
		return testAnswerLocalService;
	}

	/**
	 * Sets the test answer local service.
	 *
	 * @param testAnswerLocalService the test answer local service
	 */
	public void setTestAnswerLocalService(
		TestAnswerLocalService testAnswerLocalService) {
		this.testAnswerLocalService = testAnswerLocalService;
	}

	/**
	 * Returns the test answer remote service.
	 *
	 * @return the test answer remote service
	 */
	public TestAnswerService getTestAnswerService() {
		return testAnswerService;
	}

	/**
	 * Sets the test answer remote service.
	 *
	 * @param testAnswerService the test answer remote service
	 */
	public void setTestAnswerService(TestAnswerService testAnswerService) {
		this.testAnswerService = testAnswerService;
	}

	/**
	 * Returns the test answer persistence.
	 *
	 * @return the test answer persistence
	 */
	public TestAnswerPersistence getTestAnswerPersistence() {
		return testAnswerPersistence;
	}

	/**
	 * Sets the test answer persistence.
	 *
	 * @param testAnswerPersistence the test answer persistence
	 */
	public void setTestAnswerPersistence(
		TestAnswerPersistence testAnswerPersistence) {
		this.testAnswerPersistence = testAnswerPersistence;
	}

	/**
	 * Returns the test question local service.
	 *
	 * @return the test question local service
	 */
	public TestQuestionLocalService getTestQuestionLocalService() {
		return testQuestionLocalService;
	}

	/**
	 * Sets the test question local service.
	 *
	 * @param testQuestionLocalService the test question local service
	 */
	public void setTestQuestionLocalService(
		TestQuestionLocalService testQuestionLocalService) {
		this.testQuestionLocalService = testQuestionLocalService;
	}

	/**
	 * Returns the test question remote service.
	 *
	 * @return the test question remote service
	 */
	public TestQuestionService getTestQuestionService() {
		return testQuestionService;
	}

	/**
	 * Sets the test question remote service.
	 *
	 * @param testQuestionService the test question remote service
	 */
	public void setTestQuestionService(TestQuestionService testQuestionService) {
		this.testQuestionService = testQuestionService;
	}

	/**
	 * Returns the test question persistence.
	 *
	 * @return the test question persistence
	 */
	public TestQuestionPersistence getTestQuestionPersistence() {
		return testQuestionPersistence;
	}

	/**
	 * Sets the test question persistence.
	 *
	 * @param testQuestionPersistence the test question persistence
	 */
	public void setTestQuestionPersistence(
		TestQuestionPersistence testQuestionPersistence) {
		this.testQuestionPersistence = testQuestionPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	protected Class<?> getModelClass() {
		return LearningActivityResult.class;
	}

	protected String getModelClassName() {
		return LearningActivityResult.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = learningActivityResultPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = LearningActivityLocalService.class)
	protected LearningActivityLocalService learningActivityLocalService;
	@BeanReference(type = LearningActivityService.class)
	protected LearningActivityService learningActivityService;
	@BeanReference(type = LearningActivityPersistence.class)
	protected LearningActivityPersistence learningActivityPersistence;
	@BeanReference(type = LearningActivityResultLocalService.class)
	protected LearningActivityResultLocalService learningActivityResultLocalService;
	@BeanReference(type = LearningActivityResultService.class)
	protected LearningActivityResultService learningActivityResultService;
	@BeanReference(type = LearningActivityResultPersistence.class)
	protected LearningActivityResultPersistence learningActivityResultPersistence;
	@BeanReference(type = LearningActivityTryLocalService.class)
	protected LearningActivityTryLocalService learningActivityTryLocalService;
	@BeanReference(type = LearningActivityTryService.class)
	protected LearningActivityTryService learningActivityTryService;
	@BeanReference(type = LearningActivityTryPersistence.class)
	protected LearningActivityTryPersistence learningActivityTryPersistence;
	@BeanReference(type = LearningTypeLocalService.class)
	protected LearningTypeLocalService learningTypeLocalService;
	@BeanReference(type = LearningTypeService.class)
	protected LearningTypeService learningTypeService;
	@BeanReference(type = LearningTypePersistence.class)
	protected LearningTypePersistence learningTypePersistence;
	@BeanReference(type = TestAnswerLocalService.class)
	protected TestAnswerLocalService testAnswerLocalService;
	@BeanReference(type = TestAnswerService.class)
	protected TestAnswerService testAnswerService;
	@BeanReference(type = TestAnswerPersistence.class)
	protected TestAnswerPersistence testAnswerPersistence;
	@BeanReference(type = TestQuestionLocalService.class)
	protected TestQuestionLocalService testQuestionLocalService;
	@BeanReference(type = TestQuestionService.class)
	protected TestQuestionService testQuestionService;
	@BeanReference(type = TestQuestionPersistence.class)
	protected TestQuestionPersistence testQuestionPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
}