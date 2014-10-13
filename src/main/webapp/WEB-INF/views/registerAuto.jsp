<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<center>
	<form:form method="post" class="idealforms" autocomplete="off" action="/insertAuto" modelAttribute="auto">
		<div style="width: 100%;">

			<div style="float: left; width: 49%;">
				<div class="field">
					<label class="main">Auto Id:</label>
					<form:input path="autoId" />
					<span class="error"></span>
				</div>
				<div class="idealforms-field-select-one">
					<label class="main">Company:</label>
					<form:select path="companyId">
						<form:options items="${companyMap}" />
					</form:select>
					<span class="error"></span>
				</div>
				<div class="field">
					<label class="main">Auto Name</label>
					<form:input path="autoName" />
					<span class="error"></span>
				</div>

				<div class="field">
					<label class="main">Auto Desc</label>
					<form:input path="autoDesc" />
					<span class="error"></span>
				</div>
			</div>
			<div style="float: right; width: 50%; margin-left: 10px;">
				<div class="field">
					<label class="main">Model</label>
					<form:input path="model" />

					<span class="error"></span>
				</div>

				<div class="field">
					<label class="main">Version</label>
					<form:input path="version" />
					<span class="error"></span>
				</div>

				<div class="field">
					<label class="main">Year Built</label>
					<form:input path="yearBuilt" />
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
		$('#menu').multilevelpushmenu('expand', 'Vehicles');
		$('#currentAction').text('Add New Vehicle');
	}
</script>
