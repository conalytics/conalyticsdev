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
		<table  id="conTable"  class="display" cellspacing="0" width="100%">
		 <thead>
			<tr>
				<th >AUTO_ID </td>
				<th >COMPANY_ID </td>
				<th >AUTO_NAME  </td>
				<th >AUTO_DESC  </td>
				<th >MODEL  </td>
				<th >VERSION  </td>
				<th >YEAR_BUILT </td>
				<th >Edit</td>
				<th >Delete</td>
			</tr>
			</thead>
			<tbody>
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
			</tbody>
		</table>