<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<center>
	<form:form method="post" class="idealforms" autocomplete="off" action="/insertState" modelAttribute="state">
		<div style="width: 100%;">

			<div style="float: left; width: 49%;">
				<div class="field">
					<label class="main">State Id:</label>
					<form:input path="id" />
					<span class="error"></span>
				</div>

				<div class="field">
					<label class="main">State Name</label>
					<form:input path="stateDesc" />
					<span class="error"></span>
				</div>

				<div class="field">
					<label class="main">State Code</label>
					<form:input path="stateABB" />
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
		$('#menu').multilevelpushmenu('expand', 'State');
		$('#currentAction').text('Add State');
	}
</script>
