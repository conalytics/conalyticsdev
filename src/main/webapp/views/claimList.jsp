<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<center>
	<table id="conTable" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>CLAIM ID</th>
				<th>DATE</th>
				<th>VIN</th>
				<th>AUTO ID</th>
				<th>COLOR</th>
				<th>REPAIR LOCATION</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="claim" items="${claimList}">
				<tr>
					<td><a href="workOnClaim?id=${claim.claimId}&catId=">${claim.claimId}</a></td>
					<td>${claim.date}</td>
					<td>${claim.VIN }</td>
					<td>${claim.modelId }</td>
					<td>${claim.color }</td>
					<td>${claim.location }</td>
					<td><a href="editClaim?id=${claim.claimId}">Edit</a></td>
					<td><a href="deleteClaim?id=${claim.claimId}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</center>
<script>
	function updateMenuSelection() {
		$('#menu').multilevelpushmenu('expand', 'Claims');
		$('#currentAction').text('Claim List');
	}
</script>