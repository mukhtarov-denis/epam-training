<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="appContext" value="${pageContext.request.contextPath}"/>
<fmt:message key="application.title.course_students" var="title"/>

<!-- Список студентов курса  -->

<u:templateJsp title="${title}">

    <div class="container">
        <table class="table table-sm table-bordered table-stripe table-hover">
            <caption class="text-center color-dark-green bold size16">
                <c:out value="${course.name}"/> (<fmt:formatDate value="${course.startDate}" pattern="dd.MM.yyyy"/>-<fmt:formatDate value="${course.endDate}" pattern="dd.MM.yyyy"/>)
            	<span class="badge badge-primary badge-pill"><c:out value="${course.students.size()}"/></span>
            </caption>
            <thead>
                <tr class="text-center">
                    <th><fmt:message key="application.title.number"/></th>
                    <th><fmt:message key="application.title.surname"/></th>
                    <th><fmt:message key="application.title.name"/></th>
                    <th><fmt:message key="application.title.patronymic"/></th>
                    <th><fmt:message key="application.title.dborn"/></th>
                    <th><fmt:message key="student.number"/></th>
                    <th><fmt:message key="student.group"/></th>
                    <th><fmt:message key="application.title.review"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="mark" items="${marks}" varStatus="status">
                    <tr class="text-center">
                        <td><c:out value="${status.count}"/></td>
                        <td><c:out value="${mark.student.surname}"/></td>
                        <td><c:out value="${mark.student.name}"/></td>
                        <td><c:out value="${mark.student.patronymic}"/></td>
                        <td><fmt:formatDate value="${mark.student.bornDate}" pattern="dd.MM.yyyy"/></td>
                        <td><c:out value="${mark.student.studentNumber}"/></td>
                        <td><c:out value="${mark.student.groupNumber}"/></td>
                        <td>
                            <c:url var="mark" value="/app/mark">
                                <c:param name="idCourse" value="${mark.course.id}"></c:param>
                                <c:param name="idStudent" value="${mark.student.id}"></c:param>
                                <c:param name="idTeacher" value="${course.teacher.id}"></c:param>
                            </c:url>
                            <a href="${mark}">
                                <img src="${appContext}/img/icon_review.png" alt="" height="28">
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</u:templateJsp>