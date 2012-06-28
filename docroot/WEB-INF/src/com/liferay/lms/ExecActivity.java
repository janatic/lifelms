package com.liferay.lms;

import java.util.Enumeration;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.lms.model.LearningActivityTry;
import com.liferay.lms.model.TestAnswer;
import com.liferay.lms.model.TestQuestion;
import com.liferay.lms.service.LearningActivityTryLocalServiceUtil;
import com.liferay.lms.service.TestAnswerLocalServiceUtil;
import com.liferay.lms.service.TestQuestionLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ExecActivity
 */
public class ExecActivity extends MVCPortlet 
{
	public void correct
	(
			ActionRequest actionRequest,ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		
		String portletId = PortalUtil.getPortletId(actionRequest);
		long actId=ParamUtil.getLong(actionRequest, "actId");
		long latId=ParamUtil.getLong(actionRequest,"latId" );
		Enumeration<String> params=actionRequest.getParameterNames();
		long correctanswers=0;
		List<TestQuestion> questions=TestQuestionLocalServiceUtil.getQuestions(actId);
		while(params.hasMoreElements())
		{
			String param=params.nextElement();
			if(param.startsWith("question_"))
			{
				String squestionId=param.substring("question_".length());
				long questionId=Long.parseLong(squestionId);
				long answerId=ParamUtil.getLong(actionRequest, param);
				TestAnswer testAnswer=TestAnswerLocalServiceUtil.getTestAnswer(answerId);
				if(testAnswer.isIsCorrect())
				{
					correctanswers++;
				}
				
			}
		}
		long score=correctanswers*100/questions.size();
		LearningActivityTry larntry=LearningActivityTryLocalServiceUtil.getLearningActivityTry(latId);
		larntry.setResult(score);
		larntry.setEndDate(new java.util.Date(System.currentTimeMillis()));
		LearningActivityTryLocalServiceUtil.updateLearningActivityTry(larntry);
		System.out.println(ParamUtil.getString(actionRequest,"answer",""));
		actionResponse.setRenderParameters(actionRequest.getParameterMap());
		actionResponse.setRenderParameter("jspPage", "/html/execactivity/test/results.jsp");
		
	
	}
}
