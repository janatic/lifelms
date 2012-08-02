<%@ include file="/html/lmsactivitieslist/test/init.jsp" %>

<c:if test='<%= !tabs1.equals("Questions") %>'>
<jsp:include  page="/html/lmsactivitieslist/editactivity.jsp" >
  <jsp:param  name="actId" value="<%=Long.toString(learnact.getActId()) %>"/>
  </jsp:include>
</c:if>
<c:if test='<%= tabs1.equals("Questions") %>'>
  <liferay-util:include page="/html/lmsactivitieslist/test/editquestions.jsp" servletContext="<%=this.getServletContext() %>">
  <liferay-util:param value="<%=Long.toString(learnact.getActId()) %>" name="actId"/>
  </liferay-util:include>
</c:if>
