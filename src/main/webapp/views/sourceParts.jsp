<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<center>
	<table id="conTable2" class="display" cellspacing="0" width="100%">

		<tbody>


				<tr>
					<td><b>Claim Id:</b>${map.claim.claimId}</td>
					<td><b>Date:</b>${map.claim.date}</td>
					<td><b>VIN:</b>${map.claim.VIN }</td>
					<td><b>Vehicle :</b>${auto.yearBuilt } ${comp.companyName}  ${auto.autoName } ${auto.model } </td>
					<td><b>Color:</b>${map.claim.color }</td>
					<td><b>Vehicle Location:</b>${map.claim.location }<input id="address"
						type="hidden" value=${map.claim.location }> <input
						id="shops" type="hidden" value='${jsongeocode}'>
					</td>
				</tr>

	
				<tr>	
					<td>Repair:${ritem.repairDesc}</td>
					<td>Part:${ritem.partId}</td>
					<td>Part Desc:${ritem.partDesc }</td>
					<td>Quantity:${ritem.quantity }</td>
				</tr>
				
		</tbody>
	</table>

    
		<table id="inventoryTable" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Shop Name</th>
				<th>Parts Id</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Retail price</th>
				<th>Distance from Vehicle</th>
				<th>Selection</th>
				<th>image</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="sp" items="${sourceParts}">
				<tr>
					<td>${sp.shopdesc}</td>
					<td>${sp.PART_ID}</td>
					<td>${sp.QTY_AVAILABLE }</td>
					<td>${sp.PRICE_PER_UNIT }</td>
					<td>${sp.RTL_PRICE_PER_UNIT }</td>
					<td>${sp.distance} KM</td>
					<td><a href="selectShop?shopid=${sp.SHOP_ID}&repairid=${ritem.repairId}&partid=${sp.PART_ID}">select this shop</a></td>
					<td>
					<%-- <a href="1.jpg" class="preview" title="${sp.PART_ID}"> --%>
						<img src="getUserImage/${sp.SHOP_PART_ID}" alt="${sp.SHOP_PART_ID}" height="100px" width="115px" border="0">
					<!-- </a> -->
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</center>
<script>
//google.maps.event.addDomListener(window, 'load', setgmap);
	function updateMenuSelection() {
		$('#menu').multilevelpushmenu('expand', 'Claims');
		$('#currentAction').text('Claim List');
		//imagePreview();
	}
</script>