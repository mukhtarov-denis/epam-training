<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="appContext" value="${pageContext.request.contextPath}"/>

<u:templateJsp title="Error 404">
    <div class="container">
        <div class="alert alert-danger text-center">
            Error 404
        </div>
    </div>
</u:templateJsp>