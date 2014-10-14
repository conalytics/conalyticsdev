<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<center>
		<div>
			<form:form method="post" action="updatePart" modelAttribute="part" class="idealforms" autocomplete="off">
				<div style="width: 100%;">

			<div style="float: left; width: 49%;">
				
				<div class="field">
					<label class="main">Auto  Id:</label>
					<form:select path="autoId" items="${autoMap}">
					</form:select>
					<span class="error"></span>
				</div>
				<div class="field">
					<label class="main">Part Name</label>
					<form:input path="partName" value="${map.part.partName}"/>
					<span class="error"></span>
				</div>

				<div class="field">
					<label class="main">Part Desc</label>
					<form:input path="partDesc" value="${map.part.partDesc}"/>
					<span class="error"></span>
				</div>
			</div>
			
			<div style="float: right; width: 50%; margin-left: 10px;">
				<div class="field">
					<label class="main">Model</label>
					<form:input path="model" value="${map.part.model}"/>
					<span class="error"></span>
				</div>

				<div class="field">
					<label class="main">Version</label>
					<form:input path="version" value="${map.part.version}"/>
					<span class="error"></span>
				</div>

				<div class="field">
					<label class="main">Year Built</label>
					<form:input path="yearBuilt" value="${map.part.yearBuilt}"/>
					<span class="error"></span>
				</div>
				<div class="field">
					<label class="main">OEM Number</label>
					<form:input path="oemNumber" value="${map.part.oemNumber}"/>
					<span class="error"></span>
				</div>
				<div class="field">
					<label class="main">Color</label>
					<form:input path="color" value="${map.part.color}"/>
					<span class="error"></span>
				</div>
				<div class="field">
					<label class="main">MSRP</label>
					<form:input path="msrp" value="${map.part.msrp}"/>
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
				<form:hidden path="partId" value="${map.part.partId}" />

			</form:form>
		</div>
	</center>
	<script>
function updateMenuSelection() {
	$( '#menu' ).multilevelpushmenu( 'expand' , 'Parts' );
	$('#currentAction').text('Edit Part');
}
</script>