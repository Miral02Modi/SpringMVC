<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update">
		<table>
			<tr>
				<td><input value=${student.id } type="hidden" name="id" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<%-- path="text" --%>
				<td><input value=${student.name } type="text" name="name"
					placeholder="Name" /></td>
			</tr>

			<tr>
				<td>Mobile Number</td>
				<td><input value=${student.mobileNumber } type="text"
					name="mobileNumber" placeholder="Mobile"></td>
			</tr>

			<tr>
				<td>Father Name</td>
				<td><input value=${student.fatherName } type="text"
					name="fatherName" placeholder="Father Name"></td>
			</tr>

			<tr>
				<td>Email</td>
				<td><input value=${student.email } type="text" name="email"
					placeholder="Email"></td>
			</tr>


			<tr>
				<td>Date of Birth</td>
				<td><input value=${student.dateOfBirth } type="text"
					name="dateOfBirth"></td>
			</tr>

			<tr>
				<td>Gender</td>
				<c:set var="gender" scope="session" value="${student.gender}"/>  
				<c:if test="${gender == 'male'}">
					<td><input type="radio" name="gender" value="male" checked>
						Male <input type="radio" name="gender" value="female">
						Female <input type="radio" name="gender" value="other">
						Other</td>
				</c:if>
				<c:if test="${gender == 'female'}">
					<td><input type="radio" name="gender" value="male" >
						Male <input type="radio" name="gender" value="female" checked>
						Female <input type="radio" name="gender" value="other">
						Other</td>
				</c:if>
			</tr>

			<tr>
				<td>Street</td>
				<td><input value=${student.address.street } type="text"
					name="address.street" placeholder="Street"></td>
			</tr>

			<tr>
				<td>City</td>
				<td><input value=${student.address.city } type="text"
					name="address.city" placeholder="City"></td>
			</tr>

			<tr>
				<td>State</td>
				<td><input value=${student.address.state } type="text"
					name="address.state" placeholder="State"></td>
			</tr>

			<tr>

				<td>Pincode</td>
				<td><input type="text" value=${student.address.pincode
					} name="address.pincode" placeholder="Pincode"></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" name="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>