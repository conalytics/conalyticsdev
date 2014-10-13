<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<center>
		<table  id="conTable"  class="display" cellspacing="0" width="100%">
		 <thead>
			<tr>
				<th >PART ID</th>
				<th> AUTO ID</th>
				<th> PART NAME</th>
				<th> MODEL</th>
				<th> VERSION</th>
				<th> YEAR BUILT</th>
				<th> OEM NUMBER</th>
				<th> COLOUR</th>
				<th> MSRP</th>
				<th >Edit</td>
				<th >Delete</td>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="part" items="${partList}">
				<tr>
					<td>${part.partId}</td>
					<td>${part.autoId}</td>
					<td title="${part.partDesc}">${part.partName}</td>
					<td>${part.model}</td>
					<td>${part.version}</td>
					<td>${part.yearBuilt}</td>
					<td>${part.oemNumber}</td>
					<td>${part.color}</td>
					<td>${part.msrp}</td>
					
					<td><a href="editPart?id=${part.partId}">Edit</a></td>
					<td><a href="deletePart?id=${part.partId}">Delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</center>
		<script>
function updateMenuSelection() {
	$( '#menu' ).multilevelpushmenu( 'expand' , 'Parts' );
	$('#currentAction').text('Parts List');
}
</script>	