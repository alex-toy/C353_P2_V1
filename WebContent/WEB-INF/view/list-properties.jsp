<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Liste des biens</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>C353 P2 - Liste des biens</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Ajouter un bien"
				   onclick="window.location.href='addPropertyForm'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Numéro</th>
					<th>Adresse</th>
					<th>Code postal</th>
					<th>Nature</th>
					<th>Surface</th>
					<th>prix</th>
					<th>Options</th>
					<th>Propriétaire</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="property" items="${properties}" varStatus="loop">
				
					<c:url var="deleteLink" value="/property/deleteProperty">
						<c:param name="propertyId" value="${property.id}" />
					</c:url>
					
					<c:url var="detailLink" value="/property/detailProperty">
						<c:param name="propertyId" value="${property.id}" />
					</c:url>					
					
					<tr>
						<td> ${loop.count} </td>
						<td><a href="${detailLink}">${property.propertyAddress}</a></td>
						<td> ${property.postalCode} </td>
						<td> ${property.nature} </td>
						<td> ${property.surface} </td>
						<td> ${property.price} </td>
						<td> ${property.propertyOptions} </td>
						<td> ${property.owner.firstName} ${property.owner.lastName}</td>
						<td>
						
						<c:if test="${deletables[property.id] == false}">
								<c:out value="ne peut etre effacé"/>
						</c:if>
						
						<c:if test="${deletables[property.id] == true}">
								<a href="${deleteLink}" onclick="if (!(confirm('Etes-vous sûr de vouloir effacer ce bien?'))) return false">Delete</a>
						</c:if>
						
						
						</td>
						
						
					</tr>
				
				</c:forEach>
						
			</table>
			
			<a href="http://localhost:8080/web-customer-tracker/home">Home</a><br>
			<a href="http://localhost:8080/web-customer-tracker/person/listPersons">Liste des personnes</a>
				
		</div>
	
	</div>
	

</body>

</html>









