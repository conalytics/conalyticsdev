<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
body {
	font-size: 20px;
	color: teal;
	font-family: Calibri;
}

td {
	font-size: 15px;
	color: black;
	width: 100px;
	height: 22px;
	text-align: center;
}
.heading {
	font-size: 18px;
	color: white;
	font: bold;
	background-color: orange;
	border: thick;
}
</style>
	<center><b>City List </b><br />
		<table  id="conTable"  class="display" cellspacing="0" width="100%">
		 <thead>
			<tr>
				<th >CITY_ID </td>
				<th >CITY_DESC </td>
				<th >CITY_ABB  </td>
				<th >DISTRICT_ID</td>
				<th >DISTRICT_DESC</td>
				<th >STATE_ID</td>
				<th >ZIP_CODE</td>
				<th >Edit</td>
				<th >Delete</td>
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
<script>
function updateMenuSelection() {
	$( '#menu' ).multilevelpushmenu( 'expand' , 'City' );
}
</script>		