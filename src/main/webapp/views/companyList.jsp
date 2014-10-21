<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<center>
		<table  id="conTable"  class="display" cellspacing="0" width="100%">
		 <thead>
			<tr>
				<th >COMPANY_ID </td>
				<th >COMPANY_NAME</td>
				<th >COMPANY_DESC</td>
				<th >PHONE_NUMBER </td>
				<th >WEBSITE  </td>
				<th >EMAIL</td>
				<th >ADDRESS</td>
				
				<th >Edit</td>
				<th >Delete</td>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="company" items="${companyList}">
				<tr>
					<td>${company.companyId}</td>
					<td>${company.companyName }</td>
					<td>${company.companyDesc }</td>
					<td>${company.phoneNumber }</td>
					<td>${company.websiteAddress }</td>
					<td>${company.emailId}</td>
					<td>${company.address}</td>
					
					<td><a href="editCompany?id=${company.companyId}">Edit</a></td>
					<td><a href="deleteCompany?id=${company.companyId}">Delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</center>
		<script>
function updateMenuSelection() {
	$( '#menu' ).multilevelpushmenu( 'expand' , 'Company' );
	$('#currentAction').text('Company List');
}
</script>	