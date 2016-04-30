<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate
	title="Roupas Masculinas e Femininas | Compre Cal�as, Camisetas e Mais - E-Shopper">
	<jsp:attribute name="extraScripts">
	 </jsp:attribute>
	<jsp:body>
	<spring:hasBindErrors name="product">
		<ul>
			<c:forEach var="error" items="${errors.allErrors}">
				<li>${error.code}-${error.field}</li>
			</c:forEach>
		</ul>
	</spring:hasBindErrors>

	<form:form action="${spring:mvcUrl('PC#save').build()}" method="post"
			commandName="product" enctype="multipart/form-data">
		<security:csrfInput />
		<fieldset>
			<legend>Novo produto</legend>
			<div class="form-group">
				<label for="name">T�tulo:</label>
				<form:input path="name" class="form-control"
						placeholder="Nome do produto" />
				<form:errors path="name" />
			</div>
			<div class="form-group">
				<label for="descricao">Descri��o:</label>
				<form:textarea path="description" rows="5" cols="20"
						class="form-control" />
				<form:errors path="description" />
			</div>
			<div class="form-group">
				<label for="numeroPaginas">Pre�o</label>
				<form:input path="price" class="form-control"
						placeholder="ex: 00.00" />
				<form:errors path="price" />
			</div>
			<div class="form-group">
				<label for="brand">Categoria:</label> 
				<form:select path="category" class="form-control">
					<option value="" label="Selecione uma marca"/>
					<form:options items="${productFilter.categories()}" itemLabel="categoryType" itemValue="id"/>
				</form:select>
				<form:errors path="category"/>
			</div>
			<div class="form-group">
				<label for="brand">Marca:</label> 
				<form:select path="brand" class="form-control">
					<form:option value="" label="Selecione uma marca"/>
					<form:options items="${productFilter.brands()}" itemLabel="brandType" itemValue="id"/>
				</form:select>
			</div>
			<div class="form-group">
				<label for="person">G�nero:</label> 
				<form:select path="person" class="form-control">
					<form:option value="" label="Selecione um g�nero"/>
					<form:options items="${productFilter.personList()}" itemLabel="personType" itemValue="id"/>
				</form:select>
			</div>
			<div class="page-header">
				<h1>
					Imagens do produto <small>Selecione as imagens no tamanho pequeno, m�dio e grande</small>
				</h1>
			</div>
			<div class="form-group">
				<label for="smallPhoto">Pequeno</label> 
				<input type="file" name="smallPhoto" />
				<form:errors path="smallPhotoPath" class="form-control" />
			</div>
			<div class="form-group">
				<label for="mediumPhoto">M�dio</label> 
				<input type="file" name="mediumPhoto" />
				<form:errors path="mediumPhotoPath" class="form-control" />
			</div>
			<div class="form-group">
				<label for="largePhoto">Grande</label> 
				<input type="file" name="largePhoto" />
				<form:errors path="largePhotoPath" class="form-control" />
			</div>
			<div>
				<input type="submit" class="btn btn-primary" value="Salvar produto">
			</div>
		</fieldset>
	</form:form>

</jsp:body>
</tags:pageTemplate>