<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Address</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit Person</h1>
        <form:form action="saveAddress" method="post" modelAttribute="address">
        
        <table>
            <form:hidden path="id"/>
            <form:hidden path="person.id" />
            <form:hidden path="person.firstName" />
            <form:hidden path="person.lastName" />
            <tr>

					<td>First Name:</td> <td>${person.firstName}</td>
					<td>Last Name:</td> <td>${person.lastName}</td>
            </tr>
            <tr>
                <td>Street:</td>
                <td><form:input path="street" /><font color="red"> <form:errors path="street"></form:errors></font><br/></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><form:input path="city" /><font color="red"> <form:errors path="city"></form:errors></font><br/></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><form:input path="state" /><font color="red"> <form:errors path="state"></form:errors></font><br/></td>
            </tr>
            <tr>
                <td>Postal Code:</td>
                <td><form:input path="postalcode" /><font color="red"> <form:errors path="postalcode"></form:errors></font><br/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>