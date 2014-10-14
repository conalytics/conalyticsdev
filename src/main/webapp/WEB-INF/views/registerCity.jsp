<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<center>
	<form:form method="post" class="idealforms" autocomplete="off" action="/insertAuto" modelAttribute="auto">
		<div style="width: 100%;">

			<div style="float: left; width: 49%;">
				<div class="field">
					<label class="main">City Id:</label>
					<form:input path="cityId" />
					<span class="error"></span>
				</div>
				<div class="field">
					<label class="main">City Desc:</label>
					<form:input path="cityDesc" />
					<span class="error"></span>
				</div>
				<div class="field">
					<label class="main">City Code:</label>
					<form:input path="cityABB" />
					<span class="error"></span>
				</div>
				<div class="idealforms-field-select-one">
					<label class="main">District ID:</label>
					<form:input path="districtID" />
					<span class="error"></span>
				</div>
				<div class="idealforms-field-select-one">
					<label class="main">District:</label>
					<form:input path="districtDesc" />
					<span class="error"></span>
				</div>
				<div class="idealforms-field-select-one">
					<label class="main">State:</label>
					<form:select path="id">
						<form:options items="${stateMap}" />
					</form:select>
					<span class="error"></span>
				</div>
				<div class="field">
					<label class="main">Zip Code</label>
					<form:input path="zipCode" />
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
		$('#menu').multilevelpushmenu('expand', 'City');
		$('#currentAction').text('Add New City');
	}
</script>
