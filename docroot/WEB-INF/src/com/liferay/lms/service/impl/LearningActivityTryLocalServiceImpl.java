/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.lms.service.impl;

import com.liferay.lms.model.LearningActivity;
import com.liferay.lms.model.LearningActivityResult;
import com.liferay.lms.model.LearningActivityTry;
import com.liferay.lms.service.LearningActivityResultLocalServiceUtil;
import com.liferay.lms.service.base.LearningActivityTryLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the learning activity try local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.lms.service.LearningActivityTryLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link com.liferay.lms.service.LearningActivityTryLocalServiceUtil} to access the learning activity try local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author cvicente
 * @see com.liferay.lms.service.base.LearningActivityTryLocalServiceBaseImpl
 * @see com.liferay.lms.service.LearningActivityTryLocalServiceUtil
 */
public class LearningActivityTryLocalServiceImpl
	extends LearningActivityTryLocalServiceBaseImpl {
	@Override
	public LearningActivityTry updateLearningActivityTry(
			LearningActivityTry learningActivityTry) throws SystemException {
		
		return updateLearningActivityTry(learningActivityTry,true);
	}

	@Override
	public LearningActivityTry updateLearningActivityTry(
			LearningActivityTry learningActivityTry, boolean merge)
			throws SystemException {
		
		if(learningActivityTry.getEndDate()!=null)
		{
			LearningActivityResultLocalServiceUtil.update(learningActivityTry)	;
		}
		return super.updateLearningActivityTry(learningActivityTry, merge);
	}

	public LearningActivityTry createLearningActivityTry(long actId,ServiceContext serviceContext) throws SystemException
	{
		LearningActivityTry larnt =
			learningActivityTryPersistence.create(counterLocalService.increment(
					LearningActivityTry.class.getName()));
		larnt.setUserId(serviceContext.getUserId());
		larnt.setActId(actId);
		larnt.setStartDate(new java.util.Date(System.currentTimeMillis()));
		learningActivityTryPersistence.update(larnt, true);
		return larnt;
	}
}