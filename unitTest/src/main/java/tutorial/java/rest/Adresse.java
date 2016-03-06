package tutorial.java.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Adresse {

	@JsonProperty("formatted_address")
	private String formattedAddress;


	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}
	
	@Override
	public String toString() {
		return  "formated_address: "+formattedAddress;
	}
}
