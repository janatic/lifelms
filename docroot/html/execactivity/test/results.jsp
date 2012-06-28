<%@page import="com.liferay.lms.service.LearningActivityTryLocalServiceUtil"%>
<%@page import="com.liferay.lms.model.LearningActivityTry"%>
<%@ include file="/init.jsp" %>
<%
long latId=ParamUtil.getLong(request,"latId" );
LearningActivityTry larntry=LearningActivityTryLocalServiceUtil.getLearningActivityTry(latId);
%>

<div id="score"><%=larntry.getResult() %></div>