<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="appContext" value="${pageContext.request.contextPath}"/>
<fmt:message key="student.title.courses" var="title"/>

<!-- 
    Информация о курсах студента
 -->
<u:templateJsp title="${title}">

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-10 ">
                <table class="table table-sm table-bordered table-stripe table-hover">
                    <caption class="text-center color-dark-green bold size16"><fmt:message key="student.title.courses" /></caption>
                    <thead>
                        <tr class="text-center">
                            <th class="align-middle"><fmt:message key="application.title.number"/></th>
                            <th class="align-middle"><fmt:message key="application.title.course"/></th>
                            <th class="align-middle"><fmt:message key="course.start_date"/></th>
                            <th class="align-middle"><fmt:message key="course.end_date"/></th>
                            <th class="align-middle"><fmt:message key="application.title.teacher"/></th>
                            <th class="align-middle"><fmt:message key="application.title.mark"/></th>
                            <th class="align-middle"><fmt:message key="application.title.review"/></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="mark" items="${student.marks}" varStatus="status">
                            <tr class="text-center">
                                <td>${status.count}</td>
                                <td>${mark.course.name}</td>
                                <td><fmt:formatDate value="${mark.course.startDate}" pattern="dd.MM.yyyy"/></td>
                                <td><fmt:formatDate value="${mark.course.endDate}" pattern="dd.MM.yyyy"/></td>
                                <c:set var="teacherName" value="${fn:substring(mark.course.teacher.name, 0, 1)}."></c:set>
                                <c:set var="teacherPatronymic" value="${fn:substring(mark.course.teacher.patronymic, 0, 1)}."></c:set>
                                <td>${mark.course.teacher.surname} ${teacherName} ${teacherPatronymic}</td>
                                <c:url var="viewMark" value="/app/mark">
                                      <c:param name="idCourse" value="${mark.course.id}"></c:param>
                                      <c:param name="idStudent" value="${mark.student.id}"></c:param>
                                      <c:param name="idTeacher" value="${mark.course.teacher.id}"></c:param>
                                </c:url>
                                <td>
                                    <c:if test="${not empty mark.value}">                                        
                                        <a href="${viewMark}">
                                            <img src="${appContext}/img/yes.png">
                                        </a>
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${not empty mark.review}">                                        
                                        <a href="${viewMark}">
                                            <img src="${appContext}/img/yes.png">
                                        </a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>    
</u:templateJsp>