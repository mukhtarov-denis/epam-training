<%@tag language="java" pageEncoding="UTF-8"  %>
<%@attribute name="title" rtexprvalue="true" required="true" type="java.lang.String"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="appContext" value="${pageContext.request.contextPath}"/>

<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${title}</title> 
    <link rel="shortcut icon" href="${appContext}/img/favicon.png" type="image/png">
    
    <link rel="stylesheet" href="${appContext}/webjars/bootstrap/4.1.3/css/bootstrap.min.css">

    <link rel="stylesheet" href="${appContext}/css/style.css">
    <link rel="stylesheet" href="${appContext}/css/font.css">
    <link rel="stylesheet" href="${appContext}/css/table.css">
    <link rel="stylesheet" href="${appContext}/css/button.css">
    <link rel="stylesheet" href="${appContext}/css/color.css">
    
    <script type="text/javascript" src="${appContext}/js/changeLanguage.js"></script>
</head>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="messages"/>

<body>	
    <div class="sticky-top">
        <nav class="navbar navbar-expand-lg navbar-light navbar-static-top nav_bgcolor_gradient m-1">
            <a class="navbar-brand bold" href="${appContext}/app">
                <img src="${appContext}/img/courses.png" height="40" class="d-inline-block" alt="">
                <fmt:message key="application.title"/>

            </a>
            <div class="collapse navbar-collapse d-flex justify-content-center" id="navbarNav" >
                <label class="form-label bold">Или учись, или до свидания!</label>
            </div>
            
            <form class="form-inline m-0">
            	<div class="lang" onclick="doLang();">
            		<img src="${appContext}/img/lang/${cookie['lang'].value}.png" height="30" class="d-inline-block" alt="">
            	</div>
                <c:set var="userRole" value=""/>
                <c:forEach items="${session_user_context.person.user.roles}" var="role">
                    <c:set var="userRole" value="${userRole} ${role.name}"></c:set>
                </c:forEach>
            
                <c:choose>
                    <c:when test="${not empty session_user_context}">
                        
                        <div class="d-flex justify-content-around">
                            <u:student></u:student>
                            <u:teacher></u:teacher>
                            <c:set var="userName" value="${fn:substring(session_user_context.person.name, 0, 1)}."></c:set>
                            <c:set var="userPatronymic" value="${fn:substring(session_user_context.person.patronymic, 0, 1)}."></c:set>
                            <c:set var="vUser" value="${session_user_context.person.surname} ${userName}${userPatronymic}" />
                            <label class="m-0 underline">${vUser}</label>
                            <label>&nbsp;&nbsp;<fmt:message key="application.title.role"/>: ${userRole}</label>
                            <c:url var="urlLogout" value="/app/logout" />
                            <a class="btn btn-link m-0 color-darkblue" href="${urlLogout}">
                            	<fmt:message key="application.title.logout"/>
                            </a>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <c:url var="urlSignin" value="/app/login" />
                        <a class="btn btn-link m-0 color-darkblue" href="${urlSignin}">
                        	<fmt:message key="application.title.signin"/>
                        </a>
                    </c:otherwise>
                </c:choose>
            </form>
        </nav>
    </div>
    
    <div>
        <jsp:doBody />
    </div>
</body>
</html>
