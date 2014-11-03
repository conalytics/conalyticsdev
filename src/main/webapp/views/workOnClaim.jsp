<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<center>
	<table id="conTable" class="display" cellspacing="0" width="100%">

		<tbody>

				<tr>
					<td>CLAIM ID:${map.claim.claimId}</td>
					<td>DATE:${map.claim.date}</td>
					<td>VIN:${map.claim.VIN }</td>
					<td>AUTO ID:${map.claim.modelId }</td>
					<td>COLOR:${map.claim.color }</td>
					<td>REPAIR LOCATION:${map.claim.shopId }</td>
				</tr>
		</tbody>
	</table>
		<table id="repairTable" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Repair Desc</th>
				<th>Parts Id</th>
				<th>Parts Desc</th>
				<th>Quantity</th>
				<th>Edit</th>
				<th>Delete</th>
				<th>Source parts</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="repair" items="${repairList}">
				<tr>
					<td>${repair.repairDesc}</td>
					<td>${repair.partId}</td>
					<td>${repair.partDesc }</td>
					<td>${repair.quantity }</td>
					<td><a href="editRepair?id=${repair.repairId}">Edit</a></td>
					<td><a href="deleteRepair?id=${repair.repairId}">Delete</a></td>
					<td><a href="sourceparts?id=${repair.repairId}">Source Parts</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</center>
<script>
	function updateMenuSelection() {
		$('#menu').multilevelpushmenu('expand', 'Claim');
		$('#currentAction').text('Claim List');
	}
</script>