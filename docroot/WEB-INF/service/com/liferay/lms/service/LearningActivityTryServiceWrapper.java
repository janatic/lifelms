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
 * This class is a wrapper for {@link LearningActivityTryService}.
 * </p>
 *
 * @author    cvicente
 * @see       LearningActivityTryService
 * @generated
 */
public class LearningActivityTryServiceWrapper
	implements LearningActivityTryService,
		ServiceWrapper<LearningActivityTryService> {
	public LearningActivityTryServiceWrapper(
		LearningActivityTryService learningActivityTryService) {
		_learningActivityTryService = learningActivityTryService;
	}

	public com.liferay.lms.model.LearningActivityTry createLearningActivityTry(
		long actId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _learningActivityTryService.createLearningActivityTry(actId,
			userId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LearningActivityTryService getWrappedLearningActivityTryService() {
		return _learningActivityTryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLearningActivityTryService(
		LearningActivityTryService learningActivityTryService) {
		_learningActivityTryService = learningActivityTryService;
	}

	public LearningActivityTryService getWrappedService() {
		return _learningActivityTryService;
	}

	public void setWrappedService(
		LearningActivityTryService learningActivityTryService) {
		_learningActivityTryService = learningActivityTryService;
	}

	private LearningActivityTryService _learningActivityTryService;
}