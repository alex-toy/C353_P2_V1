<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Liste des personnes</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>C353 P2 - Liste des personnes</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Ajouter une personne"
				   onclick="window.location.href='addPersonForm'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Prénom</th>
					<th>Nom</th>
					<th>Nationalité</th>
					<th>Numéro étudiant</th>
					<th>Email</th>
					<th>Bien loué</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="person" items="${persons}">
				
					<c:url var="updateLink" value="/person/updatePerson">
						<c:param name="personId" value="${person.id}" />
					</c:url>					

					<c:url var="deleteLink" value="/person/deletePerson">
						<c:param name="personId" value="${person.id}" />
					</c:url>	
					
					<c:url var="detailLink" value="/person/detailPerson">
						<c:param name="personId" value="${person.id}" />
					</c:url>
					
					<c:url var="detailPropertyLink" value="/property/detailProperty">
						<c:param name="propertyId" value="${person.rented_property.id}" />
					</c:url>				
					
					<tr>
						<td><a href="${detailLink}">${person.firstName}</a></td>
						<td> ${person.lastName} </td>
						<td> ${person.country} </td>
						<td> ${person.studentCode} </td>
						<td> ${person.email} </td>
						<td><a href="${detailPropertyLink}">${person.rented_property.propertyAddress}</a></td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Etes-vous sûr de vouloir effacer cet étudiant?'))) return false">Delete
							</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
			
			<a href="http://localhost:8080/web-customer-tracker/home">Home</a><br>
			<a href="http://localhost:8080/web-customer-tracker/property/listProperties">Liste des biens</a>
			
				
		</div>
	
	</div>
	

</body>

</html>









