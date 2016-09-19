<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/" var="uploadedImages" />

<c:forEach items="${products}" var="product">
	<div class="col-sm-4">
		<div class="product-image-wrapper">
			<div class="single-products">
				<div class="productinfo text-center">
					<img class="lazy" width="255px" height="237px" data-original="${product.mediumPhotoPath}" alt="${product.name }" />
					<h2>R$ ${product.price }</h2>
					<p class="product-name">${product.name}</p>
					<a href="${spring:mvcUrl('PLC#show').arg(0,product.nameId).build()}"
						class="btn btn-default add-to-cart"><i
						class="fa fa-shopping-cart"> </i>
					<fmt:message key="label.cart" /></a>
				</div>
				<div class="product-overlay">
					<div class="overlay-content">
						<img class="lazy" width="255px" height="237px" data-original="${product.mediumPhotoPath}" alt="${product.name }" />
						<h2>R$ ${product.price }</h2>
						<p>${product.name}</p>
						<a href="${spring:mvcUrl('PLC#show').arg(0,product.nameId).build()}"
							class="btn btn-default add-to-cart"><i
							class="fa fa-shopping-cart"> </i>
						<fmt:message key="show.product.details" /> </a>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:forEach>

