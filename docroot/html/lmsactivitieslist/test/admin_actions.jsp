<%@page import="com.liferay.lms.model.TestQuestion"%>
<%@page import="com.liferay.lms.model.LearningActivity"%>
<%@ include file="/init.jsp" %>
<%
ResultRow row =
(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
TestQuestion question = (TestQuestion)row.getObject();
long groupId = themeDisplay.getLayout().getGroupId();
String name = TestQuestion.class.getName();
String primKey = String.valueOf(question.getPrimaryKey());
String actId = String.valueOf(question.getActId());
%>
<liferay-ui:icon-menu>
<portlet:renderURL var="editURL">
<portlet:param name="jspPage" value="/html/lmsactivitieslist/test/editquestion.jsp"></portlet:param>
<portlet:param name="questionId" value="<%=primKey %>" />
<portlet:param name="actId" value="<%= actId %>" />
</portlet:renderURL>
<liferay-ui:icon image="edit" message="Edit" url="<%=editURL.toString() %>" />
<portlet:actionURL name="deletequestion" var="deleteURL">
<portlet:param name="questionId" value="<%= primKey %>" />
<portlet:param name="actId" value="<%= actId %>" />
</portlet:actionURL>
<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
</liferay-ui:icon-menu>
