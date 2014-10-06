<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Being Java Guys | Spring DI Hello World</title>
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
	text-align: center;
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
		<br /> <br /> <br /> <b>Edit Auto Details </b><br /> <br />
		<div>
			<form:form method="post" action="updateAuto" modelAttribute="auto">
				<table>

					
					<tr>
						<td>COMPANY_ID</td>
						<TD><form:input path="companyId"
								value="${map.auto.companyId}" /></td>

					</tr>
					<tr>
						<td>AUTO_NAME</td>
						<TD><form:input path="autoName" value="${map.auto.autoName}" /></td>

					</tr>
					<tr>
						<td>AUTO_DESC</td>
						<TD><form:input path="autoDesc" value="${map.auto.autoDesc}" /></td>

					</tr>
					<tr>
						<td>MODEL</td>
						<TD><form:input path="model" value="${map.auto.model}" /></td>

					</tr>
					<tr>
						<td>VERSION</td>
						<TD><form:input path="version" value="${map.auto.version}" /></td>

					</tr>
					<tr>
						<td>YEAR_BUILT</td>
						<TD><form:input path="yearBuilt"
								value="${map.auto.yearBuilt}" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="Update" /></td>
					</tr>
				</table>
				<form:hidden path="autoId" value="${map.auto.autoId}" />

			</form:form>
		</div>
	</center>
</body>
</html>