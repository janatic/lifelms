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
 * This class is a wrapper for {@link TestQuestionService}.
 * </p>
 *
 * @author    cvicente
 * @see       TestQuestionService
 * @generated
 */
public class TestQuestionServiceWrapper implements TestQuestionService,
	ServiceWrapper<TestQuestionService> {
	public TestQuestionServiceWrapper(TestQuestionService testQuestionService) {
		_testQuestionService = testQuestionService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TestQuestionService getWrappedTestQuestionService() {
		return _testQuestionService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTestQuestionService(
		TestQuestionService testQuestionService) {
		_testQuestionService = testQuestionService;
	}

	public TestQuestionService getWrappedService() {
		return _testQuestionService;
	}

	public void setWrappedService(TestQuestionService testQuestionService) {
		_testQuestionService = testQuestionService;
	}

	private TestQuestionService _testQuestionService;
}