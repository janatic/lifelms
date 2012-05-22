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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TestQuestionLocalService}.
 * </p>
 *
 * @author    cvicente
 * @see       TestQuestionLocalService
 * @generated
 */
public class TestQuestionLocalServiceWrapper implements TestQuestionLocalService,
	ServiceWrapper<TestQuestionLocalService> {
	public TestQuestionLocalServiceWrapper(
		TestQuestionLocalService testQuestionLocalService) {
		_testQuestionLocalService = testQuestionLocalService;
	}

	/**
	* Adds the test question to the database. Also notifies the appropriate model listeners.
	*
	* @param testQuestion the test question
	* @return the test question that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.TestQuestion addTestQuestion(
		com.liferay.lms.model.TestQuestion testQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testQuestionLocalService.addTestQuestion(testQuestion);
	}

	/**
	* Creates a new test question with the primary key. Does not add the test question to the database.
	*
	* @param questionId the primary key for the new test question
	* @return the new test question
	*/
	public com.liferay.lms.model.TestQuestion createTestQuestion(
		long questionId) {
		return _testQuestionLocalService.createTestQuestion(questionId);
	}

	/**
	* Deletes the test question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionId the primary key of the test question
	* @throws PortalException if a test question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTestQuestion(long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_testQuestionLocalService.deleteTestQuestion(questionId);
	}

	/**
	* Deletes the test question from the database. Also notifies the appropriate model listeners.
	*
	* @param testQuestion the test question
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTestQuestion(
		com.liferay.lms.model.TestQuestion testQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		_testQuestionLocalService.deleteTestQuestion(testQuestion);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testQuestionLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _testQuestionLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testQuestionLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testQuestionLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.lms.model.TestQuestion fetchTestQuestion(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testQuestionLocalService.fetchTestQuestion(questionId);
	}

	/**
	* Returns the test question with the primary key.
	*
	* @param questionId the primary key of the test question
	* @return the test question
	* @throws PortalException if a test question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.TestQuestion getTestQuestion(long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _testQuestionLocalService.getTestQuestion(questionId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _testQuestionLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.liferay.lms.model.TestQuestion> getTestQuestions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testQuestionLocalService.getTestQuestions(start, end);
	}

	/**
	* Returns the number of test questions.
	*
	* @return the number of test questions
	* @throws SystemException if a system exception occurred
	*/
	public int getTestQuestionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testQuestionLocalService.getTestQuestionsCount();
	}

	/**
	* Updates the test question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param testQuestion the test question
	* @return the test question that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.TestQuestion updateTestQuestion(
		com.liferay.lms.model.TestQuestion testQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testQuestionLocalService.updateTestQuestion(testQuestion);
	}

	/**
	* Updates the test question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param testQuestion the test question
	* @param merge whether to merge the test question with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the test question that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.TestQuestion updateTestQuestion(
		com.liferay.lms.model.TestQuestion testQuestion, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testQuestionLocalService.updateTestQuestion(testQuestion, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _testQuestionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_testQuestionLocalService.setBeanIdentifier(beanIdentifier);
	}

	public com.liferay.lms.model.TestQuestion addQuestion(long actId,
		java.lang.String text, long questionType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testQuestionLocalService.addQuestion(actId, text, questionType);
	}

	public java.util.List<com.liferay.lms.model.TestQuestion> getQuestions(
		long actid) throws com.liferay.portal.kernel.exception.SystemException {
		return _testQuestionLocalService.getQuestions(actid);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TestQuestionLocalService getWrappedTestQuestionLocalService() {
		return _testQuestionLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTestQuestionLocalService(
		TestQuestionLocalService testQuestionLocalService) {
		_testQuestionLocalService = testQuestionLocalService;
	}

	public TestQuestionLocalService getWrappedService() {
		return _testQuestionLocalService;
	}

	public void setWrappedService(
		TestQuestionLocalService testQuestionLocalService) {
		_testQuestionLocalService = testQuestionLocalService;
	}

	private TestQuestionLocalService _testQuestionLocalService;
}