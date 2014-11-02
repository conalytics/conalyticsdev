<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<center>
	<form:form method="post" class="idealforms" autocomplete="off" action="/insertClaim" modelAttribute="claim">
		<div style="width: 100%;">

			<div style="float: left; width: 49%;">

				<div class="field">
					<label class="main">VIN:</label>
					<form:input path="VIN" />
					<span class="error"></span>
				</div>
				<div class="field">
					<label class="main">Color:</label>
					<form:input path="color" />
					<span class="error"></span>
				</div>
				<div class="field">
					<label class="main">Vehicle Model</label>
					<form:input path="modelId" />
					<span class="error"></span>
				</div>

			<div class="field">
					<label class="main">Shop:</label>
					<form:input path="shopId" />
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
		$('#menu').multilevelpushmenu('expand', 'Claim');
		$('#currentAction').text('Add New Claim');
	}
</script>