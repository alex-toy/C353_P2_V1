<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>C353 P2 - Liste des �tudiants</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Ajouter un �tudiant"
				   onclick="window.location.href='addStudentForm'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Pr�nom</th>
					<th>Nom</th>
					<th>Nationalit�</th>
					<th>Num�ro �tudiant</th>
					<th>Email</th>
					<th>Bien lou�</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempStudent" items="${students}">
				
					<c:url var="updateLink" value="/student/updateStudent">
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>					

					<c:url var="deleteLink" value="/student/deleteStudent">
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>	
					
					<c:url var="detailLink" value="/student/detailStudent">
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>					
					
					<tr>
						<td><a href="${detailLink}">${tempStudent.firstName}</a></td>
						<td> ${tempStudent.lastName} </td>
						<td> ${tempStudent.country} </td>
						<td> ${tempStudent.studentCode} </td>
						<td> ${tempStudent.email} </td>
						<td> ${tempStudent.property.propertyAddress} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Etes-vous s�r de vouloir effacer cet �tudiant?'))) return false">Delete
							</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
			
			<a href="http://localhost:8080/web-customer-tracker/home">Home</a>
				
		</div>
	
	</div>
	

</body>

</html>









