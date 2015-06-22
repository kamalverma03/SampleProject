<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<form:errors path="user.*" />
	<form method="post" action="${pageContext.request.contextPath}/pages/secured/profile">
		<center>
			<table border="1" width="60%" cellpadding="5">
				<thead>
					<tr>
						<th colspan="2">Registration</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>User ID</td>
						<td><input type="text" name="userId"  /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="text" name="password"  /></td>
					</tr>
					<tr>
						<td>First Name</td>
						<td><input type="text" name="firstName" /></td>

					</tr>
					<tr>
						<td>Last Name</td>
						<td><input type="text" name="lastName" /></td>
					</tr>
					<tr>
					    <td>Role</td>
						<td><input type="radio" name="role"
							id="optionsRadios1" value="Buyer" checked>Buyer 
							<input type="radio" name="role" id="optionsRadios2"
							value="Merchant">Merchant</td>

					</tr>
					
					<tr>
						<td><input type="submit" value="Submit" /></td>
						<td><input type="reset" value="Reset" /></td>
					</tr>
					<tr>
						<td colspan="2">Already registered!! <a href="login.html">Login
								Here</a></td>
					</tr>
				</tbody>
			</table>
		</center>
		<input type="hidden"
					name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>

</body>
</html>