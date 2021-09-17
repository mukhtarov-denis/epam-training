<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<c:set var="appContext" value="${pageContext.request.contextPath}"/>
<fmt:message key="application.title.mark_review" var="title"/>
<!-- 
	Страница для просмотра/выставления отметок
 -->
<u:templateJsp title="${title}">
    
    <c:if test="${not empty message}">
	    <div class="d-flex justify-content-center mt-3">
	         <div class="alert alert-primary col-8 text-center" role="alert">
	             <fmt:message key="${message}"/>
	         </div>
	    </div>
    </c:if>
    
    <c:if test="${not empty param.infoMessage}">
        <div class="d-flex justify-content-center mt-3">
            <div class="alert alert-success col-8 text-center bold" role="alert">
            	<fmt:message key="${param.infoMessage}"/>
            </div>
        </div>
    </c:if>
	
	<c:if test="${not empty errorMessage}">
        <div class="d-flex justify-content-center mt-3">
            <div class="alert alert-warning col-8 text-center" role="alert">
            	<fmt:message key="${errorMessage}"/>
            </div>
        </div>
    </c:if>
    
    <c:if test="${empty errorMessage}">
    	<div class="d-flex justify-content-center mt-3">
    		<label class="col-form-label color-dark-green bold size16">
    			<c:out value="${course.name}"/> (<fmt:formatDate value="${course.startDate}" pattern="dd.MM.yyyy"/>-<fmt:formatDate value="${course.endDate}" pattern="dd.MM.yyyy"/>)	
    		</label>
    	</div>
    	
		<form action="${appContext}/app/teacher/addreview" method="post">
			<input hidden="true" type="text" value="${mark.course.id}" name="idCourse">
	        <input hidden="true" type="text" value="${mark.student.id}" name="idStudent">
			
		    <div class="container">
		        <div class="row justify-content-center">
		            <div class="col-6 form-group">
		                <label class="col-form-label bold">
		                	<fmt:message key="application.title.student"/>
		                </label>
		                <input readonly class="form-control" value="${mark.student.surname} ${mark.student.name} ${mark.student.patronymic}">
		            </div>
		        </div>   
		        <div class="row justify-content-center">
		            <div class="col-6 form-group">
		                <label class="col-form-label bold">
		                	<fmt:message key="application.title.mark"/>
						</label>
		                <input ${readonly} ${readOnlyIfStudent} class="form-control"
		                   type="number" value="${mark.value}" name="mark" pattern="\d{1,2}" min="1" max="10">
		            </div>
		        </div>
		        <div class="row justify-content-center">
		            <div class="col-6 form-group">
		                <label class="col-form-label bold">
		                	<fmt:message key="application.title.review"/>
		                </label>
		                <input ${readOnlyIfStudent} class="form-control" type="text" value="${mark.review}" name="review">
		            </div>
		        </div>
		        
		        <div class="d-flex justify-content-center mb-2">
			       	<button ${hiddenIfStudent} class="btn btn-primary" type="submit">
			       		<fmt:message key="application.button.addMark"/>
			       	</button>
			    </div>
		    </div>	
		</form>
		
		<c:if test="${empty mark.value}">
			<div class="d-flex justify-content-center mt-3">
	            <div class="alert alert-warning col-6 text-center" role="alert">
	                <fmt:message key="application.messages.mark.missing"/>
	            </div>
        	</div>
		</c:if>
		
		<c:if test="${empty mark.review}">
			<div class="d-flex justify-content-center mt-3">
	            <div class="alert alert-warning col-6 text-center" role="alert">
	            	<fmt:message key="application.messages.review.missing"/>
	            </div>
        	</div>
		</c:if>
		
	</c:if>
</u:templateJsp>