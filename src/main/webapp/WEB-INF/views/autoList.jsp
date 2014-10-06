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
	<center><b>Auto List </b><br />
		<table border="1">
			<tr>
				<td class="heading">AUTO_ID </td>
				<td class="heading">COMPANY_ID </td>
				<td class="heading">AUTO_NAME  </td>
				<td class="heading">AUTO_DESC  </td>
				<td class="heading">MODEL  </td>
				<td class="heading">VERSION  </td>
				<td class="heading">YEAR_BUILT </td>
				<td class="heading">Edit</td>
				<td class="heading">Delete</td>
			</tr>
			<c:forEach var="auto" items="${autoList}">
				<tr>
					<td>${auto.autoId}</td>
					<td>${auto.companyId}</td>
					<td>${auto.autoName }</td>
					<td>${auto.autoDesc }</td>
					<td>${auto.model }</td>
					<td>${auto.version }</td>
					<td>${auto.yearBuilt}</td>
					<td><a href="editAuto?id=${auto.autoId}">Edit</a></td>
					<td><a href="deleteAuto?id=${auto.autoId}">Delete</a></td>
				</tr>
			</c:forEach>
			<tr><td colspan="7"><a href="registerAuto">Add New Auto</a></td></tr>
		</table>