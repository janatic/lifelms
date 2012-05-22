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
import com.liferay.lms.service.LearningActivityLocalServiceUtil;
import com.liferay.lms.service.base.LearningActivityLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

/**
 * The implementation of the learning activity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.lms.service.LearningActivityLocalService} interface.
 * </p>
 * <p>
 * Never reference this interface directly. Always use {@link com.liferay.lms.service.LearningActivityLocalServiceUtil} to access the learning activity local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author cvicente
 * @see com.liferay.lms.service.base.LearningActivityLocalServiceBaseImpl
 * @see com.liferay.lms.service.LearningActivityLocalServiceUtil
 */
public class LearningActivityLocalServiceImpl
	extends LearningActivityLocalServiceBaseImpl {
	public LearningActivity addLearningActivity (String title, String description, java.util.Date createDate, int typeId,
			ServiceContext serviceContext)
			throws SystemException, 
			PortalException {
		
		long userId=serviceContext.getUserId();
		LearningActivity larn =
				learningActivityPersistence.create(counterLocalService.increment(
						LearningActivity.class.getName()));
			larn.setCompanyId(serviceContext.getCompanyId());
			larn.setGroupId(serviceContext.getScopeGroupId());
			larn.setUserId(userId);
			larn.setCreateDate(serviceContext.getCreateDate());
			larn.setDescription(description);
			larn.setTypeId(typeId);
			larn.setTitle(title);
			larn.setStatus(WorkflowConstants.STATUS_APPROVED);
			learningActivityPersistence.update(larn, false);
			try
			{
			resourceLocalService.addResources(
					serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), userId,
			LearningActivity.class.getName(), larn.getPrimaryKey(), false,
			true, true);
	
			assetEntryLocalService.updateEntry(
					userId, larn.getGroupId(), LearningActivity.class.getName(),
					larn.getActId(), larn.getUuid(),0, serviceContext.getAssetCategoryIds(),
					serviceContext.getAssetTagNames(), true, null, null,
					new java.util.Date(System.currentTimeMillis()), null,
					ContentTypes.TEXT_HTML, larn.getTitle(), null, larn.getDescription(),null, null, 0, 0,
					null, false);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return larn;
			}
	public LearningActivity modLearningActivity (LearningActivity larn, 
			ServiceContext serviceContext)
			throws SystemException, PortalException {
			
			learningActivityPersistence.update(larn, false);
			long userId=serviceContext.getUserId();
		
			assetEntryLocalService.updateEntry(
					userId, larn.getGroupId(), LearningActivity.class.getName(),
					larn.getActId(), larn.getUuid(),0, serviceContext.getAssetCategoryIds(),
					serviceContext.getAssetTagNames(), true, null, null, 
					new java.util.Date(System.currentTimeMillis()), null,
					ContentTypes.TEXT_HTML, larn.getTitle(), null, larn.getDescription(),null, null, 0, 0,
					null, false);
			return larn;
		
			}
	public java.util.List<LearningActivity> getLearningActivitiesOfGroup(long groupId) throws SystemException
	{
		return learningActivityPersistence.findByg(groupId, 0, 1000);
	}
	public void deleteLearningactivity (LearningActivity lernact) throws SystemException,
	PortalException {
	long companyId = lernact.getCompanyId();
	resourceLocalService.deleteResource(
	companyId, LearningActivity.class.getName(),
	ResourceConstants.SCOPE_INDIVIDUAL, lernact.getPrimaryKey());
	assetEntryLocalService.deleteEntry(
			LearningActivity.class.getName(), lernact.getActId());
	learningActivityPersistence.remove(lernact);
	}
	public void deleteLearningactivity (long actId) throws SystemException,
	PortalException {
	this.deleteLearningactivity(LearningActivityLocalServiceUtil.getLearningActivity(actId));
	}
	
}