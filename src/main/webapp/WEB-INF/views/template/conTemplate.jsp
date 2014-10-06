<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.conalytics.controller.Menu"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300,300italic,700&subset=latin,cyrillic-ext,latin-ext,cyrillic'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.1/css/font-awesome.min.css">

<link
	href="<c:url value="/resources/css/jquery.multilevelpushmenu_red.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/expandcollapse.css"/>"
	rel="stylesheet">
<script type="text/javascript"
	src="http://oss.maxcdn.com/libs/modernizr/2.6.2/modernizr.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
<script
	src="<c:url value="/resources/js/jquery.multilevelpushmenu.min.js" />"></script>

<script>
	$(document).ready(function() {
		$('#menu').multilevelpushmenu({
			menu : <%=Menu.getMenuItems()%>	,
			containersToPush : [ $('#pushobj') ],
			// Just for fun also changing the look of the menu
			wrapperClass : 'mlpm_w',
			menuInactiveClass : 'mlpm_inactive'
		});
		$('ul li').each(function(i) {
			if ($(this).attr('id')) {
				var aLink = $("a",this);
				if (aLink) {
					aLink.click(function() {
						location.href = aLink.attr('href');
					});
				}
			}
		});
		
	});
</script>
</head>
<body>
	<!--[if lt IE 7]>
            <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
	<div id="pushobj">
		<center>
			<h1>Conalytics</h1>
		</center>
		<br>
		<tiles:insertAttribute name="body" />
	</div>
	<div id="menu"></div>

</body>
</html>
