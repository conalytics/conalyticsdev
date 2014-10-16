<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<center>
	<div>
		<form:form method="post" action="updateCity" modelAttribute="city"
			class="idealforms" autocomplete="off">
			<div style="width: 100%;">
				<div style="float: left; width: 49%;">
					<div class="field">
						<label class="main">CITY ID:</label>
						<form:input path="cityId" value="${map.city.cityId}" />

						<span class="error"></span>
					</div>

					<div class="field">
						<label class="main">CITY DESC:</label>
						<form:input path="cityDesc" value="${map.city.cityDesc}" />

						<span class="error"></span>
					</div>

					<div class="field">
						<label class="main">CITY CODE:</label>
						<form:input path="cityCode" value="${map.city.cityCode}" />

						<span class="error"></span>
					</div>
				</div>
				<div style="float: right; width: 50%; margin-left: 10px;">
					<div class="field">
						<label class="main">DISTRICT ID</label>
						<form:input path="districtID" value="${map.city.districtID}" />

						<span class="error"></span>
					</div>

					<div class="field">
						<label class="main">DISTRICT DESC:</label>
						<form:input path="districtDesc" value="${map.city.districtDesc}" />

						<span class="error"></span>
					</div>

					<div class="field">
						<label class="main">STATE ID:</label>
						<form:input path="stateID" value="${map.city.stateID}" />
						<span class="error"></span>
					</div>

					<div class="field">
						<label class="main">STATE DESC:</label>
						<form:input path="stateDesc" value="${map.city.stateDesc}" />
						<span class="error"></span>
					</div>
				</div>
				<div>
					<div class="field button">
						<label class="main">&nbsp;</label>
						<button type="submit">Update</button>
					</div>
				</div>
			</div>
			<form:hidden path="cityId" value="${map.city.cityId}" />

		</form:form>
	</div>
</center>
<script>
	function updateMenuSelection() {
		$('#menu').multilevelpushmenu('expand', 'City');
		$('#currentAction').text('Edit City');
	}
</script>