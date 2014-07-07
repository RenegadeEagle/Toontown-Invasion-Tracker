package co.renegadeeagle.app.toontowninvasiontracker;

import java.util.Map;

public class InvasionData {

	public long lastUpdated;
	public String error;
	public Invasions invasions;
	public long getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(long lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	public InvasionData(long lastUpdated, String error, Invasions invasions){
		this.lastUpdated = lastUpdated;
		this.error = error;
	}
	
	public static class Invasions{
		public Map<String, DistrictInfo> districts;
		public Invasions(Map<String, DistrictInfo> districts){
			this.districts = districts;
		}
		public Map<String, DistrictInfo> getDistricts() {
			return districts;
		}
		public void setDistricts(Map<String, DistrictInfo> districts) {
			this.districts = districts;
		}
	}
	public static class DistrictInfo{
		public String getAsOf() {
			return asOf;
		}
		public void setAsOf(String asOf) {
			this.asOf = asOf;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getProgress() {
			return progress;
		}
		public void setProgress(String progress) {
			this.progress = progress;
		}
		public String asOf;
		public String type;
		public String progress;
		public DistrictInfo(String asOf, String type, String progress){
			this.asOf = asOf; 
			this.type = type;
			this.progress = progress;
		}
	}
	public Invasions getInvasions() {
		return invasions;
	}
	public void setInvasions(Invasions invasions) {
		this.invasions = invasions;
	}
	
}
