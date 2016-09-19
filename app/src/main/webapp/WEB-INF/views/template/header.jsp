<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/resources" var="classPath" />

<header id="header">
	<!--header-->
	<div class="header_top">
		<!--header_top-->
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="contactinfo">
						<ul class="nav nav-pills">
							<li><a href="#"><i class="fa fa-phone"></i> +2 95 01 88
									821</a></li>
							<li><a href="#"><i class="fa fa-envelope"></i>
									contanto@erickbogarin.com.br</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="social-icons pull-right">
						<ul class="nav navbar-nav">
							<li><a href="#"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
							<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
							<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/header_top-->

	<div class="header-middle">
		<!--header-middle-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<div class="logo pull-left">
						<a href="${s:mvcUrl('HC#index').build() }"> <img
							src="${classPath }/images/home/logo.png" alt="E-Shopper" />
						</a>
					</div>
					<div class="btn-group pull-right">
						<div class="btn-group">
							<a href="?locale=pt" id="firstLanguage" 
								class="btn btn-default dropdown-toggle locale usa"
								data-toggle="dropdown">
							</a>
							<ul class="dropdown-menu">
								<li><a id="secondLanguage" href='<c:out value="?locale=en_US" />'></a></li>
							</ul>
						</div>
					
					</div>
				</div>
				<div class="col-sm-8">
					<div class="shop-menu pull-right">
						<ul class="nav navbar-nav">
							<li><a href="${s:mvcUrl('SCC#items').build() }"><i
									class="fa fa-shopping-cart"></i> <fmt:message
										key="navigation.cart" /> (<span class="shopping-cart">${shoppingCart.quantity}</span>)
							</a></li>
							<sec:authorize access="!isAuthenticated()">
								<li><a href="${s:mvcUrl('LC#loginPage').build() }"><i
										class="fa fa-lock"></i> <fmt:message key="navigation.login" />
								</a></li>
							</sec:authorize>
							<sec:authorize access="isAuthenticated()">
								<sec:authentication property="principal" var="user" />
								<li><a href="#"><i class="fa fa-user"></i> <fmt:message
											key="navigation.account" /> </a></li>
								<li><a href="<c:url value="/logout" />"><i
										class="fa fa-lock"></i> <fmt:message key="navigation.logout" />
								</a></li>
							</sec:authorize>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/header-middle-->

	<div class="header-bottom">
		<!--header-bottom-->
		<div class="container">
			<div class="row">
				<div class="col-sm-9">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<div class="mainmenu pull-left">
						<ul class="nav navbar-nav collapse navbar-collapse">
							<c:forEach items="${productFilter.personList()}" var="person">
								<li class="dropdown"><a href="#">${person.personType} <i
										class="fa fa-angle-down"></i>
								</a>
									<ul role="menu" class="sub-menu">
										<c:forEach items="${productFilter.categories()}"
											var="category">
											<li><a href="${s:mvcUrl("PLC#personAndCategoryList").arg(0, person.id).arg(1, category.id)
                                                         .arg(2, person.personType.toString()).build()}">${category.categoryType.toString()}
											</a></li>
										</c:forEach>
									</ul></li>
							</c:forEach>
							<li><a href="contact-us.html">Ofertas</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="search_box pull-right">
						<input type="text" placeholder="<fmt:message key="label.search"/>" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/header-bottom-->
</header>
<!--/header-->