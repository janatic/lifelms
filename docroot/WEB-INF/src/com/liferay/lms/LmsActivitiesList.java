package com.liferay.lms;

import java.sql.Timestamp;
import java.util.Date;

import com.liferay.lms.model.LearningActivity;
import com.liferay.lms.model.TestAnswer;
import com.liferay.lms.model.TestQuestion;
import com.liferay.lms.service.LearningActivityLocalServiceUtil;
import com.liferay.lms.service.LearningActivityServiceUtil;
import com.liferay.lms.service.TestAnswerLocalServiceUtil;
import com.liferay.lms.service.TestQuestionLocalServiceUtil;
import com.liferay.lms.service.impl.TestQuestionLocalServiceImpl;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.WindowState;

import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.announcements.EntryDisplayDateException;
/**
 * Portlet implementation class LmsActivitiesList
 */

public class LmsActivitiesList extends MVCPortlet 
{
	public void saveActivity
	(ActionRequest actionRequest,ActionResponse actionResponse)
		throws Exception {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				LearningActivity.class.getName(), actionRequest);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		
		User user=themeDisplay.getUser();
		long actId=ParamUtil.getLong(actionRequest, "actId",0);
		String title=actionRequest.getParameter("title" );
		String description =actionRequest.getParameter("description");
		int type=ParamUtil.getInteger(actionRequest, "type",0);
		int startMonth=ParamUtil.getInteger(actionRequest,"startMon");
		int startYear=ParamUtil.getInteger(actionRequest, "startYear");
		int startDay=ParamUtil.getInteger(actionRequest, "startDay");
		int startHour=ParamUtil.getInteger(actionRequest, "startHour");
		int startMinute=ParamUtil.getInteger(actionRequest, "startMin");
		int startAMPM=ParamUtil.getInteger(actionRequest, "startAMPM");
		if(startAMPM>0)
		{
			startHour+=12;
		}
		Date startDate = PortalUtil.getDate(
				startMonth, startDay, startYear, startHour,
				startMinute, user.getTimeZone(),
				new EntryDisplayDateException());
		
		int stopMonth=ParamUtil.getInteger(actionRequest,"stopMon");
		int stopYear=ParamUtil.getInteger(actionRequest, "stopYear");
		int stopDay=ParamUtil.getInteger(actionRequest, "stopDay");
		int stopHour=ParamUtil.getInteger(actionRequest, "stopHour");
		int stopMinute=ParamUtil.getInteger(actionRequest, "stopMin");
		int stopAMPM=ParamUtil.getInteger(actionRequest, "stopAMPM");
		if(stopAMPM>0)
		{
			stopHour+=12;
		}
		Date stopDate = PortalUtil.getDate(
				stopMonth, stopDay, stopYear, stopHour,
				stopMinute, user.getTimeZone(),
				new EntryDisplayDateException());
		
		long tries=ParamUtil.getLong(actionRequest, "tries");
    	java.util.Date ahora=new java.util.Date(System.currentTimeMillis());
    	//Validation
    	if(Validator.isNull(title))
    	{
    		SessionErrors.add(actionRequest, "title-required");
    		return;
    	}
    	if(actId==0)
    	{
    		
		    com.liferay.lms.service.LearningActivityLocalServiceUtil.addLearningActivity(title,description,ahora,startDate,stopDate,type,tries, serviceContext);
    	}
    	else
    	{
    		com.liferay.lms.service.LearningActivityLocalServiceUtil.modLearningActivity(actId,title,description,ahora,startDate,stopDate,type,tries, serviceContext);
        	
    	}
		SessionMessages.add(actionRequest, "activity-saved-successfully");
		WindowState windowState = actionRequest.getWindowState();
		if(redirect!=null && !"".equals(redirect))
		{
			if (!windowState.equals(LiferayWindowState.POP_UP)) {
				actionResponse.sendRedirect(redirect);
			}
			else {
				redirect = PortalUtil.escapeRedirect(redirect);
	
				if (Validator.isNotNull(redirect)) {
					actionResponse.sendRedirect(redirect);
				}
			}
		}
		
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
		com.liferay.lms.service.LearningActivityServiceUtil.deleteLearningactivity(actId);
		SessionMessages.add(actionRequest, "activity-deleted-successfully");
	}
	public void editactivity 
	(
			ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException,Exception
	{
		long actId=ParamUtil.getInteger(actionRequest, "actId");
		LearningActivity learnact=com.liferay.lms.service.LearningActivityServiceUtil.getLearningActivity(actId);
		actionRequest.setAttribute("activity", learnact);
		actionRequest.setAttribute("tabs1", ParamUtil.getString(actionRequest, "tabs1"));
		actionResponse.setRenderParameters(actionRequest.getParameterMap());
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
    	LearningActivity learningActivity=LearningActivityServiceUtil.getLearningActivity(ParamUtil.getLong(actionRequest, "actId"));
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
		String answers=ParamUtil.getString(actionRequest, "answer");
		boolean correct=ParamUtil.getBoolean(actionRequest, "correct");
		TestAnswer answer=TestAnswerLocalServiceUtil.addTestAnswer(questionId, answers, correct);
		SessionMessages.add(actionRequest, "answer-added-successfully");
			LearningActivity learnact=LearningActivityLocalServiceUtil.getLearningActivity(TestQuestionLocalServiceUtil.getTestQuestion(answer.getQuestionId()).getActId());
		 actionResponse.setRenderParameter("questionId",Long.toString(answer.getQuestionId()));
		 actionResponse.setRenderParameter("actId",Long.toString(learnact.getActId()));
			if(learnact.getTypeId()==0)
			{
				
				actionResponse.setRenderParameter("jspPage", "/html/lmsactivitieslist/test/editquestion.jsp");
			}
	}
	public void editanswer(
			ActionRequest actionRequest,ActionResponse actionResponse)
		throws Exception {
		System.out.println("anado anser");
		long answerId=ParamUtil.getLong(actionRequest, "answerId");
		String answer=ParamUtil.getString(actionRequest, "answer");
		boolean correct=ParamUtil.getBoolean(actionRequest, "correct");
		TestAnswer testanswer=TestAnswerLocalServiceUtil.getTestAnswer(answerId);
		testanswer.setAnswer(answer);
		testanswer.setIsCorrect(correct);
		TestAnswerLocalServiceUtil.updateTestAnswer(testanswer);
		SessionMessages.add(actionRequest, "answer-added-successfully");
			LearningActivity learnact=LearningActivityLocalServiceUtil.getLearningActivity(TestQuestionLocalServiceUtil.getTestQuestion(testanswer.getQuestionId()).getActId());
		 actionResponse.setRenderParameter("questionId",Long.toString(testanswer.getQuestionId()));
		 actionResponse.setRenderParameter("actId",Long.toString(learnact.getActId()));
			if(learnact.getTypeId()==0)
			{
				
				actionResponse.setRenderParameter("jspPage", "/html/lmsactivitieslist/test/editquestion.jsp");
			}
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
        actionRequest.setAttribute("primKey",question.getQuestionId());
        actionResponse.setRenderParameter("questionId",Long.toString(question.getQuestionId()));
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
		LearningActivity learnact=LearningActivityLocalServiceUtil.getLearningActivity(question.getActId());
		 actionResponse.setRenderParameter("questionId",Long.toString(questionId));
		 actionResponse.setRenderParameter("actId",Long.toString(learnact.getActId()));
			
			if(learnact.getTypeId()==0)
			{
				
				actionResponse.setRenderParameter("jspPage", "/html/lmsactivitieslist/test/editquestion.jsp");
			}
		

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
		TestAnswer answer=TestAnswerLocalServiceUtil.getTestAnswer(ParamUtil.getLong(actionRequest,"answerId"));
		LearningActivity learnact=LearningActivityLocalServiceUtil.getLearningActivity(TestQuestionLocalServiceUtil.getTestQuestion(answer.getQuestionId()).getActId());
		TestAnswerLocalServiceUtil.deleteTestAnswer(ParamUtil.getLong(actionRequest,"answerId"));
		SessionMessages.add(actionRequest, "answer-deleted-successfully");
		 actionResponse.setRenderParameter("questionId",Long.toString(answer.getQuestionId()));
		 actionResponse.setRenderParameter("actId",Long.toString(learnact.getActId()));
			
			if(learnact.getTypeId()==0)
			{
				
				actionResponse.setRenderParameter("jspPage", "/html/lmsactivitieslist/test/editquestion.jsp");
			}
	
	}



}
