<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate
	title="Roupas Masculinas e Femininas | Compre Calças, Camisetas e Mais - E-Shopper">
	<jsp:attribute name="extraScripts">
	 </jsp:attribute>
	
	<jsp:body>
		<section id="form">
			<c:if test="${not empty sucesso}" >
                <div class="alert alert-success alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    ${sucesso}
                </div>
            </c:if>
			
			<!--form-->
			<div class="col-sm-4 col-sm-offset-1">
				<div class="login-form">
					<!--login form-->
					<h2>
						<fmt:message key="login.title" />
					</h2>
					 <c:if test="${'fail' eq param.auth}">
						<div class="alert alert-danger alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert" aria-label="Close">
								<span aria-hidden="true">&times;
								</span>
							</button>
							Usuário ou senha incorreta.
						</div>	
					</c:if> 
					<form:form servletRelativeAction="/login">
						<div>
							<input type="email" name='username' required
									placeholder="<fmt:message key="login.user" />" value=''>
						</div>
						<div>
							<input type='password' name='password' required
									placeholder="<fmt:message key="login.password" />" />
						</div>
						<div>
							<button type="submit" class="btn btn-default">
								<fmt:message key="login.submit" />
							</button>
						</div>
					</form:form>
				</div>
			</div>
			<div class="col-sm-1">
				<h2 class="or">
					<fmt:message key="login.or" />
				</h2>
			</div>
			<div class="col-sm-4">
				<div class="signup-form">
					<!--sign up form-->
					<h2>
						<fmt:message key="login.signUp" />
					</h2>
					
					
					<form:form action="${spring:mvcUrl('UC#register').build()}" method="post"
							commandName="user">
						<security:csrfInput />
						
						<form:errors path="name" cssClass="alert-danger"/>
						<spring:bind path="name">
							<input type="text" name="name" class="form-control" required
								placeholder="<fmt:message key="login.placeholder.name" />" />
						</spring:bind>	
						
						<form:errors path="login" cssClass="alert-danger"/>
						<spring:bind path="login">
							<input type="email" name="login" class="form-control" required
								placeholder="<fmt:message key="login.placeholder.email" />" />
						</spring:bind>	
						
						<form:errors path="password" cssClass="alert-danger"/>
						<spring:bind path="password">						
							<input type="password" name="password" class="form-control" required
								placeholder="<fmt:message key="login.placeholder.password" />" />
						</spring:bind>	
						
						<button type="submit" class="btn btn-default">
							<fmt:message key="login.button.newAccount" />
						</button>
					</form:form>
				</div>
				<!--/sign up form-->
			</div>
		</section>
	</jsp:body>
</tags:pageTemplate>