<%@ page import="java.sql.*"%>
<%
	ResultSet resultset = null;
%>



<HTML>
<HEAD>
<TITLE>Select element drop down box</TITLE>

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

div {
	align-content: center;
}

}
}
}
.uma5 {
	postion: fixed;
	top: 100px;
}
</style>
</HEAD>
<body>

	<div align="center">
		<form name="f1">
			<%
				String st = request.getParameter("s1");
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pp7?user=root&password=12345678");
				Statement stmt = con.createStatement();
				Statement stmt1 = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from client");
			%>

			<center>
				<h5 style="font-size: 28px; letter-spacing: 1px; color: #fff);">
					Network Brainstorming System</h5>
			</center>
			<h4>

				<font style="position: fixed; left: 10px; top: 230px;
  
);"
					color='black'>Select any Activity: -</font>
			</h4>


			<select name="s1" onChange="document.f1.submit()"
				style="overflow: hidden; width: 500px; height: 30px; position: fixed; left: 160px; top: 230px; border-radius: 9px 9px 9px 9px; box-shadow: 1px 1px 11px #330033);">

				<option>Topics</option>

				<%
					while (rs.next()) {
						String x = rs.getString("Activity");
				%>
				<option
					<%if (st != null && st.equals(x))
					out.println("selected");%>><%=x%></option>
				<%
					}
				%>
			</select> <br> <br>
			<%
				if (st != null) {
					ResultSet rs1 = stmt1.executeQuery(
							"select clientname, Activity, ActivityDescription from client where Activity='" + st + "'");
			%>




			<table border="1" width="20%" height="20%" top="50%">
				<tr>
					<th>Client Name</th>
					<th>Activity Name</th>
					<th>Activity Details</th>
				</tr>
				<%
					while (rs1.next()) {
						
							String ClientName = rs1.getString("clientname");
							String ActivityName = rs1.getString("Activity");
							String ActivityDetails = rs1.getString("ActivityDescription");
				%>

				</form>
				<div class="uma5">
					<form method=post>
						<tr>


							<td><input type="text" name="client" value=<%=ClientName%>></td>
							<td><input type="text" name="activity"
								value=<%=ActivityName%>></td>
							<td><input type="text" name="details"
								value=<%=ActivityDetails%>></td>
							<td><input type="submit" name="Save" value="Start"></td>
					</form>


					</tr>

				</div>
				<%
					} //end of while
				%>


			</table>
			<%
				} //end of if
			%>
			</select>
	</div>
</body>
</html>