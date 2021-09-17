<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="appContext" value="${pageContext.request.contextPath}"/>

<u:templateJsp title="Servlet Exception">
    <div class="container">
	    <div class="alert alert-danger text-center form-group">
	        <label class="col-form-label bold">
	            javax.servlet.error.status_code
	        </label>
	        <label class="form-control">
	            ${requestScope['javax.servlet.error.status_code']}
	        </label>
	    </div>
	
	    <div class="alert alert-danger text-center form-group">
	        <label class="col-form-label bold">
	            javax.servlet.error.exception_type
	        </label>
	        <label class="form-control">
	            ${requestScope['javax.servlet.error.exception_type']}
	        </label>
	    </div>
	    
	    <div class="alert alert-danger text-center form-group">
	        <label class="col-form-label bold">
	            javax.servlet.error.message
	        </label>
	        <label class="form-control">
	            ${requestScope['javax.servlet.error.message']}
	        </label>
	    </div>
	    
	    <div class="alert alert-danger text-center form-group">
	        <label class="col-form-label bold">
	            javax.servlet.error.request_uri
	        </label>
	        <label class="form-control">
	            ${requestScope['javax.servlet.error.request_uri']}
	        </label>
	    </div>
	    
	    <div class="alert alert-danger text-center form-group">
	        <label class="col-form-label bold">
	            javax.servlet.error.exception
	        </label>
	        <label class="form-control">
	            ${requestScope['javax.servlet.error.exception']}
	        </label>
	    </div>
	    
	    <div class="alert alert-danger text-center form-group">
	        <label class="col-form-label bold">
	            javax.servlet.error.servlet_name
	        </label>
	        <label class="form-control">
	            ${requestScope['javax.servlet.error.servlet_name']}
	        </label>
	    </div>
    </div>
</u:templateJsp>