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
	<center><b>State List </b><br />
		<table  id="conTable"  class="display" cellspacing="0" width="100%">
		 <thead>
			<tr>
				<th >STATE_ID </td>
				<th >STATE_DESC </td>
				<th >STATE_ABB  </td>
				<th >Edit</td>
				<th >Delete</td>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="state" items="${stateList}">
				<tr>
					<td>${state.id }</td>
					<td>${state.stateDesc}</td>
					<td>${state.stateABB}</td>
					<td><a href="editState?id=${state.id}">Edit</a></td>
					<td><a href="deleteState?id=${state.id}">Delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
<script>
function updateMenuSelection() {
	$( '#menu' ).multilevelpushmenu( 'expand' , 'State' );
}
</script>		