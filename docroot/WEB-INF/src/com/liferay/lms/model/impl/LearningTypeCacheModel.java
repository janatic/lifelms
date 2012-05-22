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

package com.liferay.lms.model.impl;

import com.liferay.lms.model.LearningType;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing LearningType in entity cache.
 *
 * @author cvicente
 * @see LearningType
 * @generated
 */
public class LearningTypeCacheModel implements CacheModel<LearningType>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", typeId=");
		sb.append(typeId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", className=");
		sb.append(className);
		sb.append("}");

		return sb.toString();
	}

	public LearningType toEntityModel() {
		LearningTypeImpl learningTypeImpl = new LearningTypeImpl();

		if (uuid == null) {
			learningTypeImpl.setUuid(StringPool.BLANK);
		}
		else {
			learningTypeImpl.setUuid(uuid);
		}

		learningTypeImpl.setTypeId(typeId);

		if (name == null) {
			learningTypeImpl.setName(StringPool.BLANK);
		}
		else {
			learningTypeImpl.setName(name);
		}

		if (className == null) {
			learningTypeImpl.setClassName(StringPool.BLANK);
		}
		else {
			learningTypeImpl.setClassName(className);
		}

		learningTypeImpl.resetOriginalValues();

		return learningTypeImpl;
	}

	public String uuid;
	public long typeId;
	public String name;
	public String className;
}