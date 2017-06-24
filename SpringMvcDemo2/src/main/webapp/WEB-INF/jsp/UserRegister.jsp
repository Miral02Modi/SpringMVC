<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<center>
		<h1>User register</h1>
	</center>
	<center>
		<form action="userRegister" method="post">
			<table>

				<tr>
					<td>Email</td>
					<td><input type="text" name="email" placeholder="Email"></td>
				</tr>

				<tr>
					<td>Password</td>
					<td><input type="password" name="password"
						placeholder="Password"></td>
				</tr>	
				<tr>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="Submit">
						<button type="Submit" formaction="login" name="Login">Login</button></td>
				</tr>
			</table>
		</form>
		
		<center>
</body>
</html>