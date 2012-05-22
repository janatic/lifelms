
<%@page import="com.liferay.lms.service.LearningActivityLocalServiceUtil"%>
<%@page import="com.liferay.lms.model.LearningActivity"%>

<%@ include file="/init.jsp" %>
<%
long actId=ParamUtil.getLong(request,"actId");
LearningActivity learnact=LearningActivityLocalServiceUtil.getLearningActivity(actId);

%>
<portlet:actionURL var="addquestionURL" name="addquestion" >
</portlet:actionURL>
<portlet:renderURL var="cancel">
<portlet:param name="jspPage" value="/html/lmsactivitieslist/view.jsp"></portlet:param>
</portlet:renderURL>
<aui:form name="newact" action="<%=addquestionURL%>"  method="post">
<aui:input name="actId" type="hidden" value="<%= learnact.getActId()%>"></aui:input>
<aui:input name="text" label="text"></aui:input>
<aui:select name="typeId" label="qtype">
<aui:option value="0" label="options"></aui:option>
</aui:select>
<aui:button-row>
<aui:button type="submit">Submit</aui:button>
<aui:button href="<%= cancel %>" type="cancel" />
</aui:button-row>
</aui:form>