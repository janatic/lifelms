<%@page import="com.liferay.lms.service.LearningActivityLocalServiceUtil"%>
<%@page import="com.liferay.lms.model.LearningActivity"%>
<%@ include file="/init.jsp" %>
<portlet:actionURL var="newactivityURL" name="newactivity" >
</portlet:actionURL>
<portlet:renderURL var="cancel">
<portlet:param name="jspPage" value="/html/lmsactivitieslist/view.jsp"></portlet:param>
</portlet:renderURL>
<aui:model-context bean="<%= null %>" model="<%= LearningActivity.class %>" />
<aui:form name="newact" action="<%=newactivityURL%>"  method="post">
	<liferay-ui:asset-categories-error />
	<liferay-ui:asset-tags-error />
<aui:input name="title" label="title"></aui:input>
<aui:field-wrapper label="description">
			<liferay-ui:input-editor width="100%" />
			<aui:input name="description" type="hidden" />
		</aui:field-wrapper>
<aui:select name="typeId" label="type">
<aui:option value="0" label="test"></aui:option>
</aui:select>
<aui:input name="categories" type="assetCategories" /> 
<aui:input name="tags" type="assetTags" />
<aui:button-row>
<aui:button type="submit"></aui:button>
<aui:button href="<%= cancel %>" type="cancel" />
</aui:button-row>
</aui:form>