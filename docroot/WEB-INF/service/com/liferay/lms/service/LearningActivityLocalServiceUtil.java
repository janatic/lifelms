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
 * The utility for the learning activity local service. This utility wraps {@link com.liferay.lms.service.impl.LearningActivityLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author cvicente
 * @see LearningActivityLocalService
 * @see com.liferay.lms.service.base.LearningActivityLocalServiceBaseImpl
 * @see com.liferay.lms.service.impl.LearningActivityLocalServiceImpl
 * @generated
 */
public class LearningActivityLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.lms.service.impl.LearningActivityLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the learning activity to the database. Also notifies the appropriate model listeners.
	*
	* @param learningActivity the learning activity
	* @return the learning activity that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.LearningActivity addLearningActivity(
		com.liferay.lms.model.LearningActivity learningActivity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLearningActivity(learningActivity);
	}

	/**
	* Creates a new learning activity with the primary key. Does not add the learning activity to the database.
	*
	* @param actId the primary key for the new learning activity
	* @return the new learning activity
	*/
	public static com.liferay.lms.model.LearningActivity createLearningActivity(
		long actId) {
		return getService().createLearningActivity(actId);
	}

	/**
	* Deletes the learning activity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param actId the primary key of the learning activity
	* @throws PortalException if a learning activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLearningActivity(long actId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLearningActivity(actId);
	}

	/**
	* Deletes the learning activity from the database. Also notifies the appropriate model listeners.
	*
	* @param learningActivity the learning activity
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLearningActivity(
		com.liferay.lms.model.LearningActivity learningActivity)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLearningActivity(learningActivity);
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

	public static com.liferay.lms.model.LearningActivity fetchLearningActivity(
		long actId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLearningActivity(actId);
	}

	/**
	* Returns the learning activity with the primary key.
	*
	* @param actId the primary key of the learning activity
	* @return the learning activity
	* @throws PortalException if a learning activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.LearningActivity getLearningActivity(
		long actId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLearningActivity(actId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the learning activity with the UUID in the group.
	*
	* @param uuid the UUID of learning activity
	* @param groupId the group id of the learning activity
	* @return the learning activity
	* @throws PortalException if a learning activity with the UUID in the group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.LearningActivity getLearningActivityByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLearningActivityByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the learning activities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of learning activities
	* @param end the upper bound of the range of learning activities (not inclusive)
	* @return the range of learning activities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.LearningActivity> getLearningActivities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLearningActivities(start, end);
	}

	/**
	* Returns the number of learning activities.
	*
	* @return the number of learning activities
	* @throws SystemException if a system exception occurred
	*/
	public static int getLearningActivitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLearningActivitiesCount();
	}

	/**
	* Updates the learning activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param learningActivity the learning activity
	* @return the learning activity that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.LearningActivity updateLearningActivity(
		com.liferay.lms.model.LearningActivity learningActivity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLearningActivity(learningActivity);
	}

	/**
	* Updates the learning activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param learningActivity the learning activity
	* @param merge whether to merge the learning activity with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the learning activity that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.LearningActivity updateLearningActivity(
		com.liferay.lms.model.LearningActivity learningActivity, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLearningActivity(learningActivity, merge);
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

	public static com.liferay.lms.model.LearningActivity addLearningActivity(
		java.lang.String title, java.lang.String description,
		java.util.Date createDate, int typeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addLearningActivity(title, description, createDate, typeId,
			serviceContext);
	}

	public static com.liferay.lms.model.LearningActivity modLearningActivity(
		com.liferay.lms.model.LearningActivity larn,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().modLearningActivity(larn, serviceContext);
	}

	public static java.util.List<com.liferay.lms.model.LearningActivity> getLearningActivitiesOfGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLearningActivitiesOfGroup(groupId);
	}

	public static void deleteLearningactivity(
		com.liferay.lms.model.LearningActivity lernact)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLearningactivity(lernact);
	}

	public static void deleteLearningactivity(long actId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLearningactivity(actId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LearningActivityLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LearningActivityLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					LearningActivityLocalService.class.getName(),
					portletClassLoader);

			_service = new LearningActivityLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(LearningActivityLocalServiceUtil.class,
				"_service");
			MethodCache.remove(LearningActivityLocalService.class);
		}

		return _service;
	}

	public void setService(LearningActivityLocalService service) {
		MethodCache.remove(LearningActivityLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(LearningActivityLocalServiceUtil.class,
			"_service");
		MethodCache.remove(LearningActivityLocalService.class);
	}

	private static LearningActivityLocalService _service;
}