<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<c:set var="appContext" value="${pageContext.request.contextPath}"/>
<fmt:message key="application.title.course.signup" var="title"/>

<u:templateJsp title="${title}">
    
    <div class="container ">   
        <div class="d-flex justify-content-center mt-3">
            <label class="bold size16 color-dark-green"><fmt:message key="application.title.dear"/>, ${student.surname} ${student.name} ${student.patronymic}!</label>
            <c:if test="${canSignUp}">&nbsp;
            	<label class="bold size16 color-dark-green">
            		<fmt:message key="${userMessage}"/>
            	</label>
            </c:if>
        </div>
    
        <div class="row justify-content-center">
            <div class="col-6 form-group">
                <label class="col-form-label bold"><fmt:message key="application.title.course"/></label>
                <label class="form-control">${course.name}</label>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-6 form-group">
                <label class="col-form-label bold"><fmt:message key="application.title.teacher"/></label>
                <label class="form-control">${course.teacher.surname} ${course.teacher.name} ${course.teacher.patronymic}</label>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-6 form-group">
                <label class="col-form-label bold">
                    <fmt:message key="application.title.student.list"/> <span class="badge badge-primary badge-pill">${fn:length(course.students)}</span>
                </label>
                <ol class="list-group">
                    <c:forEach var="student" items="${course.students}">
                        <li class="list-group-item">${student.surname} ${student.name} ${student.patronymic}</li>
                    </c:forEach>
                </ol>
            </div>
        </div>
    </div>
    
    <c:choose>
           <c:when test="${canSignUp}">
               <form action="${appContext}/app/course/addstudent" method="post">
                <input hidden="true" type="text" value="${course.id}" name="idCourse">
                <input hidden="true" type="text" value="${session_user_context.person.user.id}" name="idStudent">
                <div class="d-flex justify-content-center">
                    <button class="btn btn-primary">
                    	<fmt:message key="application.button.signup"/>
					</button>
                </div>
            </form>
           </c:when>
           <c:otherwise>
               <div class="d-flex justify-content-center mt-2">
	                <label class="bold size14 color-dark-green">
	                	<fmt:message key="${message}"/>
	                </label>
            	</div>
           </c:otherwise>
    </c:choose>



</u:templateJsp>