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
 * This class is a wrapper for {@link LearningActivityResultService}.
 * </p>
 *
 * @author    cvicente
 * @see       LearningActivityResultService
 * @generated
 */
public class LearningActivityResultServiceWrapper
	implements LearningActivityResultService,
		ServiceWrapper<LearningActivityResultService> {
	public LearningActivityResultServiceWrapper(
		LearningActivityResultService learningActivityResultService) {
		_learningActivityResultService = learningActivityResultService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LearningActivityResultService getWrappedLearningActivityResultService() {
		return _learningActivityResultService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLearningActivityResultService(
		LearningActivityResultService learningActivityResultService) {
		_learningActivityResultService = learningActivityResultService;
	}

	public LearningActivityResultService getWrappedService() {
		return _learningActivityResultService;
	}

	public void setWrappedService(
		LearningActivityResultService learningActivityResultService) {
		_learningActivityResultService = learningActivityResultService;
	}

	private LearningActivityResultService _learningActivityResultService;
}