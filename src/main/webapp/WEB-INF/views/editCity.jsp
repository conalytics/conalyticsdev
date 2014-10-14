<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<center>
		<br /> <br /> <br /> <b>Edit City Details </b><br /> <br />
		<div>
			<form:form method="post" action="updateCity" modelAttribute="city">
				<table>

					
					<tr>
						<td>City Id:</td>
						<TD><form:input path="cityId"
								value="${map.city.cityId}" /></td>

					</tr>
					<tr>
						<td>City Desc:</td>
						<TD><form:input path="cityDesc" value="${map.city.cityDesc}" /></td>

					</tr>
					<tr>
						<td>City Code:</td>
						<TD><form:input path="cityABB" value="${map.city.cityABB}" /></td>

					</tr>
					<tr>
						<td>District ID:</td>
						<TD><form:input path="districtID" value="${map.city.districtID}" /></td>

					</tr>
					<tr>
						<td>District:</td>
						<TD><form:input path="districtDesc" value="${map.city.districtDesc}" /></td>

					</tr>
					<tr>
						<td>State ID:</td>
						<TD><form:input path="stateID"
								value="${map.city.stateID}" /></td>
					</tr>
					<tr>
						<td>State Desc:</td>
						<TD><form:input path="stateDesc"
								value="${map.city.stateDesc}" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="Update" /></td>
					</tr>
				</table>
				<form:hidden path="cityId" value="${map.city.cityId}" />

			</form:form>
		</div>
	</center>
	<script>
function updateMenuSelection() {
	$( '#menu' ).multilevelpushmenu( 'expand' , 'City' );
}
</script>