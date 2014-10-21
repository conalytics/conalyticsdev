<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<center>
	<table id="conTable" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>SHOP ID</th>
				<th>CITY ID</th>
				<th>TOWN MUNI</th>
				<th>SHOP NAME</th>
				<th>SHOP DESC</th>
				<th>PHONE NUMBER</th>
				<th>WEBSITE</th>
				<th>EMAIL</th>
				<th>ADDRESS</th>
				<th>HRLY RATE</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="shop" items="${shopList}">
				<tr>
					<td>${shop.shopId}</td>
					<td>${shop.cityId}</td>
					<td>${shop.townMuni}</td>
					<td>${shop.shopName}</td>
					<td>${shop.shopDesc}</td>
					<td>${shop.phoneNumber}</td>
					<td>${shop.website}</td>
					<td>${shop.email}</td>
					<td>${shop.address}</td>
					<td>${shop.stdHrlyLaborRate}</td>				
					<td><a href="editShop?id=${shop.shopId}">Edit</a></td>
					<td><a href="deleteShop?id=${shop.shopId}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</center>
<script>
	function updateMenuSelection() {
		$('#menu').multilevelpushmenu('expand', 'Shops');
		$('#currentAction').text('Shops List');
	}
</script>