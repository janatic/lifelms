<%@page import="com.liferay.lms.model.TestQuestion"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.lms.service.TestQuestionLocalServiceUtil"%>
<%@page import="com.liferay.lms.model.LearningActivity"%>
<%
LearningActivity larn=(LearningActivity)request.getAttribute("learningactivity");
%>
<h1><%=larn.getTitle() %></h1>
<p><%=larn.getDescription() %></p>
