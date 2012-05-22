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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.lms.service.http.LearningTypeServiceSoap}.
 *
 * @author    cvicente
 * @see       com.liferay.lms.service.http.LearningTypeServiceSoap
 * @generated
 */
public class LearningTypeSoap implements Serializable {
	public static LearningTypeSoap toSoapModel(LearningType model) {
		LearningTypeSoap soapModel = new LearningTypeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTypeId(model.getTypeId());
		soapModel.setName(model.getName());
		soapModel.setClassName(model.getClassName());

		return soapModel;
	}

	public static LearningTypeSoap[] toSoapModels(LearningType[] models) {
		LearningTypeSoap[] soapModels = new LearningTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LearningTypeSoap[][] toSoapModels(LearningType[][] models) {
		LearningTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LearningTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LearningTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LearningTypeSoap[] toSoapModels(List<LearningType> models) {
		List<LearningTypeSoap> soapModels = new ArrayList<LearningTypeSoap>(models.size());

		for (LearningType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LearningTypeSoap[soapModels.size()]);
	}

	public LearningTypeSoap() {
	}

	public long getPrimaryKey() {
		return _typeId;
	}

	public void setPrimaryKey(long pk) {
		setTypeId(pk);
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

	private String _uuid;
	private long _typeId;
	private String _name;
	private String _className;
}