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

import com.liferay.lms.service.TestQuestionLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author cvicente
 */
public class TestQuestionClp extends BaseModelImpl<TestQuestion>
	implements TestQuestion {
	public TestQuestionClp() {
	}

	public Class<?> getModelClass() {
		return TestQuestion.class;
	}

	public String getModelClassName() {
		return TestQuestion.class.getName();
	}

	public long getPrimaryKey() {
		return _questionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setQuestionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_questionId);
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

	public long getQuestionId() {
		return _questionId;
	}

	public void setQuestionId(long questionId) {
		_questionId = questionId;
	}

	public long getActId() {
		return _actId;
	}

	public void setActId(long actId) {
		_actId = actId;
	}

	public String getText() {
		return _text;
	}

	public void setText(String text) {
		_text = text;
	}

	public long getQuestionType() {
		return _questionType;
	}

	public void setQuestionType(long questionType) {
		_questionType = questionType;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TestQuestionLocalServiceUtil.addTestQuestion(this);
		}
		else {
			TestQuestionLocalServiceUtil.updateTestQuestion(this);
		}
	}

	@Override
	public TestQuestion toEscapedModel() {
		return (TestQuestion)Proxy.newProxyInstance(TestQuestion.class.getClassLoader(),
			new Class[] { TestQuestion.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TestQuestionClp clone = new TestQuestionClp();

		clone.setUuid(getUuid());
		clone.setQuestionId(getQuestionId());
		clone.setActId(getActId());
		clone.setText(getText());
		clone.setQuestionType(getQuestionType());

		return clone;
	}

	public int compareTo(TestQuestion testQuestion) {
		long primaryKey = testQuestion.getPrimaryKey();

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

		TestQuestionClp testQuestion = null;

		try {
			testQuestion = (TestQuestionClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = testQuestion.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", questionId=");
		sb.append(getQuestionId());
		sb.append(", actId=");
		sb.append(getActId());
		sb.append(", text=");
		sb.append(getText());
		sb.append(", questionType=");
		sb.append(getQuestionType());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.lms.model.TestQuestion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>questionId</column-name><column-value><![CDATA[");
		sb.append(getQuestionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actId</column-name><column-value><![CDATA[");
		sb.append(getActId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>text</column-name><column-value><![CDATA[");
		sb.append(getText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>questionType</column-name><column-value><![CDATA[");
		sb.append(getQuestionType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _questionId;
	private long _actId;
	private String _text;
	private long _questionType;
}