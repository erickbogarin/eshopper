<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/" var="uploadedImages" />

<tags:pageTemplate title="${product.name } | E-Shopper">
	<jsp:attribute name="extraScripts">
		<script src="${classPath }/js/vendor/jquery.elevateZoom-3.0.8.min.js"></script>
		<script type="text/javascript">
			$('#image-zoom').elevateZoom();
		</script>
	</jsp:attribute>
	<jsp:body>
	 
		<%@include file="/WEB-INF/views/template/left-sidebar.jsp"%>
	
		<div class="col-sm-9 padding-right">
			<div class="product-details">
				<!--product-details-->
				<div class="col-sm-5">
					<img id="image-zoom" width="350px" height="350px" src="${product.mediumPhotoPath}"
						data-zoom-image="${product.largePhotoPath}"
						alt="${product.name}" />
				</div>
				<div class="col-sm-7">
					<div class="product-information"><!--/product-information-->
						<form:form servletRelativeAction="/shopping">
							<input type="hidden" value="${product.id}" name="productId"/>
							<h2>${product.name }</h2>
							<img src="${classPath}/images/product-details/rating.png" alt="" /><br>
							<span>
								<span>R$ ${product.price }</span>
								
								<button id="addCart" type="submit" class="btn btn-default cart">
									<i class="fa fa-shopping-cart"></i>
									<fmt:message key="label.cart"/>
								</button>
								
							</span>
							
							<p>
								<b><fmt:message key="label.brand"/>:</b> 
								${product.brand.brandType}
							</p>
							<a href="">
								<img src="${classPath}/images/product-details/share.png" class="share img-responsive" alt="" />
							</a>
						</form:form>
					</div>
				</div><!--/product-information-->
			</div>			
			
			<div class="category-tab shop-details-tab"><!--category-tab-->
				<div class="col-sm-12">
					<ul class="nav nav-tabs">
						<li class="active">
							<a href="#details" data-toggle="tab">
								<fmt:message key="show.product.details"/>
							</a>
						</li>
						<li>
							<a href="#reviews" data-toggle="tab">
								<fmt:message key="show.product.reviews"/>
							</a></li>
					</ul>
				</div>
				
				<div class="tab-content">
					<div class="tab-pane fade active in" id="details" >
						<div class="col-sm-12">
							<p>${product.description }</p>
						</div>	
					</div>
							
					<div class="tab-pane fade" id="reviews" >
						<div class="col-sm-12">
							<ul>
								<li><a href=""><i class="fa fa-user"></i>EUGEN</a></li>
								<li><a href=""><i class="fa fa-clock-o"></i>12:41 PM</a></li>
								<li><a href=""><i class="fa fa-calendar-o"></i>15 JAN 2016</a></li>
							</ul>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
							<p>
								<b>
									<fmt:message key="show.product.reviewLabel"/>
								</b>
							</p>
							
							<form action="#">
								<span>
									<input type="text" placeholder="<fmt:message key="label.name"/>"/>
									<input type="email" placeholder="<fmt:message key="label.email"/>"/>
								</span>
								<textarea name="" ></textarea>
								<button type="button" class="btn btn-default pull-right">
									Submit
								</button>
							</form>
						</div>
					</div>
							
				</div>
				</div><!--/category-tab-->		
		</div>
				
		
	</jsp:body>
</tags:pageTemplate>

