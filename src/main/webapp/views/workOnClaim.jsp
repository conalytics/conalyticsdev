<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<center>
	<table id="conTable" class="display" cellspacing="0" width="100%">

		<tbody>

				<tr>
					<td>CLAIM ID:${map.claim.claimId}</td>
					<td>DATE:${map.claim.date}</td>
					<td>VIN:${map.claim.VIN }</td>
					<td>AUTO ID:${map.claim.modelId }</td>
					<td>COLOR:${map.claim.color }</td>
					<td>REPAIR LOCATION:${map.claim.shopId }</td>
				</tr>

		</tbody>
	</table>
<div>
		<form:form method="post" action="addRepairClaim" modelAttribute="repair"
			class="idealforms" autocomplete="off">
			<div style="width: 100%;">
				<div style="float: left; width: 49%;">

					<div class="field">
						<label class="main">Repair Desc:</label>
						<form:input path="repairDesc" />
						<span class="error"></span>
					</div>

					<div class="field">
						<label class="main">Parts Id:</label>
						<form:input path="partsId" />

						<span class="error"></span>
					</div>
				</div>
				<div style="float: right; width: 50%; margin-left: 10px;">
					<div class="field">
						<label class="main">Parts Quantity:</label>
						<form:input path="partsCount"/>

						<span class="error"></span>
					</div>

					<div class="field">
						<label class="main">Parts Desc:</label>
						<form:input path="partsDesc"/>
						<span class="error"></span>
					</div>

				</div>
				<div>
					<div class="field button">
						<label class="main">&nbsp;</label>
						<button type="submit">Add Repair Item</button>
					</div>
				</div>
			</div>
			<form:hidden path="cityId" value="${map.city.cityId}" />

		</form:form>
	</div>
</center>
<script>
	function updateMenuSelection() {
		$('#menu').multilevelpushmenu('expand', 'Claim');
		$('#currentAction').text('Claim List');
	}
</script>