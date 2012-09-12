<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@ include file="/html/lmsactivitieslist/test/init.jsp" %>

<%
TestQuestion question = TestQuestionLocalServiceUtil.getTestQuestion(ParamUtil.getLong(request,"questionId"));

%>
<portlet:actionURL var="editquestionURL" name="editquestion" >
</portlet:actionURL>
<portlet:renderURL var="cancel">
<portlet:param name="jspPage" value="/html/lmsactivitieslist/view.jsp"></portlet:param>
</portlet:renderURL>
<aui:form action="<%=editquestionURL %>" method="post">
<aui:input name="actId" type="hidden" value="<%=question.getActId() %>"></aui:input>
<aui:input name="questionId" type="hidden" value="<%=question.getQuestionId() %>"></aui:input>
<aui:field-wrapper label="text">
			<liferay-ui:input-editor name="text" width="50%" />
			<aui:input name="text" type="hidden" />	
					<script type="text/javascript">
        function <portlet:namespace />initEditor() { return "<%= UnicodeFormatter.toString(question.getText()) %>"; }
    </script>
		</aui:field-wrapper>
<aui:select name="typeId" label="qtype">
<aui:option value="0" label="options"></aui:option>
</aui:select>
<aui:button-row>
<aui:button type="submit">Submit</aui:button>
<aui:button href="<%= cancel %>" type="cancel" />
</aui:button-row>
</aui:form>
<%
java.util.List<TestAnswer> testanswers=TestAnswerLocalServiceUtil.getTestAnswersByQuestionId(question.getQuestionId());
String iconChecked = "checked";
String iconUnchecked = "unchecked";
%>


<portlet:actionURL var="addanswerURL" name="addanswer" >
</portlet:actionURL>
<aui:form action="<%=addanswerURL%>" method="post">
<aui:input  name="answer" label="Answer"></aui:input>
<aui:input type="hidden" name="questionId" value="<%=question.getQuestionId() %>"></aui:input>
<aui:input type="checkbox" name="correct" label="correct"></aui:input>
<aui:button type="submit">New answer</aui:button>
</aui:form>

<liferay-ui:search-container emptyResultsMessage="there-are-no-answers" delta="5">
<liferay-ui:search-container-results>
<%
results = ListUtil.subList(testanswers, searchContainer.getStart(),
searchContainer.getEnd());
total = testanswers.size();
pageContext.setAttribute("results", results);
pageContext.setAttribute("total", total);

%>
</liferay-ui:search-container-results>
<liferay-ui:search-container-row
className="com.liferay.lms.model.TestAnswer"
keyProperty="answerId"
modelVar="testanswer">


<liferay-ui:search-container-column-text name="answer">
<portlet:actionURL var="editanswerURL" name="editanswer" >
</portlet:actionURL>
<aui:form id="f_<%=testanswer.getAnswerid %>" action="<%=editanswerURL %>" method="post">
<aui:input type="hidden" name="answerId" value="<%=testanswer.getAnswerId() %>"></aui:input>
	<aui:input type="checkbox" name="correct" checked="<%=testanswer.getIsCorrect() %>"></aui:input>
<aui:input name="answer" value="<%=testanswer.getAnswer() %>"></aui:input>
<input type="submit"></input>
</aui:form>
</liferay-ui:search-container-column-text>


<%--
<liferay-ui:search-container-column-jsp
path="/html/lmsactivitieslist/test/admin_answer_actions.jsp"
align="right"
/>
--%>
</liferay-ui:search-container-row>
<liferay-ui:search-iterator />

</liferay-ui:search-container>