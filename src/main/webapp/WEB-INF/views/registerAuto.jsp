<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
body {
	font-size: 20px;
	color: teal;
	font-family: Calibri;
}

td {
	font-size: 15px;
	color: black;
	width: 100px;
	height: 22px;
	text-align: left;
}

.heading {
	font-size: 18px;
	color: white;
	font: bold;
	background-color: orange;
	border: thick;
}
</style>
</head>
<body>
	<center>
		<br /> <br /> <br /> <b>Being Java Guys | Registration Form </b> <br />
		<br />
		<div>
			<form:form method="post" action="/insertAuto" modelAttribute="auto">
				<table>
					<tr>
						<td>AUTO_ID</td>
						<TD><form:input path="autoId" /></td>
					</tr>
					<tr>
						<td>COMPANY_ID</td>
						<TD><form:input path="companyId" /></td>

					</tr>
					<tr>
						<td>AUTO_NAME</td>
						<TD><form:input path="autoName" /></td>

					</tr>
					<tr>
						<td>AUTO_DESC</td>
						<TD><form:input path="autoDesc" /></td>

					</tr>
					<tr>
						<td>MODEL</td>
						<TD><form:input path="model" /></td>

					</tr>
					<tr>
						<td>VERSION</td>
						<TD><form:input path="version" /></td>

					</tr>
					<tr>
						<td>YEAR_BUILT</td>
						<TD><form:input path="yearBuilt" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="Save" /></td>
					</tr>
					<tr>

						<td colspan="2"><a href="getAutoList">Click Here to See Auto
								List</a></td>
					</tr>
				</table>
			</form:form>
		</div>
	</center>
