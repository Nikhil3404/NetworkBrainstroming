<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
	String id = request.getParameter("id");
	String driver = "com.mysql.cj.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/";
	String database = "pp7";
	String userid = "root";
	String password = "12345678";
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client</title>




<style>
body {
	margin: 0;
	font-family: Roboto, -apple-system, 'Helvetica Neue', ' Segoe UI ',
		Arial, sans-serif;
	background: #e7e7e7;
}

table, th, td {
	border: 1px solid black;
}

th, td {
	background-color: #4CAF50;
	color: white;
	padding: 5px;
	text-align: left;
}

div.Uma1 {
	position: fixed;
	left: 550px;
	top: 30px;
}

div.Uma2 {
	position: fixed;
	left: 500px;
	top: 10px;
}

div.Uma5 {
	position: fixed;
	left: 550px;
	top: 90px;
}

.container {
	overflow: hidden
}

.tab {
	float: left;
}

.tab-2 {
	margin-right: 50px
}

.tab-2 input {
	display: block;
	margin-left: 10px
}

div.to {
	position: fixed;
	left: 10px;
	bottom: 30%;
}

tr {
	transition: all .25s ease-in-out
}

tr:hover {
	background-color: white;
	cursor: pointer
}

.button {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
}

.button1 {
	background-color: green;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	cursor: pointer;
}
</style>

</head>




<meta charset="ISO-8859-1">
<title>BrainStroming</title>
</head>

<body>



<a class="uma2" id="logout"
			href="http://localhost:8080/login">Log Out</a>

</div>
	<center>Client Table</center>
	<br>
	<br>
	<center>
		<table>
			<tbody>
				<tr>
					<th>Client Name</th>
					<th>Activity Name</th>
					<th>Activity Details</th>
				</tr>
				<tr>
					<form method=post>
			
						<td><input type="text" name="client"></td>
						<td><input type="text" name="activity"></td>
						<td><input type="text" name="details"></td>
						
						<td><input type="submit" name="Save" value="Save"></td>
					</form>
				</tr>
			</tbody>
		</table>
	</center>

	<br>
	<br>



</body>
</html>