<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<center>
	<form:form method="post" class="idealforms" autocomplete="off"
		action="/insertPart" modelAttribute="part">
		<div style="width: 100%;">

			<div style="float: left; width: 49%;">
				<div class="field">
					<label class="main">Part Id:</label>
					<form:input path="partId" />
					<span class="error"></span>
				</div>
				<div class="field">
					<label class="main">Part Name</label>
					<form:input path="partName" />
					<span class="error"></span>
				</div>

				<div class="field">
					<label class="main">Part Desc</label>
					<form:input path="partDesc" />
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
		$('#menu').multilevelpushmenu('expand', 'Part');
		$('#currentAction').text('Add New Part');
	}
</script>
