<%@tag language="java" pageEncoding="UTF-8"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="messages"/>

<c:url var="students" value="/app/students">
    <c:param name="idTeacher" value="${session_user_context.person.user.id}"></c:param>
</c:url>

<c:if test="${session_user_context.teacher}">
	<a class="btn btn-link m-0 color-darkblue" href="${students}">
		<fmt:message key="teacher.title.students"/>
	</a>
</c:if>