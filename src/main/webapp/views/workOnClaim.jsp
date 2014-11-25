<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<center>
	<div id="firstDivistion" style="position: absolute !important;">
		<table id="conTable2" class="display" cellspacing="0" width="100%">
			<tbody>
				<tr>
					<td>CLAIM ID:${map.claim.claimId}</td>
					<td>DATE:${map.claim.date}</td>
					<td>VIN:${map.claim.VIN }</td>
					<td>AUTO ID:${map.claim.modelId }</td>
					<td>COLOR:${map.claim.color }</td>
					<td>Vehicle City:${map.claim.location }<input id="address"
						type="hidden" value=${map.claim.location }> <input
						id="shops" type="hidden" value='${jsongeocode}'>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div id="map-canvas" style="height: 400px; width: 80%; margin-top: 30px; position: absolute !important"></div>

	<div id="secondDivistion" style="position: absolute !important; margin-top: 500px;">
		Total Retail Cost:${rpc} Total Price Per Unit:${ppc}
		<table id="repairTable" class="display" cellspacing="0" width="100%">
			<thead>
				<tr>
				    <th>Repair number</th>
					<th>Repair Desc</th>
					<th>Parts Id</th>
					<th>Parts Desc</th>
					<th>Quantity Required</th>
					<th>Edit</th>
					<th>Delete</th>
					<th>Source parts</th>
					<th>Shop Name</th>
					<th>Address</th>
					<th>Quantity Available</th>
					<th>Price</th>
					<th>Retail Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="repair" items="${repairList}">
					<tr>
					    <td>${repair.repairId}</td>
						<td>${repair.repairDesc}</td>
						<td>${repair.partId}</td>
						<td>${repair.partDesc }</td>
						<td>${repair.quantity }</td>
						<td><a href="editRepair?repairId=${repair.repairId}">Edit</a></td>
						<td><a href="deleteRepair?repairId=${repair.repairId}">Delete</a></td>
						<td><a href="sourceParts?repairId=${repair.repairId}">Source Parts</a></td>
						<td>${repair.shopName}</td>
						<td>${repair.address}</td>
						<td>${repair.quantityav}</td>
						<td>${repair.shPPU }</td>
						<td>${repair.shRPU }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</center>
<script>
	//google.maps.event.addDomListener(window, 'load', setgmap);
	function updateMenuSelection() {
		setgmap();
		$('#menu').multilevelpushmenu('expand', 'Claims');
		$('#currentAction').text('Claim List');
	}
</script>