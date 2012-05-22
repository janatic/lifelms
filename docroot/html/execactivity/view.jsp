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
%>
<h2><%=activity.getTitle() %></h2>
<%
if(typeId==0)
{	
	ServiceContext serviceContext = ServiceContextFactory.getInstance(LearningActivityTry.class.getName(), renderRequest);

LearningActivityTry learningTry =LearningActivityTryLocalServiceUtil.createLearningActivityTry(actId,serviceContext);
%>
<liferay-portlet:renderURL var="questionURL">
<liferay-portlet:param name="jspPage" value="/html/execactivity/test/question.jsp"></liferay-portlet:param>
</liferay-portlet:renderURL>
<%
}
}
%>
