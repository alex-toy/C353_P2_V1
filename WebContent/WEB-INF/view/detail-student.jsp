<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>D�tail d'un �tudiant</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>C353 P2 - D�tail d'un �tudiant</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<table>
				<tr>
					<th>Pr�nom</th>
					<th>Nom</th>
					<th>Adresse</th>
					<th>Nationalit�</th>
					<th>Num�ro �tudiant</th>
					<th>email</th>
					<th>Bien lou�</th>
					<th>Action</th>
				</tr>
				
				<c:url var="stopLocationLink" value="/student/stopLocationStudent">
					<c:param name="studentId" value="${student.id}" />
					<c:param name="propertyId" value="${student.property.id}" />
				</c:url>
				
				<tr>
					<td> ${student.firstName} </td>
					<td> ${student.lastName} </td>
					<td> ${student.address} </td>
					<td> ${student.country} </td>
					<td> ${student.studentCode} </td>
					<td> ${student.email} </td>
					<td> ${student.property.propertyAddress} </td>
					<td><a href="${stopLocationLink}">Retirer location</a></td>
				</tr>
						
			</table>
			
			
			
			<c:forEach var="property" items="${properties}">
				
				<c:url var="addStudentToRentLink" value="/student/addStudentToRent">
					<c:param name="studentId" value="${student.id}" />
					<c:param name="propertyId" value="${property.id}" />
				</c:url>					
					
						
				<p><a href="${addStudentToRentLink}">${property.propertyAddress}</a></p>
					
			</c:forEach>
			
			
			
			<a href="http://localhost:8080/web-customer-tracker/home">Home</a>
				
		</div>
		
	</div>
	

</body>

</html>









