<%--
  Created by IntelliJ IDEA.
  User: Erick
  Date: 03/04/2016
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/resources" var="classPath" />
<c:url value="/wro" var="wroPath" />

<tags:pageTemplate
        title="${person} - E-Shopper">
		<jsp:attribute name="extraScripts">
        	<script src="${wroPath}/extraScripts.js"></script>
	 	</jsp:attribute>
    <jsp:body>
        <main>

            <%@include file="/WEB-INF/views/template/left-sidebar.jsp"%>

            <div class="col-sm-9 padding-right">
                <div class="features_items"><!--features_items-->
                    <h2 class="title text-center">
                        ${person}
                    </h2>
                </div>
                <%@include file="/WEB-INF/views/products/features.jsp" %>
            </div>
        </main>
    </jsp:body>

</tags:pageTemplate>