<%@page import="com.liferay.lms.model.TestAnswer"%>
<%@page import="com.liferay.lms.service.TestAnswerLocalServiceUtil"%>
<%@page import="com.liferay.lms.model.TestQuestion"%>
<%@page import="com.liferay.lms.service.TestQuestionLocalServiceUtil"%>
<%@page import="com.liferay.lms.service.LearningActivityLocalServiceUtil"%>
<%@page import="com.liferay.lms.model.LearningActivity"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ include file="/init.jsp" %>
<%

LearningActivity learnact=null;
if(request.getAttribute("activity")!=null)
{
	
 learnact=(LearningActivity)request.getAttribute("activity");
}
else
{
	learnact=LearningActivityLocalServiceUtil.getLearningActivity(ParamUtil.getLong(request,"actId"));
}


String tabs1 = (String)request.getAttribute("tabs1");
if(tabs1==null || tabs1.equals(""))
{
	tabs1="Questions";
}
String tabNames = "Questions,General";
%>
<h1><liferay-ui:message key="test"></liferay-ui:message>: <%=learnact.getTitle()%>   </h1>
<portlet:actionURL name="editactivity" var="editURL">
<portlet:param name="actId" value="<%=Long.toString(learnact.getActId()) %>" />
<portlet:param name="tabs1" value="<%=tabs1 %>" />
</portlet:actionURL>
<%

%>
<liferay-ui:tabs
   names="<%= tabNames %>"
   url="<%= editURL %>"
/>
