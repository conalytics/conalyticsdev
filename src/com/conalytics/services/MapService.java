package com.conalytics.services;

import java.io.IOException;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.GeocoderStatus;
import com.google.code.geocoder.model.LatLng;

public class MapService {
	
	public MapService()
	{
	
	}
	
	public Float[] performGeoCoding(String location) {

			  try {  
		  Geocoder geocoder = new Geocoder();
		  GeocoderRequest geocoderRequest
		     = new GeocoderRequestBuilder()
		       .setAddress(location) // location
		       .setLanguage("en") // language
		       .getGeocoderRequest();
		  GeocodeResponse geocoderResponse;

		  
		    geocoderResponse = geocoder.geocode(geocoderRequest);
		    if (geocoderResponse.getStatus() == GeocoderStatus.OK
		      & !geocoderResponse.getResults().isEmpty()) {
		      GeocoderResult geocoderResult =  
		        geocoderResponse.getResults().iterator().next();
		      LatLng latitudeLongitude =
		        geocoderResult.getGeometry().getLocation();
		      Float[] coords = new Float[2];
		      coords[0] = latitudeLongitude.getLat().floatValue();
		      coords[1] = latitudeLongitude.getLng().floatValue();
		     // System.out.print(latitudeLongitude.getLat().floatValue());
		      //System.out.print(latitudeLongitude.getLng().floatValue());
		      return coords;
		    }
		  } catch (IOException ex) {
		    ex.printStackTrace();
		  }
		 return null;
		}
	
	public void createMarker()
	{
	
	
	}
	
	
	
}
