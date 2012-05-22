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
 * This class is a wrapper for {@link LearningType}.
 * </p>
 *
 * @author    cvicente
 * @see       LearningType
 * @generated
 */
public class LearningTypeWrapper implements LearningType,
	ModelWrapper<LearningType> {
	public LearningTypeWrapper(LearningType learningType) {
		_learningType = learningType;
	}

	public Class<?> getModelClass() {
		return LearningType.class;
	}

	public String getModelClassName() {
		return LearningType.class.getName();
	}

	/**
	* Returns the primary key of this learning type.
	*
	* @return the primary key of this learning type
	*/
	public long getPrimaryKey() {
		return _learningType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this learning type.
	*
	* @param primaryKey the primary key of this learning type
	*/
	public void setPrimaryKey(long primaryKey) {
		_learningType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this learning type.
	*
	* @return the uuid of this learning type
	*/
	public java.lang.String getUuid() {
		return _learningType.getUuid();
	}

	/**
	* Sets the uuid of this learning type.
	*
	* @param uuid the uuid of this learning type
	*/
	public void setUuid(java.lang.String uuid) {
		_learningType.setUuid(uuid);
	}

	/**
	* Returns the type ID of this learning type.
	*
	* @return the type ID of this learning type
	*/
	public long getTypeId() {
		return _learningType.getTypeId();
	}

	/**
	* Sets the type ID of this learning type.
	*
	* @param typeId the type ID of this learning type
	*/
	public void setTypeId(long typeId) {
		_learningType.setTypeId(typeId);
	}

	/**
	* Returns the name of this learning type.
	*
	* @return the name of this learning type
	*/
	public java.lang.String getName() {
		return _learningType.getName();
	}

	/**
	* Sets the name of this learning type.
	*
	* @param name the name of this learning type
	*/
	public void setName(java.lang.String name) {
		_learningType.setName(name);
	}

	/**
	* Returns the class name of this learning type.
	*
	* @return the class name of this learning type
	*/
	public java.lang.String getClassName() {
		return _learningType.getClassName();
	}

	/**
	* Sets the class name of this learning type.
	*
	* @param className the class name of this learning type
	*/
	public void setClassName(java.lang.String className) {
		_learningType.setClassName(className);
	}

	public boolean isNew() {
		return _learningType.isNew();
	}

	public void setNew(boolean n) {
		_learningType.setNew(n);
	}

	public boolean isCachedModel() {
		return _learningType.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_learningType.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _learningType.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _learningType.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_learningType.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _learningType.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_learningType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LearningTypeWrapper((LearningType)_learningType.clone());
	}

	public int compareTo(com.liferay.lms.model.LearningType learningType) {
		return _learningType.compareTo(learningType);
	}

	@Override
	public int hashCode() {
		return _learningType.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.lms.model.LearningType> toCacheModel() {
		return _learningType.toCacheModel();
	}

	public com.liferay.lms.model.LearningType toEscapedModel() {
		return new LearningTypeWrapper(_learningType.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _learningType.toString();
	}

	public java.lang.String toXmlString() {
		return _learningType.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_learningType.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public LearningType getWrappedLearningType() {
		return _learningType;
	}

	public LearningType getWrappedModel() {
		return _learningType;
	}

	public void resetOriginalValues() {
		_learningType.resetOriginalValues();
	}

	private LearningType _learningType;
}