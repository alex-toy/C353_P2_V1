<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
		  
	<style>
		.error {color:red}
	</style>
		  
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>C353 P2 - Ajout d'un bien</h2>
		</div>
	</div>

	
	<section class="wrapper style1">
		<form:form action="saveProperty" modelAttribute="property" method="POST">
		<form:hidden path="id" />
			Adresse  : <form:input path="propertyAddress" /><form:errors path="propertyAddress" cssClass="error" /><br><br>
			Code Postal : <form:input path="postalCode" /><form:errors path="postalCode" cssClass="error" /><br><br>
			Nature : <form:input path="nature" /><form:errors path="nature" cssClass="error" /><br><br>
			Surface : <form:input path="surface" /><form:errors path="surface" cssClass="error" /><br><br>
			Prix : <form:input path="price" /><form:errors path="price" cssClass="error" /><br><br>
			Options : <form:input path="propertyOptions" /><form:errors path="propertyOptions" cssClass="error" /><br><br>
			<input type="submit" value="Ajouter" />
		</form:form>
		<a href="http://localhost:8080/web-customer-tracker/property/listProperties">Retour a la liste des biens</a>		
	</section>
	

</body>

</html>










