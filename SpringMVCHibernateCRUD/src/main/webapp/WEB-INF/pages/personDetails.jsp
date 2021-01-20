<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
    <div align="center">
        <h1>Person details & Address</h1>
        <form:form action="savePerson" method="post" modelAttribute="person">
        <table border="1">
            <form:hidden path="id"/>
            <tr>
                <td>First Name:</td>
                <td>${person.firstName}</td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td>${person.lastName}</td>
            </tr>
        </table>
         <h4>
			Add Address <a href="addAddress?id=${person.id}">here</a>
		 </h4>
		 <h4>Address List</h4>
		<table border="1">
			<th>Street</th>
			<th>City</th>
			<th>State</th>
			<th>Postal Code</th>
			<th>Action</th>
			<c:if test="${empty listAddress}">
				<tr><td colspan="5" align="center"><font color="red">No Data</font></td></tr>
			</c:if>
			<c:forEach var="address" items="${listAddress}">
				<tr>
					<td>${address.street}</td>
					<td>${address.city}</td>
					<td>${address.state}</td>
					<td>${address.postalcode}</td>
					<td><a href="editAddress?id=${address.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteAddress?id=${address.id}">Delete</a> 
					</td>
				</tr>
			</c:forEach>
		</table>		 
        </form:form>
    </div>
</body>
</html>