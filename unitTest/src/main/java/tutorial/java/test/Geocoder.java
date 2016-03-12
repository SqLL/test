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
	private String base;
	private String apiService;
	private String type;
	private String parameter;
	
	private HttpURLConnection conn;

	public Geocoder() {
		base = "http://maps.googleapis.com/maps/";
		apiService = "api/geocode/";
		type = "json";
		parameter = "address";
	}
	
	public String call(String address) {
	    String line;
		try {

			URL url = new URL(
					base + apiService + type + "?"+ parameter + "=" + address);
			
			conn = (HttpURLConnection) url.openConnection();
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

			handlerException();

		} catch (IOException e) {

			handlerException();

		}
		
		return null;
	}
	
	public void handlerException() {
		System.out.println("there is some trouble here");
	}
	
	public HttpURLConnection getConn() {
		return conn;
	}

	public void setConn(HttpURLConnection conn) {
		this.conn = conn;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getApiService() {
		return apiService;
	}

	public void setApiService(String apiService) {
		this.apiService = apiService;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
}
