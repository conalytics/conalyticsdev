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
					<label class="main">Auto  Id:</label>
					<form:select path="autoId">
						<form:options items="${autoMap}" />
					</form:select>
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
				<div class="field">
					<label class="main">OEM Number</label>
					<form:input path="oemNumber" />
					<span class="error"></span>
				</div>
				<div class="field">
					<label class="main">Color</label>
					<form:input path="color" />
					<span class="error"></span>
				</div>
				<div class="field">
					<label class="main">MSRP</label>
					<form:input path="msrp" />
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
		$('#menu').multilevelpushmenu('expand', 'Parts');
		$('#currentAction').text('Add New Part');
	}
</script>
