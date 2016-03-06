package tutorial.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import tutorial.java.rest.RestObject;

public class Geocoder {

	// https://maps.googleapis.com/maps/api/geocode/json?address=Brussels

	public String call(String address) {
	    String line;
		try {

			URL url = new URL(
					"http://maps.googleapis.com/maps/api/geocode/json?address=" + address);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}


			// Get response
	        BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        StringBuilder stringBuilder = new StringBuilder();


	        while ((line = bufferedReader.readLine()) != null)
	        {
	            stringBuilder.append(line + '\n');
	        }
	        
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			// Convert JSON string to Object
			String jsonInString = stringBuilder.toString();
			RestObject restResult = mapper.readValue(jsonInString, RestObject.class);
			
			conn.disconnect();
			return restResult.toString();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		
		return null;
	}
}
