package tutorial.java.rest;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
	
	@JsonProperty("formatted_address")
	public String formatted_address;
	
	@JsonProperty("place_id")
	public String place_id;

	
	public String getPlace() {
		return place_id;
	}

	public void setPlace(String place_id) {
		this.place_id = place_id;
	}

	public String getFormattedAddress() {
		return formatted_address;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formatted_address = formattedAddress;
	}
	
	@Override
	public String toString() {
		return  "formated_address: "+formatted_address + " place_id: "+ place_id;
	}
}
