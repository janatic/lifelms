<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.lms.service.LearningActivityLocalServiceUtil"%>
<%@page import="com.liferay.lms.service.LearningActivityServiceUtil"%>


<%@page import="com.liferay.lms.model.LearningActivity"%>
<%@ include file="/init.jsp" %>
<portlet:actionURL var="saveactivityURL" name="saveActivity" >
</portlet:actionURL>
<portlet:renderURL var="cancel">
<portlet:param name="jspPage" value="/html/lmsactivitieslist/view.jsp"></portlet:param>
</portlet:renderURL>
<%
String redirect = ParamUtil.getString(request, "redirect");
String backURL = ParamUtil.getString(request, "backURL");

String referringPortletResource = ParamUtil.getString(request, "referringPortletResource");
	long actId=ParamUtil.getLong(request, "actId",0);
LearningActivity learnact=null;
if(request.getAttribute("activity")!=null)
{
	
 learnact=(LearningActivity)request.getAttribute("activity");
}
else
{
	if(actId>0)
	{
		learnact=LearningActivityLocalServiceUtil.getLearningActivity(actId);
	}
	
}
	ParamUtil.print(request);
	
%>
<%
String description="";
SimpleDateFormat formatDay    = new SimpleDateFormat("dd");
SimpleDateFormat formatMonth    = new SimpleDateFormat("MM");
SimpleDateFormat formatYear    = new SimpleDateFormat("yyyy");
SimpleDateFormat formatHour   = new SimpleDateFormat("HH");
SimpleDateFormat formatMin = new SimpleDateFormat("mm");
Date today=new Date(System.currentTimeMillis());
int startDay=Integer.parseInt(formatDay.format(today));
int startMonth=Integer.parseInt(formatMonth.format(today))-1;
int startYear=Integer.parseInt(formatYear.format(today));
int startHour=Integer.parseInt(formatHour.format(today));
int startMin=Integer.parseInt(formatMin.format(today));
int endDay=Integer.parseInt(formatDay.format(today));
int endMonth=Integer.parseInt(formatMonth.format(today));
int endYear=Integer.parseInt(formatYear.format(today))-1;
int endHour=Integer.parseInt(formatHour.format(today));
int endMin=Integer.parseInt(formatMin.format(today));
if(learnact!=null)
	{
	actId=learnact.getActId();
	description=learnact.getDescription();
	startDay=Integer.parseInt(formatDay.format(learnact.getStartdate()));
	startMonth=Integer.parseInt(formatMonth.format(learnact.getStartdate()))-1;
	startYear=Integer.parseInt(formatYear.format(learnact.getStartdate()));
	startHour=Integer.parseInt(formatHour.format(learnact.getStartdate()));
	startMin=Integer.parseInt(formatMin.format(learnact.getStartdate()));
	endDay=Integer.parseInt(formatDay.format(learnact.getEnddate()));
	endMonth=Integer.parseInt(formatMonth.format(learnact.getEnddate()))-1;
	endYear=Integer.parseInt(formatYear.format(learnact.getEnddate()));
	endHour=Integer.parseInt(formatHour.format(learnact.getEnddate()));
	endMin=Integer.parseInt(formatMin.format(learnact.getEnddate()));
	%>
<aui:model-context bean="<%= learnact %>" model="<%= LearningActivity.class %>" />
<%
	}
else
{
	%>
	<aui:model-context  model="<%= LearningActivity.class %>" />
	<%
}
%>
<aui:form name="newact" action="<%=saveactivityURL%>"  method="post">
	<liferay-ui:asset-categories-error />
	<liferay-ui:asset-tags-error />
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="referringPortletResource" type="hidden" value="<%= referringPortletResource %>" />
	
<aui:input name="actId" type="hidden" value="<%=actId %>"/>
<aui:input name="title" label="title"></aui:input>
<aui:field-wrapper label="description">
			<liferay-ui:input-editor name="description" width="100%" />
			<aui:input name="description" type="hidden" />
				<script type="text/javascript">
        function <portlet:namespace />initEditor() { return "<%= UnicodeFormatter.toString(description) %>"; }
    </script>
		</aui:field-wrapper>
		<aui:field-wrapper label="start-date">

		<liferay-ui:input-date yearRangeEnd="2020" yearRangeStart="2012"  dayParam="startDay" monthParam="startMon"
				 yearParam="startYear"  yearNullable="false" dayNullable="false" monthNullable="false" yearValue="<%=startYear %>" monthValue="<%=startMonth %>" dayValue="<%=startDay %>"></liferay-ui:input-date>
		<liferay-ui:input-time minuteParam="startMin" amPmParam="startAMPM" hourParam="startHour" hourValue="<%=startHour %>" minuteValue="<%=startMin %>"></liferay-ui:input-time>
		</aui:field-wrapper>
		<aui:field-wrapper label="end-date">
		
				<liferay-ui:input-date yearRangeEnd="2020" yearRangeStart="2012" dayParam="stopDay" monthParam="stopMon"
				 yearParam="stopYear"  yearNullable="false" dayNullable="false" monthNullable="false"  yearValue="<%=endYear %>" monthValue="<%=endMonth %>" dayValue="<%=endDay %>"></liferay-ui:input-date>
				 <liferay-ui:input-time minuteParam="stopMin" amPmParam="stopAMPM" hourParam="stopHour"  hourValue="<%=endHour %>" minuteValue="<%=endMin %>"></liferay-ui:input-time></br>
		</aui:field-wrapper>
<aui:input name="tries" label="tries" ></aui:input>		
<aui:select name="typeId" label="type">
<aui:option value="0" label="lms-test"></aui:option>
<aui:option value="1" label="lms-task"></aui:option>
</aui:select>
<aui:input name="tags" type="assetTags" />
<aui:input name="categories" type="assetCategories" />
<aui:button-row>
<aui:button type="submit"></aui:button>
<aui:button href="<%= cancel %>" type="cancel" />
</aui:button-row>
</aui:form>