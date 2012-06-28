<%@page import="com.liferay.lms.service.LearningActivityResultLocalServiceUtil"%>
<%@page import="com.liferay.lms.service.LearningActivityLocalServiceUtil"%>
<%@page import="com.liferay.lms.model.LearningActivity"%>
<%@ include file="/init.jsp" %>
<%
java.util.List<LearningActivity>activities=LearningActivityLocalServiceUtil.getLearningActivitiesOfGroup(themeDisplay.getScopeGroupId());
for(LearningActivity learningActivity:activities)
{
	long result=0;
	if(LearningActivityResultLocalServiceUtil.existsLearningActivityResult(learningActivity.getActId(), themeDisplay.getUserId()))
			{
				result=LearningActivityResultLocalServiceUtil.getByActIdAndUserId(learningActivity.getActId(), themeDisplay.getUserId()).getResult();
			}
	%>
	<%=learningActivity.getTitle() %>:<%=result %>
	<br />
	<%
}
%>
