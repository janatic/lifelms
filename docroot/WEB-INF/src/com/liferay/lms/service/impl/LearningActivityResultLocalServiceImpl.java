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

import com.liferay.lms.model.LearningActivityResult;
import com.liferay.lms.model.LearningActivityTry;
import com.liferay.lms.service.base.LearningActivityResultLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;


/**
 * The implementation of the learning activity result local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.lms.service.LearningActivityResultLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link com.liferay.lms.service.LearningActivityResultLocalServiceUtil} to access the learning activity result local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author cvicente
 * @see com.liferay.lms.service.base.LearningActivityResultLocalServiceBaseImpl
 * @see com.liferay.lms.service.LearningActivityResultLocalServiceUtil
 */
public class LearningActivityResultLocalServiceImpl
	extends LearningActivityResultLocalServiceBaseImpl {
	public LearningActivityResult update(LearningActivityTry learningActivityTry) throws SystemException
	{
		LearningActivityResult learningActivityResult=null;
		long actId=learningActivityTry.getActId();
		long userId=learningActivityTry.getUserId();
		if(!existsLearningActivityResult(actId, userId))
		{	
			learningActivityResult=
				learningActivityResultPersistence.create(counterLocalService.increment(
						LearningActivityResult.class.getName()));
			learningActivityResult.setStartDate(learningActivityTry.getStartDate());
			learningActivityResult.setActId(actId);
			learningActivityResult.setUserId(userId);
		}
		else
		{
			learningActivityResult=learningActivityResultPersistence.fetchByact_user(actId, userId);
		}
		learningActivityResult.setEndDate(learningActivityTry.getEndDate());
		learningActivityResult.setResult(learningActivityTry.getResult());
		learningActivityResult.setComments(learningActivityTry.getComments());
		learningActivityResultPersistence.update(learningActivityResult, true);
		return learningActivityResult;
		
	}
	public boolean existsLearningActivityResult(long actId,long userId) throws SystemException
	{
		if(learningActivityResultPersistence.countByact_user(actId, userId)>0)
		{
			return true;
		}
		else
		{
		 
			return false;
		}
	}
	public LearningActivityResult getByActIdAndUserId(long actId,long userId) throws SystemException
	{
		return learningActivityResultPersistence.fetchByact_user(actId, userId);
	}
}