<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Person Management Screen</title>
</head>
<body>
	<div align="center">
		<h2>List of Persons</h2>
		<table border="1">
			<th>First Name</th>
			<th>Last Name</th>
			<th>Action</th>
		<c:if test="${empty personList}">
		<tr><td colspan="3" align="center"><font color="red">No Data</font></td></tr>
		</c:if>
			<c:forEach var="person" items="${personList}">
				<tr>

					<td>${person.firstName}</td>
					<td>${person.lastName}</td>
					<td><a href="editPerson?id=${person.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deletePerson?id=${person.id}">Delete</a> 
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="viewPersonAddress?id=${person.id}">View Person Address</a></td>
				</tr>
			</c:forEach>
			<tr>
		</table>
		
		
		<h4>
			New Person Register <a href="newPerson">here</a>
		</h4>
	</div>
</body>
</html>