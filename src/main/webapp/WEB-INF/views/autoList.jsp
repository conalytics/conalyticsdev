<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<center>
		<table  id="conTable"  class="display" cellspacing="0" width="100%">
		 <thead>
			<tr>
				<th >AUTO_ID </th>
				<th >COMPANY_ID </th>
				<th >AUTO_NAME  </th>
				<th >AUTO_DESC  </th>
				<th >MODEL  </th>
				<th >VERSION  </th>
				<th >YEAR_BUILT </th>
				<th >Edit</th>
				<th >Delete</th>
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
</center>
<script>
function updateMenuSelection() {
	$( '#menu' ).multilevelpushmenu( 'expand' , 'Vehicles' );
	$('#currentAction').text('Vehicles List');
}
</script>		