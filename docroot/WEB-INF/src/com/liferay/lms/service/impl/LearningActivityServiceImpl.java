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
import com.liferay.lms.service.base.LearningActivityServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the learning activity remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.lms.service.LearningActivityService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link com.liferay.lms.service.LearningActivityServiceUtil} to access the learning activity remote service.
 * </p>
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author cvicente
 * @see com.liferay.lms.service.base.LearningActivityServiceBaseImpl
 * @see com.liferay.lms.service.LearningActivityServiceUtil
 */
@JSONWebService
public class LearningActivityServiceImpl extends LearningActivityServiceBaseImpl 
{
	public java.util.List<LearningActivity> getLearningActivitiesOfGroup(long groupId) throws SystemException
	{
		return learningActivityPersistence.filterFindByg(groupId, 0, 1000);
	}
	public void deleteLearningactivity (LearningActivity lernact) throws SystemException,
	PortalException {
		if( getPermissionChecker().hasPermission(lernact.getGroupId(), LearningActivity.class.getName(), lernact.getActId(),
				ActionKeys.DELETE))
		{
			learningActivityLocalService.deleteLearningactivity(lernact);
		}
	}
	public void deleteLearningactivity (long actId) throws SystemException,
	PortalException {
		LearningActivity lernact=this.getLearningActivity(actId);
		if( getPermissionChecker().hasPermission(lernact.getGroupId(), LearningActivity.class.getName(), lernact.getActId(),
				ActionKeys.DELETE))
		{
			learningActivityLocalService.deleteLearningactivity(lernact);
		}
	}
	public LearningActivity getLearningActivity(long actId) throws PortalException, SystemException 
	{
		
	    LearningActivity lernact=learningActivityLocalService.getLearningActivity(actId);
		if( getPermissionChecker().hasPermission(lernact.getGroupId(), LearningActivity.class.getName(), lernact.getActId(),
				ActionKeys.VIEW))
		{
			return lernact;
		}
		else
		{
			return null;
		}
	}
	public LearningActivity addLearningActivity (String title, String description, java.util.Date createDate,java.util.Date startDate,java.util.Date endDate, int typeId,long tries,
			ServiceContext serviceContext)
			throws SystemException, 
			PortalException {
		if( getPermissionChecker().hasPermission(serviceContext.getScopeGroupId(),  LearningActivity.class.getName(),0,ActionKeys.ADD_ENTRY))
		{
		return learningActivityLocalService.addLearningActivity(title, description, createDate, startDate, endDate, typeId, tries, serviceContext);
		}
		else
		{
			return null;
		}
	}
	public LearningActivity modLearningActivity (LearningActivity lernact, 
			ServiceContext serviceContext)
			throws SystemException, PortalException {
		if( getPermissionChecker().hasPermission(lernact.getGroupId(), LearningActivity.class.getName(), lernact.getActId(),
				ActionKeys.UPDATE))
		{
		return modLearningActivity(lernact, serviceContext);
		}
		else
		{
			return null;
		}
	}
	public LearningActivity modLearningActivity (long actId,String title, String description, java.util.Date createDate,java.util.Date startDate,java.util.Date endDate, int typeId,long tries,
			ServiceContext serviceContext) throws SystemException, 
			PortalException
	{
		if( getPermissionChecker().hasPermission(serviceContext.getScopeGroupId(), LearningActivity.class.getName(), actId,
				ActionKeys.UPDATE))
		{
	  return modLearningActivity(actId, title, description, createDate, startDate, endDate, typeId, tries, serviceContext);
		}
		else
		{
			return null;
		}
	}
}