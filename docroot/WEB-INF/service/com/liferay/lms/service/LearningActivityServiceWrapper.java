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
 * This class is a wrapper for {@link LearningActivityService}.
 * </p>
 *
 * @author    cvicente
 * @see       LearningActivityService
 * @generated
 */
public class LearningActivityServiceWrapper implements LearningActivityService,
	ServiceWrapper<LearningActivityService> {
	public LearningActivityServiceWrapper(
		LearningActivityService learningActivityService) {
		_learningActivityService = learningActivityService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LearningActivityService getWrappedLearningActivityService() {
		return _learningActivityService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLearningActivityService(
		LearningActivityService learningActivityService) {
		_learningActivityService = learningActivityService;
	}

	public LearningActivityService getWrappedService() {
		return _learningActivityService;
	}

	public void setWrappedService(
		LearningActivityService learningActivityService) {
		_learningActivityService = learningActivityService;
	}

	private LearningActivityService _learningActivityService;
}