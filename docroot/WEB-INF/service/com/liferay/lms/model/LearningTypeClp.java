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

import com.liferay.lms.service.LearningTypeLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author cvicente
 */
public class LearningTypeClp extends BaseModelImpl<LearningType>
	implements LearningType {
	public LearningTypeClp() {
	}

	public Class<?> getModelClass() {
		return LearningType.class;
	}

	public String getModelClassName() {
		return LearningType.class.getName();
	}

	public long getPrimaryKey() {
		return _typeId;
	}

	public void setPrimaryKey(long primaryKey) {
		setTypeId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_typeId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTypeId() {
		return _typeId;
	}

	public void setTypeId(long typeId) {
		_typeId = typeId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getClassName() {
		return _className;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			LearningTypeLocalServiceUtil.addLearningType(this);
		}
		else {
			LearningTypeLocalServiceUtil.updateLearningType(this);
		}
	}

	@Override
	public LearningType toEscapedModel() {
		return (LearningType)Proxy.newProxyInstance(LearningType.class.getClassLoader(),
			new Class[] { LearningType.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LearningTypeClp clone = new LearningTypeClp();

		clone.setUuid(getUuid());
		clone.setTypeId(getTypeId());
		clone.setName(getName());
		clone.setClassName(getClassName());

		return clone;
	}

	public int compareTo(LearningType learningType) {
		long primaryKey = learningType.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LearningTypeClp learningType = null;

		try {
			learningType = (LearningTypeClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = learningType.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", typeId=");
		sb.append(getTypeId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", className=");
		sb.append(getClassName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.liferay.lms.model.LearningType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeId</column-name><column-value><![CDATA[");
		sb.append(getTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>className</column-name><column-value><![CDATA[");
		sb.append(getClassName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _typeId;
	private String _name;
	private String _className;
}