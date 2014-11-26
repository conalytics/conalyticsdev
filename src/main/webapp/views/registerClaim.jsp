<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<center>
	<form:form method="POST" class="idealforms" autocomplete="off" action="/insertClaim" modelAttribute="claim" >
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
					<label class="main">Year:</label>
					<input id="autoYear" onblur="loadModelDropdown()"/>
					<span class="error"></span>
				</div>
				<div class="field">
					<label class="main">Vehicle Model</label>
					<form:select path="modelId">
					</form:select>
					<span id="ajaxBusy">Please wait...</span>
					<span class="error"></span>
				</div>

			<div class="field">
					<label class="main">Location:</label>
					<form:input path="location" />
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
		$('#menu').multilevelpushmenu('expand', 'Claims');
		$('#currentAction').text('Add New Claim');
		$.getJSON("<%=request.getContextPath()%>/getautoDetails/", function(data){
			$.each(data, function(value, text) {
	            $('#modelId').append($('<option>').text(text).attr('value', value));
	        });
		});
	}

	function loadModelDropdown() {
		if($("#autoYear").val()){
			$('#modelId').empty();
			$.getJSON("<%=request.getContextPath()%>/getautoDetails/" + $('#autoYear').val(), function(data){
				$.each(data, function(value, text) {
		            $('#modelId').append($('<option>').text(text).attr('value', value));
		        });
			});
		} else {
			$.getJSON("<%=request.getContextPath()%>/getautoDetails", function(data){
				$.each(data, function(value, text) {
		            $('#modelId').append($('<option>').text(text).attr('value', value));
		        });
			});
		}
	}
	var modelIdList = $('#modelId');
	$(modelIdList).select2({
		placeholder: "Select a Model",
		allowClear: true,
		minimumInputLength: 2,
	    width: "300px"
	});
</script>