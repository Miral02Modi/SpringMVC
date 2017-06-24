
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
a {
	text-decoration: none;
}

a:HOVER {
	text-decoration: underline;
}
</style>

<script type="text/javascript">

	var getData1 = function(phone) {
		
		var data = {};
		data.mobile = name;
		alert(name);
		
		$.ajax({
			url : 'http://localhost:8080/SpringMvcDemo2/',
			data : data,
			type : 'post',
			success : function(data) {
				alert("Success..")
			},
			error : function() {
				alert(error)
			}
		});
		
		
		return false;
	}

</script>
</head>
<body>

	


	<table border="1" style="padding: 1px 1px 1px 1px;">
		<tr>
			<th>Name</th>
			<th>MobileNumber</th>
			<th>Date of Birth</th>
			<th>Gender</th>
			<th>Email</th>
			<th>City</th>
			<th>Street</th>
			<th>State</th>
			<th>Pincode</th>
		</tr>
		<c:forEach var="student" items="${retrivedata}">

			<tr>
				<td><c:out value="${student.name}" /></td>
				<td><a href="http://www.google.com" id="mobile"
					onclick="return getData1(${student.mobileNumber})">
						${student.mobileNumber} </a></td>
				<td><c:out value="${student.dateOfBirth}" /></td>
				<td><c:out value="${student.gender}" /></td>
				<td><c:out value="${student.email}" /></td>
				<td><c:out value="${student.address.city}" /></td>
				<td><c:out value="${student.address.street}" /></td>
				<td><c:out value="${student.address.state}" /></td>
				<td><c:out value="${student.address.pincode}" /></td>
				<td><a href="edit?id=${student.id}">Edit</a></td>
				<td><a href="delete?id=${student.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="stdRegistration">Add Student</a>
	<%-- <c:out value="${student}"/><p> --%>

</body>
</html>