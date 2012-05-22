package com.liferay.lms;

import java.util.Date;

import com.liferay.lms.model.LearningActivity;
import com.liferay.lms.model.TestQuestion;
import com.liferay.lms.service.LearningActivityLocalServiceUtil;
import com.liferay.lms.service.TestAnswerLocalServiceUtil;
import com.liferay.lms.service.TestQuestionLocalServiceUtil;
import com.liferay.lms.service.impl.TestQuestionLocalServiceImpl;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
/**
 * Portlet implementation class LmsActivitiesList
 */

public class LmsActivitiesList extends MVCPortlet 
{
	public void newactivity
	(ActionRequest actionRequest,ActionResponse actionResponse)
		throws Exception {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				LearningActivity.class.getName(), actionRequest);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String title=actionRequest.getParameter("title" );
		String description =actionRequest.getParameter("description");
		int type=ParamUtil.getInteger(actionRequest, "type",0);
    	String portletId = PortalUtil.getPortletId(actionRequest);
    	java.util.Date ahora=new java.util.Date(System.currentTimeMillis());
		com.liferay.lms.service.LearningActivityLocalServiceUtil.addLearningActivity(title,description,ahora,type, serviceContext);
		
		SessionMessages.add(actionRequest, "activity-saved-successfully");

	}
	public void editest
	(ActionRequest actionRequest,ActionResponse actionResponse)
	{
		
	}
	public void deleteactivity
	(
			ActionRequest actionRequest,ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
		String portletId = PortalUtil.getPortletId(actionRequest);
		long actId=ParamUtil.getLong(actionRequest, "actId");
		com.liferay.lms.service.LearningActivityLocalServiceUtil.deleteLearningActivity(actId);
		SessionMessages.add(actionRequest, "activity-deleted-successfully");
	}
	public void editactivity 
	(
			ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException,Exception
	{
		long actId=ParamUtil.getInteger(actionRequest, "actId");
		LearningActivity learnact=com.liferay.lms.service.LearningActivityLocalServiceUtil.getLearningActivity(actId);
		actionRequest.setAttribute("activity", learnact);

		if(learnact.getTypeId()==0)
		{
			
			actionResponse.setRenderParameter("jspPage", "/html/lmsactivitieslist/test/edit.jsp");
		}
	
	}
	public void modactivity
	(
			ActionRequest actionRequest,ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
		
		String portletId = PortalUtil.getPortletId(actionRequest);
		
		String title=actionRequest.getParameter("title" );
		String description =actionRequest.getParameter("description");
		int typeId=ParamUtil.getInteger(actionRequest, "type",0);
    	java.util.Date ahora=new java.util.Date(System.currentTimeMillis());
    	LearningActivity learningActivity=LearningActivityLocalServiceUtil.getLearningActivity(ParamUtil.getLong(actionRequest, "actId"));
    	learningActivity.setTitle(title);
    	learningActivity.setDescription(description);
    	learningActivity.setTypeId(typeId);
    	LearningActivityLocalServiceUtil.updateLearningActivity(learningActivity, false);
    	editactivity(actionRequest, actionResponse);
		SessionMessages.add(actionRequest, "activity-modified-successfully");
	}
	public void addanswer(
			ActionRequest actionRequest,ActionResponse actionResponse)
		throws Exception {
		System.out.println("anado anser");
		long questionId=ParamUtil.getLong(actionRequest, "questionId");
		String answer=ParamUtil.getString(actionRequest, "answer");
		boolean correct=ParamUtil.getBoolean(actionRequest, "correct");
	    TestAnswerLocalServiceUtil.addTestAnswer(questionId, answer, correct);
		SessionMessages.add(actionRequest, "answer-added-successfully");
	}
	
	public void addquestion
	(
			ActionRequest actionRequest,ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String portletId = PortalUtil.getPortletId(actionRequest);
		long actid=ParamUtil.getLong(actionRequest, "actId");
		
		String text=ParamUtil.getString(actionRequest, "text");
		long questionType=ParamUtil.getLong(actionRequest, "qtype");
		TestQuestion question=TestQuestionLocalServiceUtil.addQuestion(actid, text, questionType);
		editactivity(actionRequest, actionResponse);
		LearningActivity learnact=LearningActivityLocalServiceUtil.getLearningActivity(actid);
    	
		actionRequest.setAttribute("activity", learnact);
        actionRequest.setAttribute("questionId",question.getQuestionId());
		if(learnact.getTypeId()==0)
		{
			
			actionResponse.setRenderParameter("jspPage", "/html/lmsactivitieslist/test/editquestion.jsp");
		}
		SessionMessages.add(actionRequest, "question-added-successfully");
	}
	public void editquestion
	(
			ActionRequest actionRequest,ActionResponse actionResponse)
		throws Exception {

		String portletId = PortalUtil.getPortletId(actionRequest);
		long actid=ParamUtil.getLong(actionRequest, "actId");
		String text=ParamUtil.getString(actionRequest, "text");
		long questionType=ParamUtil.getLong(actionRequest, "qtype");
		long questionId=ParamUtil.getLong(actionRequest, "questionId");
		TestQuestion question=TestQuestionLocalServiceUtil.getTestQuestion(questionId);
		//editactivity(actionRequest, actionResponse);
		question.setQuestionType(questionType);
		question.setText(text);
		TestQuestionLocalServiceUtil.updateTestQuestion(question);
		SessionMessages.add(actionRequest, "question-modified-successfully");

	}
	public void deletequestion
	(
			ActionRequest actionRequest,ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String portletId = PortalUtil.getPortletId(actionRequest);
		TestQuestion question=TestQuestionLocalServiceUtil.getTestQuestion(ParamUtil.getLong(actionRequest,"questionId"));
		TestQuestionLocalServiceUtil.deleteTestQuestion(ParamUtil.getLong(actionRequest,"questionId"));
		editactivity(actionRequest, actionResponse);
LearningActivity learnact=LearningActivityLocalServiceUtil.getLearningActivity(question.getActId());
    	
		actionRequest.setAttribute("activity", learnact);

		if(learnact.getTypeId()==0)
		{	
			actionResponse.setRenderParameter("jspPage", "/html/lmsactivitieslist/test/edit.jsp");
		}
		SessionMessages.add(actionRequest, "question-deleted-successfully");
	
	}
	public void deleteanswer
	(
			ActionRequest actionRequest,ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String portletId = PortalUtil.getPortletId(actionRequest);
		TestAnswerLocalServiceUtil.deleteTestAnswer(ParamUtil.getLong(actionRequest,"answerId"));
		SessionMessages.add(actionRequest, "answer-deleted-successfully");
	
	}



}
