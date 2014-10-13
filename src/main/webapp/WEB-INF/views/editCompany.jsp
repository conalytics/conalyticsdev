<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<center>
		<br /> <br /> <br /> <b>Edit Company Details </b><br /> <br />
		<div>
			<form:form method="post" action="updateCompany" modelAttribute="company">
				<table>

					
					<tr>
						<td>Company Id</td>
						<TD><form:input path="companyId"
								value="${map.company.companyId}" /></td>

					</tr>
					<tr>
						<td>Company Name</td>
						<TD><form:input path="companyName" value="${map.company.companyName}" /></td>

					</tr>
					<tr>
						<td>Company Desc</td>
						<TD><form:input path="companyDesc" value="${map.company.companyDesc}" /></td>

					</tr>
					<tr>
						<td>Phone Number</td>
						<TD><form:input path="phoneNumber" value="${map.company.phoneNumber}" /></td>

					</tr>
					<tr>
						<td>Website</td>
						<TD><form:input path="websiteAddress" value="${map.company.websiteAddress}" /></td>

					</tr>
					<tr>
						<td>Email</td>
						<TD><form:input path="emailId" value="${map.company.emailId}" /></td>
					</tr>
					<tr>
						<td>address</td>
						<TD><form:input path="address" value="${map.company.address}" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="Update" /></td>
					</tr>
				</table>
				<form:hidden path="companyId" value="${map.company.companyId}" />

			</form:form>
		</div>
	</center>
	<script>
function updateMenuSelection() {
	$( '#menu' ).multilevelpushmenu( 'expand' , 'Company' );
}
</script>