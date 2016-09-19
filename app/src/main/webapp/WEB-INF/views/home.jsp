<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<c:url value="/resources" var="classPath" />
<c:url value="/wro" var="wroPath" />

<tags:pageTemplate
        title="Roupas Masculinas e Femininas | Compre Calças, Camisetas e Mais - E-Shopper">
	 <jsp:attribute name="extraScripts">
        <script src="${wroPath}/extraScripts.js"></script>
	 </jsp:attribute>
    <jsp:body>

        <main>

            <c:if test="${not empty sucesso}" >
                <div class="alert alert-success alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    ${sucesso}
                </div>
            </c:if>
			
            <%@include file="/WEB-INF/views/template/slider.jsp" %>

            <%@include file="/WEB-INF/views/template/left-sidebar.jsp" %>

            <div class="col-sm-9 padding-right">
                <div class="features_items"><!--features_items-->
                    <h2 class="title text-center">
                        <fmt:message key="product.features"/>
                    </h2>
                </div>
                <%@include file="/WEB-INF/views/products/features.jsp" %>
            </div>
        </main>
    </jsp:body>

</tags:pageTemplate>