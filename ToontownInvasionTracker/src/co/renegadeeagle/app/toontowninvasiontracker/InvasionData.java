package co.renegadeeagle.app.toontowninvasiontracker;

import java.util.List;
import java.util.Map;

public class InvasionData {

	public long lastUpdated;
	public String error;
	public List<District> districts;
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
	
	public List<District> getDistricts() {
		return districts;
	}
	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}
	
	public InvasionData(long lastUpdated, String error, List<District> districts){
		this.lastUpdated = lastUpdated;
		this.error = error;
		this.districts = districts;
	}
	
	/*public static class Invasions{
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
	}*/
	/*public static class Districts{
		List<District> districts;
		public Districts(List<District> districts){
			this.districts = districts;
		}
		public List<District> getDistricts() {
			return districts;
		}
		public void setDistricts(List<District> districts) {
			this.districts = districts;
		}
		
	}*/
	public static class District{
		public String name;
		public DistrictInfo info;
		public District(String name, DistrictInfo info){
			this.name = name;
			this.info = info;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public DistrictInfo getInfo() {
			return info;
		}
		public void setInfo(DistrictInfo info) {
			this.info = info;
		}
		
	}
	public static class DistrictInfo{
		
		public String asOf;
		public String type;
		public String progress;
		public DistrictInfo(String asOf, String type, String progress){
			this.asOf = asOf; 
			this.type = type;
			this.progress = progress;
		}
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
	}	
}
