<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<center>
	<div id="firstDivistion" style="position: absolute !important;">
		<table id="conTable2" class="display" cellspacing="0" width="100%">
			<tbody>
				<tr>
					<td><b>Claim Id:</b>${map.claim.claimId}</td>
					<td><b>Date:</b>${map.claim.date}</td>
					<td><b>VIN:</b>${map.claim.VIN }</td>
					<td><b>Vehicle :</b>${auto.yearBuilt } ${comp.companyName}  ${auto.autoName } ${auto.model } </td>
					<td><b>Color:</b>${map.claim.color }</td>
					<td><b>Vehicle Location:</b>${map.claim.location }<input id="address"
						type="hidden" value=${map.claim.location }> <input
						id="shops" type="hidden" value='${jsongeocode}'>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div>
	<div id="map-canvas" style="float: left; height: 400px; width: 68%; margin-top: 30px; position: absolute !important;"></div>
		<div id="newRepairDiv" style="float: right; width: 32%;">	
		<form:form method="POST" class="idealforms" autocomplete="off" action="/insertRepair" modelAttribute="repair" >
		<div style="float: left;">

				<div class="field">
					<label class="main">Repair Description*:</label>
					<form:input path="repairDesc" cssStyle="width:190px" />
					<span class="error"></span>
				</div>	
				<div class="idealforms-field-select-one">
					<label class="main">Part Category*:</label>
					<form:select  path="catId" onchange="loadDescDropdown()" cssStyle="width:190px"> 
					</form:select>
					<span class="error"></span>
				</div>

				<div id="partIdDescDiv" class="field">
					<label class="main">Part Description:</label>
					<form:select path="partId" cssStyle="width:190px">
					</form:select>
					<span><a title="If you dont see the part description in the list, click here to enter new part description." href="#" onclick="showNewPartDesc()">New part description</a> </span>
					<span class="error"></span>
				</div>
				
				<div id="newDescDiv" class="field">
					<label class="main">Part Description:</label>
					<form:input path="partDesc" cssStyle="width:190px"/>
					<span><a title="Click here to select the part description from the list." href="#" onclick="showPartDescList()">Select from list</a> </span>
					<span class="error"></span>
				</div>
				
				<div class="field">
					<label class="main">Quantity</label>
					<form:input path="quantity" cssStyle="width:190px"/>
					<span class="error"></span>
				</div>

				<div class="field button">
					<label class="main">&nbsp;</label>
					<button type="submit">Add Repair</button>
				</div>
				</div>
				<input id="claimId" name="claimId" type="hidden" value="${map.claim.claimId}"/>
				<form:hidden path="partDesc"/>
			</form:form>
		</div>
	</div>

	

	<div id="secondDivistion" style="position: absolute !important; margin-top: 500px;">
		Total Retail Cost:${rpc} Total Price Per Unit:${ppc}
		<table id="repairTable" class="display" cellspacing="0" width="100%">
			<thead>
				<tr>
				    <th>Repair Id</th>
					<th>Repair Desc</th>
					<th>Parts Id</th>
					<th>Parts Desc</th>
					<th>Quantity Required</th>
					<th>Delete</th>
					<th>Source parts</th>
					<th>Shop Name</th>
					<th>Address</th>
					<th>Quantity Available</th>
					<th>Price</th>
					<th>Retail Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="repair" items="${repairList}">
					<tr>
					    <td>${repair.repairId}</td>
						<td>${repair.repairDesc}</td>
						<td>${repair.partId}</td>
						<td>${repair.partDesc }</td>
						<td>${repair.quantity }</td>
						<td><a href="deleteRepair?repairId=${repair.repairId}">Delete</a></td>
						<td><a href="sourceParts?repairId=${repair.repairId}">Source Parts</a></td>
						<td>${repair.shopName}</td>
						<td>${repair.address}</td>
						<td>${repair.quantityav}</td>
						<td>${repair.shPPU }</td>
						<td>${repair.shRPU }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	

	</div>
</center>
<script>
loadDescDropdown();
	var partDescIdList = $('#partId');
	$(partDescIdList).select2({
		placeholder: "Select a Part Desc",
		allowClear: true,
		minimumInputLength: 2,
	    width: "190px"
	});
	
	var allCatList = $('#catId');
	$(allCatList).select2({
		placeholder: "Select a Category",
		allowClear: true,
		minimumInputLength: 0,
	    width: "190px"
	});
	//google.maps.event.addDomListener(window, 'load', setgmap);
	function updateMenuSelection() {
		setgmap();
		$('#menu').multilevelpushmenu('expand', 'Claims');
		$('#currentAction').text('Claim List');
		$('#conBody').css('border', 'none');
		$('#newDescDiv').hide();
		$.getJSON("<%=request.getContextPath()%>/getAllCategories", function(data){
			data.forEach(function(group){
			var $optgroup = $('<optgroup label="' + group.category + '">');
			group.parts.forEach(function(option){
				$optgroup.append('<option value="' + option.name + '">' + 
				option.label + '</option>');
				});
				$('#catId').append($optgroup);
			});
		});
	}

	function showNewPartDesc() {
		$('#partIdDescDiv').hide();
		$('#newDescDiv').show();
		$('#partId').val("");
	}

	function showPartDescList() {
		$('#partIdDescDiv').show();
		$('#newDescDiv').hide();
		loadDescDropdown();
		$('#partDesc').val("");
	}

	function loadDescDropdown() {
		var catId = $(allCatList).select2('val');
		if(catId){
			$('#partId').empty();
			$.getJSON("<%=request.getContextPath()%>/getPartDesc/" + catId  + "/" + $('#claimId').val(), function(data){
				data.forEach(function(group){
					var $optgroup = $('<optgroup label="' + group.category + '">');
					group.parts.forEach(function(option){
						$optgroup.append('<option value="' + option.name + '">' + 
						option.label + '</option>');
					});
					$('#partId').append($optgroup);
				});
			});
		} 
	}
	

</script>