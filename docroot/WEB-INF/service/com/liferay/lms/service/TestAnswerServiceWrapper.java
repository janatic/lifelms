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
 * This class is a wrapper for {@link TestAnswerService}.
 * </p>
 *
 * @author    cvicente
 * @see       TestAnswerService
 * @generated
 */
public class TestAnswerServiceWrapper implements TestAnswerService,
	ServiceWrapper<TestAnswerService> {
	public TestAnswerServiceWrapper(TestAnswerService testAnswerService) {
		_testAnswerService = testAnswerService;
	}

	public java.util.List<com.liferay.lms.model.TestAnswer> getTestAnswersByQuestionId(
		long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _testAnswerService.getTestAnswersByQuestionId(questionId);
	}

	public com.liferay.lms.model.TestAnswer getTestAnswer(long answerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _testAnswerService.getTestAnswer(answerId);
	}

	public com.liferay.lms.model.TestAnswer modTestAnswer(
		com.liferay.lms.model.TestAnswer testAnswer)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _testAnswerService.modTestAnswer(testAnswer);
	}

	public com.liferay.lms.model.TestAnswer addTestAnswer(long questionId,
		java.lang.String answer, boolean correct)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _testAnswerService.addTestAnswer(questionId, answer, correct);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TestAnswerService getWrappedTestAnswerService() {
		return _testAnswerService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTestAnswerService(TestAnswerService testAnswerService) {
		_testAnswerService = testAnswerService;
	}

	public TestAnswerService getWrappedService() {
		return _testAnswerService;
	}

	public void setWrappedService(TestAnswerService testAnswerService) {
		_testAnswerService = testAnswerService;
	}

	private TestAnswerService _testAnswerService;
}