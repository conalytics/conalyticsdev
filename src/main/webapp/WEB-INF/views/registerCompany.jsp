<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<center>
	<form:form method="post" class="idealforms" autocomplete="off"
		action="/insertCompany" modelAttribute="company">
		<div style="width: 100%;">

			<div style="float: left; width: 49%;">
				<div class="field">
					<label class="main">Company Id:</label>
					<form:input path="companyId" />
					<span class="error"></span>
				</div>
				<div class="field">
					<label class="main">Company Name</label>
					<form:input path="companyName" />
					<span class="error"></span>
				</div>

				<div class="field">
					<label class="main">Company Desc</label>
					<form:input path="companyDesc" />
					<span class="error"></span>
				</div>



				<div class="field">
					<label class="main">Address</label>
					<form:input path="address" />
					<span class="error"></span>
				</div>
			</div>
			<div style="float: right; width: 50%; margin-left: 10px;">
				<div class="field">
					<label class="main">Phone Number</label>
					<form:input path="phoneNumber" />
					<span class="error"></span>
				</div>

				<div class="field">
					<label class="main">Website</label>
					<form:input path="websiteAddress" />
					<span class="error"></span>
				</div>

				<div class="field">
					<label class="main">Email</label>
					<form:input path="emailId" />
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
	</form:form>
</center>
<script>
	function updateMenuSelection() {
		$('#menu').multilevelpushmenu('expand', 'Company');
		$('#currentAction').text('Add New Company');
	}
</script>
