<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:url value="/resources" var="classPath"/>

<div class="col-sm-3">
    <div class="left-sidebar">
        <h2>
            <fmt:message key="left-sidebar.category"/>
        </h2>
        <div class="panel-group category-products" id="accordian">
            <!--category-productsr-->
            <c:forEach items="${productFilter.categories()}" var="category">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a href="${spring:mvcUrl('PLC#categories').arg(0, category.id).arg(1, category.categoryType.toString().toLowerCase()).build()}">${category.categoryType.toString()}</a>
                        </h4>
                    </div>
                </div>
            </c:forEach>
        </div>
        <!--/category-products-->

        <div class="brands_products">
            <!--brands_products-->
            <h2>
                <fmt:message key="left-sidebar.brands"/>
            </h2>
            <div class="brands-name">
                <ul class="nav nav-pills nav-stacked">
                    <c:forEach items="${productFilter.brands()}" var="brand">
                        <li>
                            <a href="${spring:mvcUrl('PLC#brands').arg(0, brand.id).arg(1, brand.brandType.toString().toLowerCase()).build()}"> ${brand.brandType.getName()} </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <!--/brands_products-->

        <div class="shipping text-center">
            <!--shipping-->
            <img src="${classPath }/images/home/shipping.jpg" alt=""/>
        </div>
        <!--/shipping-->

    </div>
</div>