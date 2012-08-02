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
<c:if test="<%= permissionChecker.hasPermission(myActivity.getGroupId(), LearningActivity.class.getName(), myActivity.getActId(),
ActionKeys.UPDATE) %>">
<liferay-ui:icon-menu>
<c:if test="<%= permissionChecker.hasPermission(myActivity.getGroupId(), LearningActivity.class.getName(), myActivity.getActId(),
ActionKeys.UPDATE)||permissionChecker.hasPermission(myActivity.getGroupId(), LearningActivity.class.getName(), myActivity.getActId(),
		ActionKeys.DELETE)||permissionChecker.hasPermission(myActivity.getGroupId(), LearningActivity.class.getName(), myActivity.getActId(),
				ActionKeys.PERMISSIONS)%>">
<portlet:actionURL name="editactivity" var="editURL">
<portlet:param name="actId" value="<%=primKey %>" />
</portlet:actionURL>

<liferay-ui:icon image="edit" message="edit" url="<%=editURL.toString() %>" />
</c:if>
<c:if test="<%= permissionChecker.hasPermission(myActivity.getGroupId(), LearningActivity.class.getName(), myActivity.getActId(),
ActionKeys.DELETE) %>">
<portlet:actionURL name="deleteactivity" var="deleteURL">
<portlet:param name="actId" value="<%= primKey %>" />
</portlet:actionURL>
<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
</c:if>
<c:if test="<%= permissionChecker.hasPermission(myActivity.getGroupId(), LearningActivity.class.getName(), myActivity.getActId(),
ActionKeys.PERMISSIONS) %>">
				<liferay-security:permissionsURL
					modelResource="<%=LearningActivity.class.getName() %>"
					modelResourceDescription="<%= myActivity.getTitle() %>"
					resourcePrimKey="<%= String.valueOf(myActivity.getActId()) %>"
					var="permissionsURL"
				/>
				<liferay-ui:icon image="permissions" message="permissions" url="<%=permissionsURL %>" />			
			</c:if>
</liferay-ui:icon-menu>
</c:if>