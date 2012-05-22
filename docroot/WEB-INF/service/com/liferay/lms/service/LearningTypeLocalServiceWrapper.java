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
 * This class is a wrapper for {@link LearningTypeLocalService}.
 * </p>
 *
 * @author    cvicente
 * @see       LearningTypeLocalService
 * @generated
 */
public class LearningTypeLocalServiceWrapper implements LearningTypeLocalService,
	ServiceWrapper<LearningTypeLocalService> {
	public LearningTypeLocalServiceWrapper(
		LearningTypeLocalService learningTypeLocalService) {
		_learningTypeLocalService = learningTypeLocalService;
	}

	/**
	* Adds the learning type to the database. Also notifies the appropriate model listeners.
	*
	* @param learningType the learning type
	* @return the learning type that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.LearningType addLearningType(
		com.liferay.lms.model.LearningType learningType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _learningTypeLocalService.addLearningType(learningType);
	}

	/**
	* Creates a new learning type with the primary key. Does not add the learning type to the database.
	*
	* @param typeId the primary key for the new learning type
	* @return the new learning type
	*/
	public com.liferay.lms.model.LearningType createLearningType(long typeId) {
		return _learningTypeLocalService.createLearningType(typeId);
	}

	/**
	* Deletes the learning type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeId the primary key of the learning type
	* @throws PortalException if a learning type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteLearningType(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_learningTypeLocalService.deleteLearningType(typeId);
	}

	/**
	* Deletes the learning type from the database. Also notifies the appropriate model listeners.
	*
	* @param learningType the learning type
	* @throws SystemException if a system exception occurred
	*/
	public void deleteLearningType(
		com.liferay.lms.model.LearningType learningType)
		throws com.liferay.portal.kernel.exception.SystemException {
		_learningTypeLocalService.deleteLearningType(learningType);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _learningTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _learningTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _learningTypeLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _learningTypeLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.lms.model.LearningType fetchLearningType(long typeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _learningTypeLocalService.fetchLearningType(typeId);
	}

	/**
	* Returns the learning type with the primary key.
	*
	* @param typeId the primary key of the learning type
	* @return the learning type
	* @throws PortalException if a learning type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.LearningType getLearningType(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _learningTypeLocalService.getLearningType(typeId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _learningTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the learning types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of learning types
	* @param end the upper bound of the range of learning types (not inclusive)
	* @return the range of learning types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.lms.model.LearningType> getLearningTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _learningTypeLocalService.getLearningTypes(start, end);
	}

	/**
	* Returns the number of learning types.
	*
	* @return the number of learning types
	* @throws SystemException if a system exception occurred
	*/
	public int getLearningTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _learningTypeLocalService.getLearningTypesCount();
	}

	/**
	* Updates the learning type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param learningType the learning type
	* @return the learning type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.LearningType updateLearningType(
		com.liferay.lms.model.LearningType learningType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _learningTypeLocalService.updateLearningType(learningType);
	}

	/**
	* Updates the learning type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param learningType the learning type
	* @param merge whether to merge the learning type with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the learning type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.LearningType updateLearningType(
		com.liferay.lms.model.LearningType learningType, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _learningTypeLocalService.updateLearningType(learningType, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _learningTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_learningTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LearningTypeLocalService getWrappedLearningTypeLocalService() {
		return _learningTypeLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLearningTypeLocalService(
		LearningTypeLocalService learningTypeLocalService) {
		_learningTypeLocalService = learningTypeLocalService;
	}

	public LearningTypeLocalService getWrappedService() {
		return _learningTypeLocalService;
	}

	public void setWrappedService(
		LearningTypeLocalService learningTypeLocalService) {
		_learningTypeLocalService = learningTypeLocalService;
	}

	private LearningTypeLocalService _learningTypeLocalService;
}