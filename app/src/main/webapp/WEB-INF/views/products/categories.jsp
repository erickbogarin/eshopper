<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/wro" var="wroPath" />

<tags:pageTemplate
	title="${productFilter.category(categoryId)} | E-Shopper">
	 	<jsp:attribute name="extraScripts">
        	<script src="${wroPath}/extraScripts.js"></script>
	 	</jsp:attribute>
    <jsp:body>
    
	<%@include file="/WEB-INF/views/template/left-sidebar.jsp"%>

		<div class="col-sm-9 padding-right">
			<div class="features_items">
				<!--features_items-->
				<h2 class="title text-center">
					${productFilter.category(categoryId)}
				</h2>
				<%@include file="/WEB-INF/views/products/features.jsp"%>
			</div>
		</div>
		
	</jsp:body>
</tags:pageTemplate>