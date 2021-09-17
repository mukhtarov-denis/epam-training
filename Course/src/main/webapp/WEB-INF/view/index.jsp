<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="appContext" value="${pageContext.request.contextPath}"/>
<fmt:message key="application.title.main_page" var="title"/>

<u:templateJsp title="${title}">

    <div class="d-flex justify-content-center mt-5">
        <span class="bold"><fmt:message key="application.messages.welcome"/></span>
    </div>
    
    <div class="d-flex justify-content-center mt-3">
        <img alt="" src="${appContext}/img/icon_faculty.png" height="100">
    </div>    
    
    <div class="d-flex justify-content-center mt-3">
        <a href="${appContext}/app/course"><fmt:message key="application.title.viewAllCourses"/></a>
	</div>

</u:templateJsp>