/**
 * 
 */

var geocoder;
var map;

function setgmap() {
	
  var bounds = new google.maps.LatLngBounds();
  var address = document.getElementById('address').value;
  geocoder = new google.maps.Geocoder();
  var mapOptions = { 
      zoom: 8
    }
  map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
  geocoder.geocode( { 'address': address}, function(results, status) {
    if (status == google.maps.GeocoderStatus.OK) {
      map.setCenter(results[0].geometry.location);
      
      var marker= new google.maps.Marker({
          map: map,
          position: results[0].geometry.location
      });
      var position2 = new google.maps.LatLng(28.612763,77.387132);
      bounds.extend(position2);
      var marker2= new google.maps.Marker({
          map: map,
          position: position2
      });    
      
    } else {
      alert('Geocode was not successful for the following reason: ' + status);
    }
  });
  
  
}

