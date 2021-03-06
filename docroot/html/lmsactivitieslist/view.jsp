<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.lms.service.LearningActivityLocalServiceUtil"%>
<%@page import="com.liferay.lms.service.LearningActivityServiceUtil"%>
<%@page import="com.liferay.lms.model.LearningActivity"%>
<%@ include file="/init.jsp" %>
<portlet:renderURL var="newactivityURL">
<portlet:param name="jspPage" value="/html/lmsactivitieslist/editactivity.jsp"></portlet:param>
</portlet:renderURL>
<div class="portlet-toolbar search-form">
<%
java.util.List<LearningActivity> activities=LearningActivityServiceUtil.getLearningActivitiesOfGroup(scopeGroupId);

if( permissionChecker.hasPermission(themeDisplay.getScopeGroupId(),  LearningActivity.class.getName(),0,ActionKeys.ADD_ENTRY))
{
%>
<liferay-ui:icon
image="add"
label="<%= true %>"
message="new"
url='<%= newactivityURL %>'
/>
<%
}
%>
<liferay-ui:error ></liferay-ui:error>
<liferay-ui:search-container emptyResultsMessage="there-are-no-activities"
 delta="10">
<liferay-ui:search-container-results>
<%
results = ListUtil.subList(activities, searchContainer.getStart(),
searchContainer.getEnd());
total = activities.size();
pageContext.setAttribute("results", results);
pageContext.setAttribute("total", total);
%>
</liferay-ui:search-container-results>
<liferay-ui:search-container-row
className="com.liferay.lms.model.LearningActivity"
keyProperty="actId"
modelVar="activity">
<liferay-ui:search-container-column-text
name="title"
property="title"
orderable="true"
/>
<liferay-ui:search-container-column-text
name="description"
property="description"
/>
<liferay-ui:search-container-column-text
name="type"
property="typeId"
orderable="true"
/>
<c:if test="<%= permissionChecker.hasPermission(activity.getGroupId(), LearningActivity.class.getName(), activity.getActId(),
ActionKeys.UPDATE)||permissionChecker.hasPermission(activity.getGroupId(), LearningActivity.class.getName(), activity.getActId(),
		ActionKeys.DELETE)||permissionChecker.hasPermission(activity.getGroupId(), LearningActivity.class.getName(), activity.getActId(),
				ActionKeys.PERMISSIONS)%>">
<liferay-ui:search-container-column-jsp
path="/html/lmsactivitieslist/admin_actions.jsp"
align="right"
/>
</c:if>
</liferay-ui:search-container-row>
<liferay-ui:search-iterator />

</liferay-ui:search-container>