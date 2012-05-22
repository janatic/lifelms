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

package com.liferay.lms.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LearningActivity}.
 * </p>
 *
 * @author    cvicente
 * @see       LearningActivity
 * @generated
 */
public class LearningActivityWrapper implements LearningActivity,
	ModelWrapper<LearningActivity> {
	public LearningActivityWrapper(LearningActivity learningActivity) {
		_learningActivity = learningActivity;
	}

	public Class<?> getModelClass() {
		return LearningActivity.class;
	}

	public String getModelClassName() {
		return LearningActivity.class.getName();
	}

	/**
	* Returns the primary key of this learning activity.
	*
	* @return the primary key of this learning activity
	*/
	public long getPrimaryKey() {
		return _learningActivity.getPrimaryKey();
	}

	/**
	* Sets the primary key of this learning activity.
	*
	* @param primaryKey the primary key of this learning activity
	*/
	public void setPrimaryKey(long primaryKey) {
		_learningActivity.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this learning activity.
	*
	* @return the uuid of this learning activity
	*/
	public java.lang.String getUuid() {
		return _learningActivity.getUuid();
	}

	/**
	* Sets the uuid of this learning activity.
	*
	* @param uuid the uuid of this learning activity
	*/
	public void setUuid(java.lang.String uuid) {
		_learningActivity.setUuid(uuid);
	}

	/**
	* Returns the act ID of this learning activity.
	*
	* @return the act ID of this learning activity
	*/
	public long getActId() {
		return _learningActivity.getActId();
	}

	/**
	* Sets the act ID of this learning activity.
	*
	* @param actId the act ID of this learning activity
	*/
	public void setActId(long actId) {
		_learningActivity.setActId(actId);
	}

	/**
	* Returns the company ID of this learning activity.
	*
	* @return the company ID of this learning activity
	*/
	public long getCompanyId() {
		return _learningActivity.getCompanyId();
	}

	/**
	* Sets the company ID of this learning activity.
	*
	* @param companyId the company ID of this learning activity
	*/
	public void setCompanyId(long companyId) {
		_learningActivity.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this learning activity.
	*
	* @return the user ID of this learning activity
	*/
	public long getUserId() {
		return _learningActivity.getUserId();
	}

	/**
	* Sets the user ID of this learning activity.
	*
	* @param userId the user ID of this learning activity
	*/
	public void setUserId(long userId) {
		_learningActivity.setUserId(userId);
	}

	/**
	* Returns the user uuid of this learning activity.
	*
	* @return the user uuid of this learning activity
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _learningActivity.getUserUuid();
	}

	/**
	* Sets the user uuid of this learning activity.
	*
	* @param userUuid the user uuid of this learning activity
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_learningActivity.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this learning activity.
	*
	* @return the group ID of this learning activity
	*/
	public long getGroupId() {
		return _learningActivity.getGroupId();
	}

	/**
	* Sets the group ID of this learning activity.
	*
	* @param groupId the group ID of this learning activity
	*/
	public void setGroupId(long groupId) {
		_learningActivity.setGroupId(groupId);
	}

	/**
	* Returns the user name of this learning activity.
	*
	* @return the user name of this learning activity
	*/
	public java.lang.String getUserName() {
		return _learningActivity.getUserName();
	}

	/**
	* Sets the user name of this learning activity.
	*
	* @param userName the user name of this learning activity
	*/
	public void setUserName(java.lang.String userName) {
		_learningActivity.setUserName(userName);
	}

	/**
	* Returns the create date of this learning activity.
	*
	* @return the create date of this learning activity
	*/
	public java.util.Date getCreateDate() {
		return _learningActivity.getCreateDate();
	}

	/**
	* Sets the create date of this learning activity.
	*
	* @param createDate the create date of this learning activity
	*/
	public void setCreateDate(java.util.Date createDate) {
		_learningActivity.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this learning activity.
	*
	* @return the modified date of this learning activity
	*/
	public java.util.Date getModifiedDate() {
		return _learningActivity.getModifiedDate();
	}

	/**
	* Sets the modified date of this learning activity.
	*
	* @param modifiedDate the modified date of this learning activity
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_learningActivity.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the status of this learning activity.
	*
	* @return the status of this learning activity
	*/
	public int getStatus() {
		return _learningActivity.getStatus();
	}

	/**
	* Sets the status of this learning activity.
	*
	* @param status the status of this learning activity
	*/
	public void setStatus(int status) {
		_learningActivity.setStatus(status);
	}

	/**
	* Returns the status by user ID of this learning activity.
	*
	* @return the status by user ID of this learning activity
	*/
	public long getStatusByUserId() {
		return _learningActivity.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this learning activity.
	*
	* @param statusByUserId the status by user ID of this learning activity
	*/
	public void setStatusByUserId(long statusByUserId) {
		_learningActivity.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this learning activity.
	*
	* @return the status by user uuid of this learning activity
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _learningActivity.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this learning activity.
	*
	* @param statusByUserUuid the status by user uuid of this learning activity
	*/
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_learningActivity.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this learning activity.
	*
	* @return the status by user name of this learning activity
	*/
	public java.lang.String getStatusByUserName() {
		return _learningActivity.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this learning activity.
	*
	* @param statusByUserName the status by user name of this learning activity
	*/
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_learningActivity.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this learning activity.
	*
	* @return the status date of this learning activity
	*/
	public java.util.Date getStatusDate() {
		return _learningActivity.getStatusDate();
	}

	/**
	* Sets the status date of this learning activity.
	*
	* @param statusDate the status date of this learning activity
	*/
	public void setStatusDate(java.util.Date statusDate) {
		_learningActivity.setStatusDate(statusDate);
	}

	/**
	* Returns the title of this learning activity.
	*
	* @return the title of this learning activity
	*/
	public java.lang.String getTitle() {
		return _learningActivity.getTitle();
	}

	/**
	* Sets the title of this learning activity.
	*
	* @param title the title of this learning activity
	*/
	public void setTitle(java.lang.String title) {
		_learningActivity.setTitle(title);
	}

	/**
	* Returns the description of this learning activity.
	*
	* @return the description of this learning activity
	*/
	public java.lang.String getDescription() {
		return _learningActivity.getDescription();
	}

	/**
	* Sets the description of this learning activity.
	*
	* @param description the description of this learning activity
	*/
	public void setDescription(java.lang.String description) {
		_learningActivity.setDescription(description);
	}

	/**
	* Returns the type ID of this learning activity.
	*
	* @return the type ID of this learning activity
	*/
	public int getTypeId() {
		return _learningActivity.getTypeId();
	}

	/**
	* Sets the type ID of this learning activity.
	*
	* @param typeId the type ID of this learning activity
	*/
	public void setTypeId(int typeId) {
		_learningActivity.setTypeId(typeId);
	}

	/**
	* Returns the startdate of this learning activity.
	*
	* @return the startdate of this learning activity
	*/
	public java.util.Date getStartdate() {
		return _learningActivity.getStartdate();
	}

	/**
	* Sets the startdate of this learning activity.
	*
	* @param startdate the startdate of this learning activity
	*/
	public void setStartdate(java.util.Date startdate) {
		_learningActivity.setStartdate(startdate);
	}

	/**
	* Returns the enddate of this learning activity.
	*
	* @return the enddate of this learning activity
	*/
	public java.util.Date getEnddate() {
		return _learningActivity.getEnddate();
	}

	/**
	* Sets the enddate of this learning activity.
	*
	* @param enddate the enddate of this learning activity
	*/
	public void setEnddate(java.util.Date enddate) {
		_learningActivity.setEnddate(enddate);
	}

	/**
	* Returns the precedence of this learning activity.
	*
	* @return the precedence of this learning activity
	*/
	public int getPrecedence() {
		return _learningActivity.getPrecedence();
	}

	/**
	* Sets the precedence of this learning activity.
	*
	* @param precedence the precedence of this learning activity
	*/
	public void setPrecedence(int precedence) {
		_learningActivity.setPrecedence(precedence);
	}

	/**
	* @deprecated Renamed to {@link #isApproved()}
	*/
	public boolean getApproved() {
		return _learningActivity.getApproved();
	}

	/**
	* Returns <code>true</code> if this learning activity is approved.
	*
	* @return <code>true</code> if this learning activity is approved; <code>false</code> otherwise
	*/
	public boolean isApproved() {
		return _learningActivity.isApproved();
	}

	/**
	* Returns <code>true</code> if this learning activity is a draft.
	*
	* @return <code>true</code> if this learning activity is a draft; <code>false</code> otherwise
	*/
	public boolean isDraft() {
		return _learningActivity.isDraft();
	}

	/**
	* Returns <code>true</code> if this learning activity is expired.
	*
	* @return <code>true</code> if this learning activity is expired; <code>false</code> otherwise
	*/
	public boolean isExpired() {
		return _learningActivity.isExpired();
	}

	/**
	* Returns <code>true</code> if this learning activity is pending.
	*
	* @return <code>true</code> if this learning activity is pending; <code>false</code> otherwise
	*/
	public boolean isPending() {
		return _learningActivity.isPending();
	}

	public boolean isNew() {
		return _learningActivity.isNew();
	}

	public void setNew(boolean n) {
		_learningActivity.setNew(n);
	}

	public boolean isCachedModel() {
		return _learningActivity.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_learningActivity.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _learningActivity.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _learningActivity.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_learningActivity.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _learningActivity.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_learningActivity.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LearningActivityWrapper((LearningActivity)_learningActivity.clone());
	}

	public int compareTo(
		com.liferay.lms.model.LearningActivity learningActivity) {
		return _learningActivity.compareTo(learningActivity);
	}

	@Override
	public int hashCode() {
		return _learningActivity.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.lms.model.LearningActivity> toCacheModel() {
		return _learningActivity.toCacheModel();
	}

	public com.liferay.lms.model.LearningActivity toEscapedModel() {
		return new LearningActivityWrapper(_learningActivity.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _learningActivity.toString();
	}

	public java.lang.String toXmlString() {
		return _learningActivity.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_learningActivity.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public LearningActivity getWrappedLearningActivity() {
		return _learningActivity;
	}

	public LearningActivity getWrappedModel() {
		return _learningActivity;
	}

	public void resetOriginalValues() {
		_learningActivity.resetOriginalValues();
	}

	private LearningActivity _learningActivity;
}