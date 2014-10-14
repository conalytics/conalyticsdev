<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<center>
		<br /> <br /> <br /> <b>Edit Auto Details </b><br /> <br />
		<div>
			<form:form method="post" action="updateState" modelAttribute="state">
				<table>

					
					<tr>
						<td>STATE ID</td>
						<TD><form:input path="id"
								value="${map.state.id}" /></td>

					</tr>
					<tr>
						<td>STATE NAME</td>
						<TD><form:input path="stateDesc" value="${map.state.stateDesc}" /></td>

					</tr>
					<tr>
						<td>STATE CODE</td>
						<TD><form:input path="stateABB" value="${map.state.stateABB}" /></td>

					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="Update" /></td>
					</tr>
				</table>
				<form:hidden path="id" value="${map.state.id}" />

			</form:form>
		</div>
	</center>
	<script>
function updateMenuSelection() {
	$( '#menu' ).multilevelpushmenu( 'expand' , 'States' );
}
</script>