<%@tag language="java" pageEncoding="UTF-8"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="messages"/>

<c:url var="cources" value="/app/mycources" />
<c:if test = "${session_user_context.student}">
	<a class="btn btn-link m-0 color-darkblue" href="${cources}">
		<fmt:message key="student.title.courses"/>
	</a>
</c:if>