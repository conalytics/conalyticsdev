/**
 * 
 */

var geocoder;
var map;

function setgmap() {
	
  
  var address = document.getElementById('address').value;
  var shopPos = document.getElementById('shops').value;
  var shopsPosArray = $.parseJSON(shopPos);
  geocoder = new google.maps.Geocoder();
  var mapOptions = { 
      zoom: 8
    };
  map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
  geocoder.geocode( { 'address': address}, function(results, status) {
    if (status == google.maps.GeocoderStatus.OK) {
      showMarker(map, results[0].geometry.location, true ,"vehicle");
      $.each(shopsPosArray, function(i, item) {
    	 
    	 showMarker(map, new google.maps.LatLng(item.lat, item.lon), false, '"'+item.rid+'"');
      });
    } else {
      alert('Geocode was not successful for the following reason: ' + status);
    }
  });
  
  
}

function showMarker(map, location, setCenter , rid) {
	var bounds = new google.maps.LatLngBounds();
	bounds.extend(location); 
	if(setCenter) {
		map.setCenter(location);
	}
    new google.maps.Marker({
        map: map,
        position: location,
        title: rid
    });
}
