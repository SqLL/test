package tutorial.java.rest;

import java.util.ArrayList;
import java.util.List;

//@JsonIgnoreProperties
//@JsonIgnoreProperties(ignoreUnknown = true)
public class RestObject {

//	@JsonProperty("results")
	private List<Result> results;
	private String status;
	
	public RestObject() {
		results = new ArrayList<Result>();
	}
	

	
	public List<Result> getResults() {
		return results;
	}
	public void setResults(ArrayList<Result> results) {
		this.results.clear();
		for (Result result : results) {
			this.results.add(result);
		}
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		String resultat = "";
		for (Result result : results) {
			resultat += result;
		}
		return resultat.toString() + " status : " + status;
	}
	
}
