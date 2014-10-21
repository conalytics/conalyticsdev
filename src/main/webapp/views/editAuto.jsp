<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<center>
	<div>
		<form:form method="post" action="updateAuto" modelAttribute="auto" class="idealforms" autocomplete="off">
			<div style="width: 100%;">
				<div style="float: left; width: 49%;">
					<div class="field">
						<label class="main">COMPANY ID:</label>
						<form:select path="companyId">
							<form:options items="${companyMap}" />
						</form:select>
						<span class="error"></span>
					</div>

					<div class="field">
						<label class="main">AUTO NAME:</label>
						<form:input path="autoName" value="${map.auto.autoName}" />
						<span class="error"></span>
					</div>

					<div class="field">
						<label class="main">AUTO DESC:</label>
						<form:input path="autoDesc" value="${map.auto.autoDesc}" />
						<span class="error"></span>
					</div>
				</div>
				<div style="float: right; width: 50%; margin-left: 10px;">
					<div class="field">
						<label class="main">MODEL:</label>
						<form:input path="model" value="${map.auto.model}" />
						<span class="error"></span>
					</div>

					<div class="field">
						<label class="main">VERSION:</label>
						<form:input path="version" value="${map.auto.version}" />
						<span class="error"></span>
					</div>

					<div class="field">
						<label class="main">YEAR BUILT:</label>
						<form:input path="yearBuilt" value="${map.auto.yearBuilt}" />
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
			<form:hidden path="autoId" value="${map.auto.autoId}" />

		</form:form>
	</div>
</center>
<script>
	function updateMenuSelection() {
		$('#menu').multilevelpushmenu('expand', 'Vehicles');
		$('#currentAction').text('Edit Vehicle');
	}
</script>