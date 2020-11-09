<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
	String id = request.getParameter("userid");
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client</title>



<style>
.main {
	align-items: center;
}

.button {
	
	position: fixed;
    top:100px;
	left:500px;
    
	width: 200px;
	height: 50px;
	
	background-color: #1c89ff;
	border: solid 1px transparent;
	color: #fff;
	font-size: 18px;
	font-weight: 300;
	cursor: pointer;
;
	border-color: #fff;
	
}

}
.loader {
	display: flex;
	justify-content: center;
	align-items: center;
	width: 50px;
	height: 50px;
	background: transparent;
	margin: 30px auto 0 auto;
	border: solid 2px #424242;
	border-top: solid 2px #1c89ff;

	opacity: 0;
}

.check {
	width: 100%;
	height: 100%;
	display: flex;
	flex-direction: column;
	justify-content: center;

	opacity: 0;
	
	width: 10px;
	height: 2px;
	
}

span:nth-child(2) {
	display: block;
	width: 20px;
	height: 2px;
	background-color: #fff;
	
}

}
.loader.active {
	animation: loading 2s ease-in-out;
	animation-fill-mode: forwards;
}

.check.active {
	opacity: 1;
	
}

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




<body>



		<br> <br> <br> <font color="black">
			Approved by Admin</font> <br> <br> <br> <br>
<div class ="uma1">
		<table border="1">
			<tbody>
				<tr>
					<strong>
						<td>name</td>
						<td>activity name</td>
						<td>activity details</td>
						
<td>
					</strong>

				</tr>
				<%
					try {
						connection = DriverManager.getConnection(connectionUrl + database, userid, password);
						statement = connection.createStatement();
						String sql = "select * from admin";
						resultSet = statement.executeQuery(sql);
						int i=0;
						while (resultSet.next()) {
				%>
				<tr>
					<td><%=resultSet.getString("clientname")%></td>
					<td><%=resultSet.getString("Activity")%></td>
					<td><%=resultSet.getString("ActivityDescription")%></td>
				
</tr>
					

				</tr>

				<%
					if (!resultSet.getString("Activity").isEmpty()) {
								System.out.println("Actvity name :  " + resultSet.getString("Activity"));
							}
				%>

				<%
				i++;
						
					}
						connection.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				%>
			</tbody>
		</table>
		<%
			System.out.println("Chat");
		%>
		</div>
		
		<form method="post">
			

				<input type="submit" class="button" value="Connect to Server" />
				<div class="loader">
					<div class="check">
						<span class="check-one"></span> <span class="check-two"></span>
					</div>
				</div>

			</div>
		</form>
<script>
		

		function removeTopic() {
			var txt;
			var e = window.event, btn = e.target || e.srcElement;
			window.location = "http://localhost:8080/Delete?value=" + btn.id;
		}

		
	</script>
	
</body>
</html>