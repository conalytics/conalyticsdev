<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<center>
	<table id="conTable" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>AUTO ID</th>
				<th>COMPANY NAME</th>
				<th>AUTO NAME</th>
				<th>AUTO DESC</th>
				<th>MODEL</th>
				<th>VERSION</th>
				<th>YEAR BUILT</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="auto" items="${autoList}">
				<tr>
					<td>${auto.autoId}</td>
					<td>${auto.companyName}</td>
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
		$('#menu').multilevelpushmenu('expand', 'Vehicles');
		$('#currentAction').text('Vehicles List');
	}
</script>