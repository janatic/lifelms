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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the learning type local service. This utility wraps {@link com.liferay.lms.service.impl.LearningTypeLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author cvicente
 * @see LearningTypeLocalService
 * @see com.liferay.lms.service.base.LearningTypeLocalServiceBaseImpl
 * @see com.liferay.lms.service.impl.LearningTypeLocalServiceImpl
 * @generated
 */
public class LearningTypeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.lms.service.impl.LearningTypeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the learning type to the database. Also notifies the appropriate model listeners.
	*
	* @param learningType the learning type
	* @return the learning type that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.LearningType addLearningType(
		com.liferay.lms.model.LearningType learningType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLearningType(learningType);
	}

	/**
	* Creates a new learning type with the primary key. Does not add the learning type to the database.
	*
	* @param typeId the primary key for the new learning type
	* @return the new learning type
	*/
	public static com.liferay.lms.model.LearningType createLearningType(
		long typeId) {
		return getService().createLearningType(typeId);
	}

	/**
	* Deletes the learning type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeId the primary key of the learning type
	* @throws PortalException if a learning type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLearningType(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLearningType(typeId);
	}

	/**
	* Deletes the learning type from the database. Also notifies the appropriate model listeners.
	*
	* @param learningType the learning type
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLearningType(
		com.liferay.lms.model.LearningType learningType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLearningType(learningType);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.liferay.lms.model.LearningType fetchLearningType(
		long typeId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLearningType(typeId);
	}

	/**
	* Returns the learning type with the primary key.
	*
	* @param typeId the primary key of the learning type
	* @return the learning type
	* @throws PortalException if a learning type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.LearningType getLearningType(
		long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLearningType(typeId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.liferay.lms.model.LearningType> getLearningTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLearningTypes(start, end);
	}

	/**
	* Returns the number of learning types.
	*
	* @return the number of learning types
	* @throws SystemException if a system exception occurred
	*/
	public static int getLearningTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLearningTypesCount();
	}

	/**
	* Updates the learning type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param learningType the learning type
	* @return the learning type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.LearningType updateLearningType(
		com.liferay.lms.model.LearningType learningType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLearningType(learningType);
	}

	/**
	* Updates the learning type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param learningType the learning type
	* @param merge whether to merge the learning type with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the learning type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.LearningType updateLearningType(
		com.liferay.lms.model.LearningType learningType, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLearningType(learningType, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static void clearService() {
		_service = null;
	}

	public static LearningTypeLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LearningTypeLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					LearningTypeLocalService.class.getName(), portletClassLoader);

			_service = new LearningTypeLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(LearningTypeLocalServiceUtil.class,
				"_service");
			MethodCache.remove(LearningTypeLocalService.class);
		}

		return _service;
	}

	public void setService(LearningTypeLocalService service) {
		MethodCache.remove(LearningTypeLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(LearningTypeLocalServiceUtil.class,
			"_service");
		MethodCache.remove(LearningTypeLocalService.class);
	}

	private static LearningTypeLocalService _service;
}