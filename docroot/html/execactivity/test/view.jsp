<%@page import="com.liferay.lms.model.TestAnswer"%>
<%@page import="com.liferay.lms.service.TestAnswerLocalServiceUtil"%>
<%@page import="com.liferay.lms.model.TestQuestion"%>
<%@page import="com.liferay.lms.service.TestQuestionLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.ServiceContextFactory"%>
<%@page import="com.liferay.portal.service.ServiceContext"%>
<%@page import="com.liferay.lms.service.LearningActivityTryLocalServiceUtil"%>
<%@page import="com.liferay.lms.model.LearningActivityTry"%>
<%@page import="com.liferay.lms.model.LearningActivity"%>
<%@page import="com.liferay.lms.service.LearningActivityLocalServiceUtil"%>
<%@ include file="/init.jsp" %>

<%
long actId=ParamUtil.getLong(request,"actId",0);

if(actId==0 || !windowState.equals(windowState.MAXIMIZED))
{
	
	renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.FALSE);
}
else
{

LearningActivity activity=LearningActivityLocalServiceUtil.getLearningActivity(actId);
long typeId=activity.getTypeId();

if(typeId==0)
{	
ServiceContext serviceContext = ServiceContextFactory.getInstance(LearningActivityTry.class.getName(), renderRequest);

LearningActivityTry learningTry =LearningActivityTryLocalServiceUtil.createLearningActivityTry(actId,serviceContext);
List<TestQuestion> questions=TestQuestionLocalServiceUtil.getQuestions(actId);

%>
<portlet:actionURL name="correct" var="correctURL">
<portlet:param name="actId" value="<%=Long.toString(actId) %>"></portlet:param>
<portlet:param name="latId" value="<%=Long.toString(learningTry.getLatId()) %>"></portlet:param>
</portlet:actionURL>
<h2>Cuestionario: <%=activity.getTitle() %></h2>
<aui:form name="formulario" action="<%=correctURL %>" method="POST">
<%
for(TestQuestion question:questions)
{
	

	%>
	<div class="question"><%=question.getText() %></div>
	<%
	List<TestAnswer> testAnswers= TestAnswerLocalServiceUtil.getTestAnswersByQuestionId(question.getQuestionId());
	for(TestAnswer answer:testAnswers)
	{
		%>
		<aui:input type="radio" name="answer" value="<%=answer.getAnswerId() %>"></aui:input> <%=answer.getAnswer() %>
		<%
	}
}
%>
<aui:button type="submit"></aui:button>
</aui:form>
<%
}
}
%>

