<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<center>
	<table id="conTable" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>CITY ID</th>
				<th>CITY DESC</th>
				<th>CITY ABB</th>
				<th>DISTRICT ID</th>
				<th>DISTRICT DESC</th>
				<th>STATE ID</th>
				<th>STATE DESC</th>
				<th>ZIP CODE</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="city" items="${cityList}">
				<tr>
					<td>${city.cityId}</td>
					<td>${city.cityDesc}</td>
					<td>${city.cityABB }</td>
					<td>${city.districtID }</td>
					<td>${city.districtDesc }</td>
					<td>${city.stateID }</td>
					<td>${city.stateDesc}</td>
					<td>${city.zipCode}</td>
					<td><a href="editCity?id=${city.cityId}">Edit</a></td>
					<td><a href="deleteState?id=${city.cityId}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</center>
<script>
	function updateMenuSelection() {
		$('#menu').multilevelpushmenu('expand', 'City');
		$('#currentAction').text('City List');
	}
</script>