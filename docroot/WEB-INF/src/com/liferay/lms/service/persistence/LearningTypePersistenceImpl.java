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

import com.liferay.lms.NoSuchLearningTypeException;
import com.liferay.lms.model.LearningType;
import com.liferay.lms.model.impl.LearningTypeImpl;
import com.liferay.lms.model.impl.LearningTypeModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the learning type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author cvicente
 * @see LearningTypePersistence
 * @see LearningTypeUtil
 * @generated
 */
public class LearningTypePersistenceImpl extends BasePersistenceImpl<LearningType>
	implements LearningTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LearningTypeUtil} to access the learning type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LearningTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(LearningTypeModelImpl.ENTITY_CACHE_ENABLED,
			LearningTypeModelImpl.FINDER_CACHE_ENABLED, LearningTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(LearningTypeModelImpl.ENTITY_CACHE_ENABLED,
			LearningTypeModelImpl.FINDER_CACHE_ENABLED, LearningTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			LearningTypeModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(LearningTypeModelImpl.ENTITY_CACHE_ENABLED,
			LearningTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LearningTypeModelImpl.ENTITY_CACHE_ENABLED,
			LearningTypeModelImpl.FINDER_CACHE_ENABLED, LearningTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LearningTypeModelImpl.ENTITY_CACHE_ENABLED,
			LearningTypeModelImpl.FINDER_CACHE_ENABLED, LearningTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LearningTypeModelImpl.ENTITY_CACHE_ENABLED,
			LearningTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the learning type in the entity cache if it is enabled.
	 *
	 * @param learningType the learning type
	 */
	public void cacheResult(LearningType learningType) {
		EntityCacheUtil.putResult(LearningTypeModelImpl.ENTITY_CACHE_ENABLED,
			LearningTypeImpl.class, learningType.getPrimaryKey(), learningType);

		learningType.resetOriginalValues();
	}

	/**
	 * Caches the learning types in the entity cache if it is enabled.
	 *
	 * @param learningTypes the learning types
	 */
	public void cacheResult(List<LearningType> learningTypes) {
		for (LearningType learningType : learningTypes) {
			if (EntityCacheUtil.getResult(
						LearningTypeModelImpl.ENTITY_CACHE_ENABLED,
						LearningTypeImpl.class, learningType.getPrimaryKey()) == null) {
				cacheResult(learningType);
			}
			else {
				learningType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all learning types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LearningTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LearningTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the learning type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LearningType learningType) {
		EntityCacheUtil.removeResult(LearningTypeModelImpl.ENTITY_CACHE_ENABLED,
			LearningTypeImpl.class, learningType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LearningType> learningTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LearningType learningType : learningTypes) {
			EntityCacheUtil.removeResult(LearningTypeModelImpl.ENTITY_CACHE_ENABLED,
				LearningTypeImpl.class, learningType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new learning type with the primary key. Does not add the learning type to the database.
	 *
	 * @param typeId the primary key for the new learning type
	 * @return the new learning type
	 */
	public LearningType create(long typeId) {
		LearningType learningType = new LearningTypeImpl();

		learningType.setNew(true);
		learningType.setPrimaryKey(typeId);

		String uuid = PortalUUIDUtil.generate();

		learningType.setUuid(uuid);

		return learningType;
	}

	/**
	 * Removes the learning type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param typeId the primary key of the learning type
	 * @return the learning type that was removed
	 * @throws com.liferay.lms.NoSuchLearningTypeException if a learning type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LearningType remove(long typeId)
		throws NoSuchLearningTypeException, SystemException {
		return remove(Long.valueOf(typeId));
	}

	/**
	 * Removes the learning type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the learning type
	 * @return the learning type that was removed
	 * @throws com.liferay.lms.NoSuchLearningTypeException if a learning type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LearningType remove(Serializable primaryKey)
		throws NoSuchLearningTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LearningType learningType = (LearningType)session.get(LearningTypeImpl.class,
					primaryKey);

			if (learningType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLearningTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(learningType);
		}
		catch (NoSuchLearningTypeException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected LearningType removeImpl(LearningType learningType)
		throws SystemException {
		learningType = toUnwrappedModel(learningType);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, learningType);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(learningType);

		return learningType;
	}

	@Override
	public LearningType updateImpl(
		com.liferay.lms.model.LearningType learningType, boolean merge)
		throws SystemException {
		learningType = toUnwrappedModel(learningType);

		boolean isNew = learningType.isNew();

		LearningTypeModelImpl learningTypeModelImpl = (LearningTypeModelImpl)learningType;

		if (Validator.isNull(learningType.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			learningType.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, learningType, merge);

			learningType.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LearningTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((learningTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						learningTypeModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { learningTypeModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		EntityCacheUtil.putResult(LearningTypeModelImpl.ENTITY_CACHE_ENABLED,
			LearningTypeImpl.class, learningType.getPrimaryKey(), learningType);

		return learningType;
	}

	protected LearningType toUnwrappedModel(LearningType learningType) {
		if (learningType instanceof LearningTypeImpl) {
			return learningType;
		}

		LearningTypeImpl learningTypeImpl = new LearningTypeImpl();

		learningTypeImpl.setNew(learningType.isNew());
		learningTypeImpl.setPrimaryKey(learningType.getPrimaryKey());

		learningTypeImpl.setUuid(learningType.getUuid());
		learningTypeImpl.setTypeId(learningType.getTypeId());
		learningTypeImpl.setName(learningType.getName());
		learningTypeImpl.setClassName(learningType.getClassName());

		return learningTypeImpl;
	}

	/**
	 * Returns the learning type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the learning type
	 * @return the learning type
	 * @throws com.liferay.portal.NoSuchModelException if a learning type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LearningType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the learning type with the primary key or throws a {@link com.liferay.lms.NoSuchLearningTypeException} if it could not be found.
	 *
	 * @param typeId the primary key of the learning type
	 * @return the learning type
	 * @throws com.liferay.lms.NoSuchLearningTypeException if a learning type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LearningType findByPrimaryKey(long typeId)
		throws NoSuchLearningTypeException, SystemException {
		LearningType learningType = fetchByPrimaryKey(typeId);

		if (learningType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + typeId);
			}

			throw new NoSuchLearningTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				typeId);
		}

		return learningType;
	}

	/**
	 * Returns the learning type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the learning type
	 * @return the learning type, or <code>null</code> if a learning type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LearningType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the learning type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param typeId the primary key of the learning type
	 * @return the learning type, or <code>null</code> if a learning type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LearningType fetchByPrimaryKey(long typeId)
		throws SystemException {
		LearningType learningType = (LearningType)EntityCacheUtil.getResult(LearningTypeModelImpl.ENTITY_CACHE_ENABLED,
				LearningTypeImpl.class, typeId);

		if (learningType == _nullLearningType) {
			return null;
		}

		if (learningType == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				learningType = (LearningType)session.get(LearningTypeImpl.class,
						Long.valueOf(typeId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (learningType != null) {
					cacheResult(learningType);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LearningTypeModelImpl.ENTITY_CACHE_ENABLED,
						LearningTypeImpl.class, typeId, _nullLearningType);
				}

				closeSession(session);
			}
		}

		return learningType;
	}

	/**
	 * Returns all the learning types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching learning types
	 * @throws SystemException if a system exception occurred
	 */
	public List<LearningType> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the learning types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of learning types
	 * @param end the upper bound of the range of learning types (not inclusive)
	 * @return the range of matching learning types
	 * @throws SystemException if a system exception occurred
	 */
	public List<LearningType> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the learning types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of learning types
	 * @param end the upper bound of the range of learning types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching learning types
	 * @throws SystemException if a system exception occurred
	 */
	public List<LearningType> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<LearningType> list = (List<LearningType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_LEARNINGTYPE_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<LearningType>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first learning type in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching learning type
	 * @throws com.liferay.lms.NoSuchLearningTypeException if a matching learning type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LearningType findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchLearningTypeException, SystemException {
		List<LearningType> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLearningTypeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last learning type in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching learning type
	 * @throws com.liferay.lms.NoSuchLearningTypeException if a matching learning type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LearningType findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchLearningTypeException, SystemException {
		int count = countByUuid(uuid);

		List<LearningType> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLearningTypeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the learning types before and after the current learning type in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param typeId the primary key of the current learning type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next learning type
	 * @throws com.liferay.lms.NoSuchLearningTypeException if a learning type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LearningType[] findByUuid_PrevAndNext(long typeId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchLearningTypeException, SystemException {
		LearningType learningType = findByPrimaryKey(typeId);

		Session session = null;

		try {
			session = openSession();

			LearningType[] array = new LearningTypeImpl[3];

			array[0] = getByUuid_PrevAndNext(session, learningType, uuid,
					orderByComparator, true);

			array[1] = learningType;

			array[2] = getByUuid_PrevAndNext(session, learningType, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LearningType getByUuid_PrevAndNext(Session session,
		LearningType learningType, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEARNINGTYPE_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(learningType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LearningType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the learning types.
	 *
	 * @return the learning types
	 * @throws SystemException if a system exception occurred
	 */
	public List<LearningType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<LearningType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the learning types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of learning types
	 * @param end the upper bound of the range of learning types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of learning types
	 * @throws SystemException if a system exception occurred
	 */
	public List<LearningType> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<LearningType> list = (List<LearningType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEARNINGTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEARNINGTYPE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<LearningType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LearningType>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the learning types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (LearningType learningType : findByUuid(uuid)) {
			remove(learningType);
		}
	}

	/**
	 * Removes all the learning types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (LearningType learningType : findAll()) {
			remove(learningType);
		}
	}

	/**
	 * Returns the number of learning types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching learning types
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEARNINGTYPE_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of learning types.
	 *
	 * @return the number of learning types
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEARNINGTYPE);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the learning type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.lms.model.LearningType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LearningType>> listenersList = new ArrayList<ModelListener<LearningType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LearningType>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(LearningTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = LearningActivityPersistence.class)
	protected LearningActivityPersistence learningActivityPersistence;
	@BeanReference(type = LearningActivityResultPersistence.class)
	protected LearningActivityResultPersistence learningActivityResultPersistence;
	@BeanReference(type = LearningActivityTryPersistence.class)
	protected LearningActivityTryPersistence learningActivityTryPersistence;
	@BeanReference(type = LearningTypePersistence.class)
	protected LearningTypePersistence learningTypePersistence;
	@BeanReference(type = TestAnswerPersistence.class)
	protected TestAnswerPersistence testAnswerPersistence;
	@BeanReference(type = TestQuestionPersistence.class)
	protected TestQuestionPersistence testQuestionPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_LEARNINGTYPE = "SELECT learningType FROM LearningType learningType";
	private static final String _SQL_SELECT_LEARNINGTYPE_WHERE = "SELECT learningType FROM LearningType learningType WHERE ";
	private static final String _SQL_COUNT_LEARNINGTYPE = "SELECT COUNT(learningType) FROM LearningType learningType";
	private static final String _SQL_COUNT_LEARNINGTYPE_WHERE = "SELECT COUNT(learningType) FROM LearningType learningType WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "learningType.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "learningType.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(learningType.uuid IS NULL OR learningType.uuid = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "learningType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LearningType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LearningType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LearningTypePersistenceImpl.class);
	private static LearningType _nullLearningType = new LearningTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LearningType> toCacheModel() {
				return _nullLearningTypeCacheModel;
			}
		};

	private static CacheModel<LearningType> _nullLearningTypeCacheModel = new CacheModel<LearningType>() {
			public LearningType toEntityModel() {
				return _nullLearningType;
			}
		};
}