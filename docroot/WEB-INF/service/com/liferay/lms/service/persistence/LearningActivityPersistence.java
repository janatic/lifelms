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

package com.liferay.lms.service.persistence;

import com.liferay.lms.model.LearningActivity;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the learning activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author cvicente
 * @see LearningActivityPersistenceImpl
 * @see LearningActivityUtil
 * @generated
 */
public interface LearningActivityPersistence extends BasePersistence<LearningActivity> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LearningActivityUtil} to access the learning activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the learning activity in the entity cache if it is enabled.
	*
	* @param learningActivity the learning activity
	*/
	public void cacheResult(
		com.liferay.lms.model.LearningActivity learningActivity);

	/**
	* Caches the learning activities in the entity cache if it is enabled.
	*
	* @param learningActivities the learning activities
	*/
	public void cacheResult(
		java.util.List<com.liferay.lms.model.LearningActivity> learningActivities);

	/**
	* Creates a new learning activity with the primary key. Does not add the learning activity to the database.
	*
	* @param actId the primary key for the new learning activity
	* @return the new learning activity
	*/
	public com.liferay.lms.model.LearningActivity create(long actId);

	/**
	* Removes the learning activity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param actId the primary key of the learning activity
	* @return the learning activity that was removed
	* @throws com.liferay.lms.NoSuchLearningActivityException if a learning activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.LearningActivity remove(long actId)
		throws com.liferay.lms.NoSuchLearningActivityException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.lms.model.LearningActivity updateImpl(
		com.liferay.lms.model.LearningActivity learningActivity, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the learning activity with the primary key or throws a {@link com.liferay.lms.NoSuchLearningActivityException} if it could not be found.
	*
	* @param actId the primary key of the learning activity
	* @return the learning activity
	* @throws com.liferay.lms.NoSuchLearningActivityException if a learning activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.LearningActivity findByPrimaryKey(long actId)
		throws com.liferay.lms.NoSuchLearningActivityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the learning activity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param actId the primary key of the learning activity
	* @return the learning activity, or <code>null</code> if a learning activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.LearningActivity fetchByPrimaryKey(long actId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the learning activities where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching learning activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.lms.model.LearningActivity> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the learning activities where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of learning activities
	* @param end the upper bound of the range of learning activities (not inclusive)
	* @return the range of matching learning activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.lms.model.LearningActivity> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the learning activities where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of learning activities
	* @param end the upper bound of the range of learning activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching learning activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.lms.model.LearningActivity> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first learning activity in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching learning activity
	* @throws com.liferay.lms.NoSuchLearningActivityException if a matching learning activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.LearningActivity findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchLearningActivityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last learning activity in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching learning activity
	* @throws com.liferay.lms.NoSuchLearningActivityException if a matching learning activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.LearningActivity findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchLearningActivityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the learning activities before and after the current learning activity in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param actId the primary key of the current learning activity
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next learning activity
	* @throws com.liferay.lms.NoSuchLearningActivityException if a learning activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.LearningActivity[] findByUuid_PrevAndNext(
		long actId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchLearningActivityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the learning activity where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.lms.NoSuchLearningActivityException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching learning activity
	* @throws com.liferay.lms.NoSuchLearningActivityException if a matching learning activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.LearningActivity findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.lms.NoSuchLearningActivityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the learning activity where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching learning activity, or <code>null</code> if a matching learning activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.LearningActivity fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the learning activity where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching learning activity, or <code>null</code> if a matching learning activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.LearningActivity fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the learning activities where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching learning activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.lms.model.LearningActivity> findByg(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the learning activities where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of learning activities
	* @param end the upper bound of the range of learning activities (not inclusive)
	* @return the range of matching learning activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.lms.model.LearningActivity> findByg(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the learning activities where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of learning activities
	* @param end the upper bound of the range of learning activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching learning activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.lms.model.LearningActivity> findByg(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first learning activity in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching learning activity
	* @throws com.liferay.lms.NoSuchLearningActivityException if a matching learning activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.LearningActivity findByg_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchLearningActivityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last learning activity in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching learning activity
	* @throws com.liferay.lms.NoSuchLearningActivityException if a matching learning activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.LearningActivity findByg_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchLearningActivityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the learning activities before and after the current learning activity in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param actId the primary key of the current learning activity
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next learning activity
	* @throws com.liferay.lms.NoSuchLearningActivityException if a learning activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.LearningActivity[] findByg_PrevAndNext(
		long actId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchLearningActivityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the learning activities where groupId = &#63; and typeId = &#63;.
	*
	* @param groupId the group ID
	* @param typeId the type ID
	* @return the matching learning activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.lms.model.LearningActivity> findByg_t(
		long groupId, int typeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the learning activities where groupId = &#63; and typeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param typeId the type ID
	* @param start the lower bound of the range of learning activities
	* @param end the upper bound of the range of learning activities (not inclusive)
	* @return the range of matching learning activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.lms.model.LearningActivity> findByg_t(
		long groupId, int typeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the learning activities where groupId = &#63; and typeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param typeId the type ID
	* @param start the lower bound of the range of learning activities
	* @param end the upper bound of the range of learning activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching learning activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.lms.model.LearningActivity> findByg_t(
		long groupId, int typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first learning activity in the ordered set where groupId = &#63; and typeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param typeId the type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching learning activity
	* @throws com.liferay.lms.NoSuchLearningActivityException if a matching learning activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.LearningActivity findByg_t_First(
		long groupId, int typeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchLearningActivityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last learning activity in the ordered set where groupId = &#63; and typeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param typeId the type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching learning activity
	* @throws com.liferay.lms.NoSuchLearningActivityException if a matching learning activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.LearningActivity findByg_t_Last(long groupId,
		int typeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchLearningActivityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the learning activities before and after the current learning activity in the ordered set where groupId = &#63; and typeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param actId the primary key of the current learning activity
	* @param groupId the group ID
	* @param typeId the type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next learning activity
	* @throws com.liferay.lms.NoSuchLearningActivityException if a learning activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.LearningActivity[] findByg_t_PrevAndNext(
		long actId, long groupId, int typeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchLearningActivityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the learning activities.
	*
	* @return the learning activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.lms.model.LearningActivity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.lms.model.LearningActivity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the learning activities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of learning activities
	* @param end the upper bound of the range of learning activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of learning activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.lms.model.LearningActivity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the learning activities where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the learning activity where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.lms.NoSuchLearningActivityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the learning activities where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByg(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the learning activities where groupId = &#63; and typeId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param typeId the type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByg_t(long groupId, int typeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the learning activities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of learning activities where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching learning activities
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of learning activities where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching learning activities
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of learning activities where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching learning activities
	* @throws SystemException if a system exception occurred
	*/
	public int countByg(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of learning activities where groupId = &#63; and typeId = &#63;.
	*
	* @param groupId the group ID
	* @param typeId the type ID
	* @return the number of matching learning activities
	* @throws SystemException if a system exception occurred
	*/
	public int countByg_t(long groupId, int typeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of learning activities.
	*
	* @return the number of learning activities
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}