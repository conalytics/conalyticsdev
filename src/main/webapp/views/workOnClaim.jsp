<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<center>
<div id="firstDivistion" style="position: absolute !important;" >
	<table id="conTable2" class="display" cellspacing="0" width="100%">

		<tbody>

				<tr>
					<td>CLAIM ID:${map.claim.claimId}</td>
					<td>DATE:${map.claim.date}</td>
					<td>VIN:${map.claim.VIN }</td>
					<td>AUTO ID:${map.claim.modelId }</td>
					<td>COLOR:${map.claim.color }</td>
					<td>Vehicle City:${map.claim.location }<input id="address" type="hidden" value=${map.claim.location }>
					<input id="shops" type="hidden" value='${jsongeocode}'>
					</td>
				</tr>
				
		</tbody>
	</table>
				</div>
				
				<div id="map-canvas" style="height: 400px; width: 80%; margin-top: 30px; position: absolute !important"></div>
				<div id="secondDivistion" style="position: absolute !important; margin-top: 500px;">
    
  
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
					<td><a href="editRepair?repairId=${repair.repairId}">Edit</a></td>
					<td><a href="deleteRepair?repairId=${repair.repairId}">Delete</a></td>
					<td><a href="sourceParts?repairId=${repair.repairId}">Source Parts</a></td>
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