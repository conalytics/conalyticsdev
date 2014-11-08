<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<center>
	<table id="conTable2" class="display" cellspacing="0" width="100%">

		<tbody>

				<tr>
					<td>CLAIM ID:${map.claim.claimId}</td>
					<td>DATE:${map.claim.date}</td>
					<td>VIN:${map.claim.VIN }</td>
					<td>AUTO ID:${map.claim.modelId }</td>
					<td>COLOR:${map.claim.color }</td>
					<td>Vehicle City:${map.claim.location }<input id="address" type="hidden" value=${map.claim.location }></td>
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
				<th>Shop Desc</th>
				<th>Parts Id</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Retail price</th>
				<th>Source parts</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="sp" items="${sourceParts}">
				<tr>
					<td>${sp.SHOP_ID}</td>
					<td>${sp.PART_ID}</td>
					<td>${sp.QTY_AVAILABLE }</td>
					<td>${sp.PRICE_PER_UNIT }</td>
					<td>${sp.RTL_PRICE_PER_UNIT }</td>
					<td><a href="selectShop?shopid=${sp.SHOP_ID}&repairid=${ritem.repairId}">select shop</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</center>
<script>
//google.maps.event.addDomListener(window, 'load', setgmap);
	function updateMenuSelection() {
		setgmap();
		$('#menu').multilevelpushmenu('expand', 'Claims');
		$('#currentAction').text('Claim List');
	}
</script>