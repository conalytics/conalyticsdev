<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<center>
	<table id="conTable" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>STATE_ID
				</th>
				<th>STATE_DESC
				</th>
				<th>STATE_ABB
				</th>
				<th>Edit
				</th>
				<th>Delete
				</th>
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
</center>
<script>
	function updateMenuSelection() {
		$('#menu').multilevelpushmenu('expand', 'States');
		$('#currentAction').text('State List');
	}
</script>