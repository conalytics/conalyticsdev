<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<center>
		<div>
			<form:form method="post" action="/insertAuto" modelAttribute="auto">
				<table cellspacing="0" width="100%">
					<tr>
						<td>AUTO_ID</td>
						<TD><form:input path="autoId" /></td>
					</tr>
					<tr>
						<td>COMPANY_ID</td>
						<TD> <form:select path="companyId">
								<form:options items="${companyMap}" />
						</form:select>
						</td>

					</tr>
					<tr>
						<td>AUTO_NAME</td>
						<TD><form:input path="autoName" /></td>

					</tr>
					<tr>
						<td>AUTO_DESC</td>
						<TD><form:input path="autoDesc" /></td>

					</tr>
					<tr>
						<td>MODEL</td>
						<TD><form:input path="model" /></td>

					</tr>
					<tr>
						<td>VERSION</td>
						<TD><form:input path="version" /></td>

					</tr>
					<tr>
						<td>YEAR_BUILT</td>
						<TD><form:input path="yearBuilt" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="Save" /></td>
					</tr>
					<tr>

						<td colspan="2"><a href="getAutoList">Click Here to See Auto
								List</a></td>
					</tr>
				</table>
			</form:form>
		</div>
	</center>
<script>
function updateMenuSelection() {
	$( '#menu' ).multilevelpushmenu( 'expand' , 'Vehicles' );
	$('#currentAction').text('Add New Vehicle');
}
</script>	