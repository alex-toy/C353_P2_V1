<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Détail d'une personne</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>C353 P2 - Détail d'une personne</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<table>
				<tr>
					<th>Prénom</th>
					<th>Nom</th>
					<th>Adresse</th>
					<th>Nationalité</th>
					<th>Numéro étudiant</th>
					<th>email</th>
					<th>Bien loué</th>
					<th>Action</th>
				</tr>
				
				<c:url var="stopLocationLink" value="/person/stopRent">
					<c:param name="renterId" value="${person.id}" />
					<c:param name="propertyId" value="${person.rented_property.id}" />
				</c:url>
				
				<c:url var="detailPropertyLink" value="/property/detailProperty">
					<c:param name="propertyId" value="${person.rented_property.id}" />
				</c:url>
				
				<tr>
					<td> ${person.firstName} </td>
					<td> ${person.lastName} </td>
					<td> ${person.address} </td>
					<td> ${person.country} </td>
					<td> ${person.studentCode} </td>
					<td> ${person.email} </td>
					<td><a href="${detailPropertyLink}">${person.rented_property.propertyAddress}</a></td>
					<td><a href="${stopLocationLink}">Retirer location</a></td>
				</tr>
						
			</table>
			
	<div id="wrapper">
		<div id="header">
			<h2>Assigner une location à ${person.firstName} ${person.lastName}</h2>
		</div>
	</div>
			
			<c:forEach var="property" items="${properties}">
				
				<c:url var="addPersonToRentLink" value="/person/addPersonToRent">
					<c:param name="renterId" value="${person.id}" />
					<c:param name="propertyId" value="${property.id}" />
				</c:url>					
					
						
				<p><a href="${addPersonToRentLink}">${property.propertyAddress}</a></p>
					
			</c:forEach>
			
			<a href="http://localhost:8080/web-customer-tracker/home">Home</a><br>
			<a href="http://localhost:8080/web-customer-tracker/property/listProperties">Liste des biens</a>
				
		</div>
		
	</div>
	

</body>

</html>









