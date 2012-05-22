<%@page import="com.liferay.lms.model.LearningActivity"%>
<%@ include file="/init.jsp" %>
<%
ResultRow row =
(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
LearningActivity myActivity = (LearningActivity)row.getObject();
long groupId = themeDisplay.getLayout().getGroupId();
String name = LearningActivity.class.getName();
String primKey = String.valueOf(myActivity.getActId());
%>
<liferay-ui:icon-menu>
<portlet:actionURL name="editactivity" var="editURL">
<portlet:param name="actId" value="<%=primKey %>" />
</portlet:actionURL>
<liferay-ui:icon image="edit" message="Edit" url="<%=editURL.toString() %>" />
<portlet:actionURL name="deleteactivity" var="deleteURL">
<portlet:param name="actId" value="<%= primKey %>" />
</portlet:actionURL>
<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
</liferay-ui:icon-menu>
