<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<center>
	<div>
		<form:form method="post" action="updateShop" modelAttribute="shop"
			class="idealforms" autocomplete="off">
			<div style="width: 100%;">
				<div style="float: left; width: 49%;">
					<div class="field">
						<label class="main">SHOP ID:</label>
						<form:input path="shopId" value="${map.shop.shopId}"/>
						<span class="error"></span>
					</div>
					<div class="field">
						<label class="main">CITY ID:</label>
						<form:input path="cityId" value="${map.shop.cityId}"/>
						<span class="error"></span>
					</div>
					<div class="field">
						<label class="main">TOWN MUNI:</label>
						<form:input path="townMuni" value="${map.shop.townMuni}"/>
						<span class="error"></span>
					</div>
					<div class="field">
						<label class="main">SHOP NAME:</label>
						<form:input path="shopName"value="${map.shop.shopName}" />
						<span class="error"></span>
					</div>
					<div class="field">
						<label class="main">SHOP DESC:</label>
						<form:input path="shopDesc" value="${map.shop.shopDesc}"/>
						<span class="error"></span>
					</div>

					<div class="field">
						<label class="main">HRLY RATE:</label>
						<form:input path="stdHrlyLaborRate" value="${map.shop.stdHrlyLaborRate}"/>
						<span class="error"></span>
					</div>
				</div>

				<div style="float: right; width: 50%; margin-left: 10px;">
					<div class="field">
						<label class="main">PHONE NUMBER:</label>
						<form:input path="phoneNumber" value="${map.shop.phoneNumber}"/>
						<span class="error"></span>
					</div>
					<div class="field">
						<label class="main">WEBSITE:</label>
						<form:input path="website" value="${map.shop.website}"/>
						<span class="error"></span>
					</div>
					<div class="field">
						<label class="main">EMAIL:</label>
						<form:input path="email" value="${map.shop.email}"/>
						<span class="error"></span>
					</div>
					<div class="field">
						<label class="main">ADDRESS:</label>
						<form:input path="address" value="${map.shop.address}"/>
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
			<form:hidden path="shopId" value="${map.shop.shopId}" />

		</form:form>
	</div>
</center>
<script>
	function updateMenuSelection() {
		$('#menu').multilevelpushmenu('expand', 'Shops');
		$('#currentAction').text('Edit Shop');
	}
</script>