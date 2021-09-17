<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="appContext" value="${pageContext.request.contextPath}"/>
<fmt:message key="application.title.signin" var="title"/>

<u:templateJsp title="${title}">

    <c:if test="${not empty param.message}">
        <div class="d-flex justify-content-center mt-3">
            <div class="alert alert-warning col-8 text-center" role="alert">
            	<fmt:message key="${param.message}"></fmt:message>
            </div>
        </div>
    </c:if>
    
    <label class="d-flex justify-content-center bold size20 mt-3"><fmt:message key="login.welcome"/></label>
    
    <form method="post" action="${appContext}/app/login">
        <div class="container mt-3">
            <div class="row justify-content-center ">
                <div class="col-8 d-flex align-items-center justify-content-around">
                <img src="${appContext}/img/login.png" height="150">

                    <div class="col-8">
                        <div class="form-group">
                            <label class="form-label" for="username"><fmt:message key="login.username"/></label>
                            <input class="form-control" type="text" name="username" />
                        </div>
                        <div class="form-group">
                            <label class="form-label" for="password"><fmt:message key="login.password"/></label>
                        <input class="form-control" type="password" name="password" />
                    </div>
                </div>
                </div>
            </div>
            <div class="row justify-content-center mt-2">
               <div class="col-8 d-flex justify-content-around">
                   <button type="submit" class="col-3 btn btn-primary w-100 ">
                   		<fmt:message key="application.title.signin"/>
					</button>
               </div> 
            </div>
            <div class="row justify-content-center mt-3">
                <label><c:out value="${message}"></c:out></label>
            </div>
            
        </div>
    </form>
</u:templateJsp>