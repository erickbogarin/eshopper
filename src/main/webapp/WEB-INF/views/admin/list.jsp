<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	${sucesso}
	
	<table>
		<tr>
			<td>Titulo</td>
			<td>Sumario</td>
		</tr>
		<c:forEach items="${products}" var="product">
			<tr>
				<td>
					<a href="${spring:mvcUrl('PLC#show').arg(0,product.nameId).build()}">
						${product.name}
					</a>	
				</td>
				<td>
						<img alt="Sumario" src="${product.smallPhotoPath}" style="width:20x;height:20px">
				</td>
				
			</tr>
			
		</c:forEach>
	</table>

</body>
</html>