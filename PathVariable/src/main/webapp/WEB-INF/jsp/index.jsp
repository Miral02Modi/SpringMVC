<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%-- <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>


	<%-- <form:errors path="student1"/> --%> 
	
	 <form action="add" method="post" commandName="student" > 
		<table>

			<tr>
				<td>Name</td>
				<%-- path="text" --%>
				<td><input type="text"  name="name" placeholder="Name"/></td>
				${name}
			</tr>

			<tr>
				<td>Mobile Number</td>
				<td><input type="text" name="mobileNumber" placeholder="Mobile"></td>
				${Mobile}
			</tr>

			<tr>
				<td>Father Name</td>
				<td><input type="text" name="fatherName"
					placeholder="Father Name"></td>
			</tr>

			<tr>
				<td>Email</td>
				<td><input type="text" name="email" placeholder="Email"></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><input type="date" name="dateOfBirth"></td>
			</tr>

			<tr>
				<td>Gender</td>
				<td><input type="radio" name="gender" value="male" checked>
					Male <input type="radio" name="gender" value="female">
					Female <input type="radio" name="gender" value="other">
					Other</td>
			</tr>

			<tr>
				<td>Street</td>
				<td><input type="text" name="address.street"
					placeholder="Street"></td>
			</tr>

			<tr>
				<td>City</td>
				<td><input type="text" name="address.city" placeholder="City"></td>
			</tr>

			<tr>
				<td>State</td>
				<td><input type="text" name="address.state" placeholder="State"></td>
			</tr>

			<tr>

				<td>Pincode</td>
				<td><input type="text" name="address.pincode"
					placeholder="Pincode"></td>
			</tr>
			<!-- <tr>
				<td>Skils</td>
				<td><select name="skill" multiple>
						<option value="Java">Java</option>
						<option value="Angular">Angular</option>
						<option value="C#">C#</option>
						<option value="MEAN">MEAN</option>
				</select></td>
			</tr> -->

			<tr>
				<td></td>
				<td><input type="submit"></td>
			</tr>


		</table>
	</form>

</body>
</html>
