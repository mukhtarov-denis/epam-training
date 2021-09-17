<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="appContext" value="${pageContext.request.contextPath}"/>
<fmt:message key="application.title.all_courses" var="title"/>

<!-- 
    Информация о доступных курсах
 -->

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="messages"/>

<u:templateJsp title="${title}">

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-10 ">
                <table class="table table-sm table-bordered table-stripe table-hover">
                    <caption class="text-center color-dark-green bold size16">
                    	<fmt:message key="application.messages.course.welcome"/>
                    </caption>
                    <thead>
                        <tr class="text-center">
                            <th class="align-middle"><fmt:message key="application.title.number"/></th>
                            <th class="align-middle"><fmt:message key="application.title.course"/></th>
                            <th class="align-middle"><fmt:message key="course.start_date"/></th>
                            <th class="align-middle"><fmt:message key="course.end_date"/></th>
                            <th class="align-middle"><fmt:message key="application.title.teacher"/></th>
                            <th ${canSignUp} class="align-middle"><fmt:message key="course.can_signup"/></th>
                            <th class="align-middle"><fmt:message key="application.title.student.list"/></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="course" items="${courses}" varStatus="status">
                            <tr class="text-center">
                                <td>${status.count}</td>
                                <td>${course.key.name}</td>
                                <td><fmt:formatDate value="${course.key.startDate}" pattern="dd.MM.yyyy"/></td>
                                <td><fmt:formatDate value="${course.key.endDate}" pattern="dd.MM.yyyy"/></td>
                                <c:set var="teacherName" value="${fn:substring(course.key.teacher.name, 0, 1)}."></c:set>
                                <c:set var="teacherPatronymic" value="${fn:substring(course.key.teacher.patronymic, 0, 1)}."></c:set>
                                <td>${course.key.teacher.surname} ${teacherName} ${teacherPatronymic}</td>
                                <td>
                                    <c:if test="${course.value}">
	                                    <c:url var="addStudentToCourse" value="/app/course/signup">
	                                        <c:param name="idCourse" value="${course.key.id}"></c:param>
	                                    </c:url>
	                                    <a href="${addStudentToCourse}">
	                                        <img src="${appContext}/img/icon_add.png">
	                                    </a>
                                    </c:if>
                                </td>
                                <td>
                                    <c:url var="courseInfo" value="/app/course/info">
                                        <c:param name="idCourse" value="${course.key.id}"></c:param>
                                    </c:url>
                                    <a href="${courseInfo}">
                                        <img src="${appContext}/img/human_view.png">
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</u:templateJsp>