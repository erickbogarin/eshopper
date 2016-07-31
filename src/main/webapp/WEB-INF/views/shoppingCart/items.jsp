<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<c:url value="/resources" var="classPath" />
<c:url value="/" var="uploadedImages" />
<c:url value="/wro" var="wroPath" />

<tags:pageTemplate title="Carrinho | E-Shopper">
	<jsp:attribute name="extraScripts">
		<script src="${wroPath}/itemsScripts.js"></script>
	</jsp:attribute>

    <jsp:body>

        <main>
       		
       		<input id="urlPath" type="hidden" value="${uploadedImages }"/> 
       		 
        	<c:if test="${not empty falha}" >
                <div class="alert alert-danger alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <strong>Pagamento não efetuado! </strong>${falha}
                </div>
            </c:if>
            
            <section id="cart_items">
                <div class="container">
                    <div class="breadcrumbs">
                        <ol class="breadcrumb">
                            <li>
                            	<a href="${spring:mvcUrl('HC#index').build()}">
                            		<fmt:message key="breadcrumb.home"/>
                            	</a>
                            </li>
                            <li class="active"><fmt:message key="breadcrumb.shoppingCart"/></li>
                        </ol>
                    </div>
                    <div class="table-responsive cart_info">
                        <table class="table table-condensed">
                            <thead>
                                <tr class="cart_menu">
                                    <td class="image"><fmt:message key="table.cart.item"/></td>
                                    <td class="description"></td>
                                    <td class="price"><fmt:message key="table.cart.price"/></td>
                                    <td class="quantity"><fmt:message key="table.cart.quantity"/></td>
                                    <td class="total"><fmt:message key="table.cart.total"/></td>
                                    <td></td>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${shoppingCart.list}" var="item">
                                    <tr class="cart_body">
                                        <input class="item_id" type="hidden" value="${item.product.id}"/>
                                        <td class="cart_product">
                                            <a href="">
                                                <img src="${uploadedImages}${item.product.smallPhotoPath}" alt="" width="50px" height="50px"/>
                                            </a>
                                        </td>
                                        <td class="cart_description">
                                            <h4>
                                                <a href="${spring:mvcUrl('PLC#show').arg(0,item.product.nameId).build()}">${item.product.name}</a>
                                            </h4>
                                        </td>
                                        <td class="cart_price">
                                            <p>R$ ${item.product.price}</p>
                                        </td>
                                        <td class="cart_quantity">
                                            <div class="cart_quantity_button">
                                                <a class="cart_quantity_up" href=""> + </a>
                                                <input class="cart_quantity_input" type=text name="quantity"
                                                            value="${shoppingCart.getQuantity(item)}">
                                                <a class="cart_quantity_down" href=""> - </a>
                                            </div>
                                            <img class="loading" src="${classPath }/images/base/loading.gif" alt="Carregando"/>
                                        </td>
                                        <td class="cart_total">
                                            <p class="cart_total_price">R$ <span class="cart_total_price_value">${shoppingCart.getTotal(item)}</span></p>
                                        </td>
                                        <td class="cart_delete">
                                        	 <a class="cart_quantity_delete" href="${spring:mvcUrl('SCC#remove').arg(0, item.product.id).build()}">
                                                   <i class="fa fa-times"></i>
                                              </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
	                    <c:if test="${shoppingCart.isEmpty()}">
	                    	<div class="cart_empty">
	                            <h3>Carrinho vazio.</h3>
	                            <a class="btn btn-default get" href="${spring:mvcUrl('HC#index').build() }">
		                            	<i class="fa fa-shopping-basket"></i> Continue comprando
		                        </a>
		                     </div>
	                    </c:if>
                    </div>
                </div>
            </section>
			<c:if test="${!shoppingCart.isEmpty()}">
            <section id="do_action">
                <div class="container">
                    <div class="heading">
                        <h3><fmt:message key="checkout.title"/></h3>
                        <p></p>
                    </div>
                </div>
                <div class="row">
                	<div class="col-sm-6">
						<div class="chose_area">
							<ul class="user_info">
								<li class="single_field zip-field">
									<label><fmt:message key="checkout.label.zipcode"/></label>
									<input class="cep-input" type="text" required="required" value="${correiosDto.getCep() }"
										placeholder="<fmt:message key="checkout.field.optional"/>">
								</li>
							</ul>
							<a class="btn btn-default check_out cep-calculation" href="" rel="nofollow">
								<fmt:message key="checkout.button.freight"/>
							</a>
							<img class="loading" src="${classPath }/images/base/loading.gif" alt="Carregando"/>
							<p class="deadline">${correiosDto.getDeadline()}</p>
							<p class="msgError">${correiosDto.getMsgError()}</p>
						</div>
					</div>
                    <div class="col-sm-6">
                        <div class="total_area">
                            <ul>
                                <li>Subtotal <span class="price-subtotal">${shoppingCart.getSubTotal()}</span></li>
                                	
                                	<li><fmt:message key="checkout.freight"/> <span class="price-freight">${correiosDto.getFreight()}</span></li>
                                	
                                <li>Total <span class="price-total">${shoppingCart.getTotal()}</span></li>
                            </ul>
                            <form:form action="${spring:mvcUrl('PC#checkout').build()}" method="post">
                                <button id="checkout" name="checkout" type="submit" class="btn btn-default check_out">
                                    <i class="fa fa-check-square-o"></i> <fmt:message key="checkout.button.finalize"/>
                                </button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </section>
            </c:if>
        </main>
    </jsp:body>
</tags:pageTemplate>