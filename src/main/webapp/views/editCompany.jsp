<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<center>
	<div>
		<form:form method="post" action="updateCompany"
			modelAttribute="company" class="idealforms" autocomplete="off">
			<div style="width: 100%;">

				<div style="float: left; width: 49%;">

					<div class="field">
						<label class="main">Company Name</label>
						<form:input path="companyName" value="${map.company.companyName}" />
						<span class="error"></span>
					</div>

					<div class="field">
						<label class="main">Company Desc</label>
						<form:input path="companyDesc" value="${map.company.companyDesc}" />
						<span class="error"></span>
					</div>
					<div class="field">
						<label class="main">Address</label>
						<form:input path="address" value="${map.company.address}" />
						<span class="error"></span>
					</div>
				</div>

				<div style="float: right; width: 50%; margin-left: 10px;">
					<div class="field">
						<label class="main">Phone Number</label>
						<form:input path="phoneNumber" value="${map.company.phoneNumber}" />

						<span class="error"></span>
					</div>

					<div class="field">
						<label class="main">Website</label>
						<form:input path="websiteAddress"
							value="${map.company.websiteAddress}" />
						<span class="error"></span>
					</div>
					<div class="field">
						<label class="main">email Id</label>
						<form:input path="emailId" value="${map.company.emailId}" />
						<span class="error"></span>
					</div>
				</div>
				<div>
					<div class="field button">
						<label class="main">&nbsp;</label>
						<button type="submit">Submit</button>
					</div>
				</div>
			</div>


			<form:hidden path="companyId" value="${map.company.companyId}" />

		</form:form>
	</div>
</center>
<script>
	function updateMenuSelection() {
		$('#menu').multilevelpushmenu('expand', 'Company');
		$('#currentAction').text('Edit Company');
	}
</script>