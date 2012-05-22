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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the LearningActivityResult service. Represents a row in the &quot;Lms_LearningActivityResult&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.lms.model.impl.LearningActivityResultModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.lms.model.impl.LearningActivityResultImpl}.
 * </p>
 *
 * @author cvicente
 * @see LearningActivityResult
 * @see com.liferay.lms.model.impl.LearningActivityResultImpl
 * @see com.liferay.lms.model.impl.LearningActivityResultModelImpl
 * @generated
 */
public interface LearningActivityResultModel extends BaseModel<LearningActivityResult> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a learning activity result model instance should use the {@link LearningActivityResult} interface instead.
	 */

	/**
	 * Returns the primary key of this learning activity result.
	 *
	 * @return the primary key of this learning activity result
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this learning activity result.
	 *
	 * @param primaryKey the primary key of this learning activity result
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this learning activity result.
	 *
	 * @return the uuid of this learning activity result
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this learning activity result.
	 *
	 * @param uuid the uuid of this learning activity result
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the lar ID of this learning activity result.
	 *
	 * @return the lar ID of this learning activity result
	 */
	public long getLarId();

	/**
	 * Sets the lar ID of this learning activity result.
	 *
	 * @param larId the lar ID of this learning activity result
	 */
	public void setLarId(long larId);

	/**
	 * Returns the act ID of this learning activity result.
	 *
	 * @return the act ID of this learning activity result
	 */
	public long getActId();

	/**
	 * Sets the act ID of this learning activity result.
	 *
	 * @param actId the act ID of this learning activity result
	 */
	public void setActId(long actId);

	/**
	 * Returns the user ID of this learning activity result.
	 *
	 * @return the user ID of this learning activity result
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this learning activity result.
	 *
	 * @param userId the user ID of this learning activity result
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this learning activity result.
	 *
	 * @return the user uuid of this learning activity result
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this learning activity result.
	 *
	 * @param userUuid the user uuid of this learning activity result
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the result of this learning activity result.
	 *
	 * @return the result of this learning activity result
	 */
	public long getResult();

	/**
	 * Sets the result of this learning activity result.
	 *
	 * @param result the result of this learning activity result
	 */
	public void setResult(long result);

	/**
	 * Returns the end date of this learning activity result.
	 *
	 * @return the end date of this learning activity result
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this learning activity result.
	 *
	 * @param endDate the end date of this learning activity result
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the lat ID of this learning activity result.
	 *
	 * @return the lat ID of this learning activity result
	 */
	public long getLatId();

	/**
	 * Sets the lat ID of this learning activity result.
	 *
	 * @param latId the lat ID of this learning activity result
	 */
	public void setLatId(long latId);

	/**
	 * Returns the comments of this learning activity result.
	 *
	 * @return the comments of this learning activity result
	 */
	@AutoEscape
	public String getComments();

	/**
	 * Sets the comments of this learning activity result.
	 *
	 * @param comments the comments of this learning activity result
	 */
	public void setComments(String comments);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(LearningActivityResult learningActivityResult);

	public int hashCode();

	public CacheModel<LearningActivityResult> toCacheModel();

	public LearningActivityResult toEscapedModel();

	public String toString();

	public String toXmlString();
}