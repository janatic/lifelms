<%@page import="com.liferay.lms.model.TestAnswer"%>
<%@page import="com.liferay.lms.model.TestQuestion"%>
<%@page import="com.liferay.lms.model.LearningActivity"%>
<%@ include file="/init.jsp" %>
<%
ResultRow row =
(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
TestAnswer answer = (TestAnswer)row.getObject();
long groupId = themeDisplay.getLayout().getGroupId();
String name = TestAnswer.class.getName();
String primKey = String.valueOf(answer.getPrimaryKey());
String questionId=String.valueOf(answer.getQuestionId());
String actId = String.valueOf(answer.getActId());
%>
<liferay-ui:icon-menu>
<portlet:renderURL var="editURL">
<portlet:param name="jspPage" value="/html/lmsactivitieslist/test/editanswer.jsp"></portlet:param>
<portlet:param name="answer" value="<%=primKey %>" />
<portlet:param name="actId" value="<%= actId %>" />
</portlet:renderURL>
<liferay-ui:icon image="edit" message="Edit" url="<%=editURL.toString() %>" />
<portlet:actionURL name="deleteanswer" var="deleteURL">
<portlet:param name="answerId" value="<%= primKey %>" />
<portlet:param name="actId" value="<%= actId %>" />
<portlet:param name="questionId" value="<%= questionId %>" />
<portlet:param name="jspPage" value="/html/lmsactivitieslist/test/editquestion.jsp"></portlet:param>
</portlet:actionURL>
<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
</liferay-ui:icon-menu>
