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

package com.liferay.lms.service.messaging;

import com.liferay.lms.service.ClpSerializer;
import com.liferay.lms.service.LearningActivityLocalServiceUtil;
import com.liferay.lms.service.LearningActivityResultLocalServiceUtil;
import com.liferay.lms.service.LearningActivityResultServiceUtil;
import com.liferay.lms.service.LearningActivityServiceUtil;
import com.liferay.lms.service.LearningActivityTryLocalServiceUtil;
import com.liferay.lms.service.LearningActivityTryServiceUtil;
import com.liferay.lms.service.LearningTypeLocalServiceUtil;
import com.liferay.lms.service.LearningTypeServiceUtil;
import com.liferay.lms.service.TestAnswerLocalServiceUtil;
import com.liferay.lms.service.TestAnswerServiceUtil;
import com.liferay.lms.service.TestQuestionLocalServiceUtil;
import com.liferay.lms.service.TestQuestionServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			LearningActivityLocalServiceUtil.clearService();

			LearningActivityServiceUtil.clearService();
			LearningActivityResultLocalServiceUtil.clearService();

			LearningActivityResultServiceUtil.clearService();
			LearningActivityTryLocalServiceUtil.clearService();

			LearningActivityTryServiceUtil.clearService();
			LearningTypeLocalServiceUtil.clearService();

			LearningTypeServiceUtil.clearService();
			TestAnswerLocalServiceUtil.clearService();

			TestAnswerServiceUtil.clearService();
			TestQuestionLocalServiceUtil.clearService();

			TestQuestionServiceUtil.clearService();
		}
	}
}