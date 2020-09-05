<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
	<title>Détail d'un bien</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>C353 P2 - Détail d'un bien</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<table>
				<tr>
					<th>Adresse</th>
					<th>Code postal</th>
					<th>Nature</th>
					<th>Surface</th>
					<th>prix</th>
					<th>Options</th>
					<th>Propriétaire</th>
					<th>Action</th>
				</tr>
				
				<c:url var="updateLink" value="/property/updatePropertyForm">
					<c:param name="propertyId" value="${property.id}" />
				</c:url>
				
				<c:url var="detailOwnerLink" value="/person/detailPerson">
						<c:param name="personId" value="${property.owner.id}" />
					</c:url>
				
				<tr>
					<td> ${property.propertyAddress} </td>
					<td> ${property.postalCode} </td>
					<td> ${property.nature} </td>
					<td> ${property.surface} </td>
					<td> ${property.price} </td>
					<td> ${property.propertyOptions} </td>
					
					
					
					<td><a href="${detailOwnerLink}">${property.owner.firstName} ${property.owner.lastName}</a></td>
					
					
					<td><a href="${updateLink}">Update</a></td>
				</tr>
						
			</table>
			
			
				
		</div>
		
		
		<div id="content">Liste des étudiants louant ce bien : </div>
		
		
		<div id="content">
			
			<table>
				<tr>
					<th>Prénom</th>
					<th>Nom</th>
					<th>Adresse</th>
					<th>Nationalité</th>
					<th>Numéro étudiant</th>
					<th>email</th>
					<th>Action</th>
				</tr>
		
			<c:forEach var="renter" items="${property.renters}">
				
					<c:url var="stopRentLink" value="/person/stopRent">
						<c:param name="renterId" value="${renter.id}" />
						<c:param name="propertyId" value="${property.id}" />
					</c:url>
					
					<c:url var="detailLink" value="/person/detailPerson">
						<c:param name="renterId" value="${renter.id}" />
					</c:url>					
					
					<tr>
						<td><a href="${detailLink}">${renter.firstName}</a></td>
						<td> ${renter.lastName} </td>
						<td> ${renter.address} </td>
						<td> ${renter.country} </td>
						<td> ${renter.studentCode} </td>
						<td> ${renter.email} </td>
						
						<td>
							<a href="${stopRentLink}"
							   onclick="if (!(confirm('Etes-vous sûr de vouloir stopper cette location ?'))) return false">Retirer de la location</a>
						</td>
						
					</tr>
				
				</c:forEach>
			</table>
				
		</div>
		
		
		<div id="content">Rajouter un locataire louant ce bien : </div>
		
		
		<div id="content">
			
			<select>
			    
			    <c:forEach var="renter" items="${renters}">
				
					<c:url var="addRenterLink" value="/property/addRenter">
						<c:param name="renterId" value="${renter.id}" />
						<c:param name="propertyId" value="${property.id}" />
					</c:url>
					
					<option>${renter.firstName} ${renter.lastName}</option>					
						
				</c:forEach>
			    
			</select>
			
		</div>
		
		
		<c:forEach var="renter" items="${renters}">
				
			<c:url var="addRenterLink" value="/property/addRenter">
				<c:param name="renterId" value="${renter.id}" />
				<c:param name="propertyId" value="${property.id}" />
			</c:url>					
				
					
			<p><a href="${addRenterLink}">${renter.firstName} ${renter.lastName}</a></p>
				
		</c:forEach>
		
		
		<a href="http://localhost:8080/web-customer-tracker/home">Home</a><br>
		<a href="http://localhost:8080/web-customer-tracker/person/listPersons">Liste des personnes</a>
		
	
	</div>
	

</body>

</html>









