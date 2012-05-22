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
 * This class is a wrapper for {@link LearningTypeService}.
 * </p>
 *
 * @author    cvicente
 * @see       LearningTypeService
 * @generated
 */
public class LearningTypeServiceWrapper implements LearningTypeService,
	ServiceWrapper<LearningTypeService> {
	public LearningTypeServiceWrapper(LearningTypeService learningTypeService) {
		_learningTypeService = learningTypeService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LearningTypeService getWrappedLearningTypeService() {
		return _learningTypeService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLearningTypeService(
		LearningTypeService learningTypeService) {
		_learningTypeService = learningTypeService;
	}

	public LearningTypeService getWrappedService() {
		return _learningTypeService;
	}

	public void setWrappedService(LearningTypeService learningTypeService) {
		_learningTypeService = learningTypeService;
	}

	private LearningTypeService _learningTypeService;
}