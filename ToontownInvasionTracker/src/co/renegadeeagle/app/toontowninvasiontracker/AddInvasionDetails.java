package co.renegadeeagle.app.toontowninvasiontracker;

import java.util.Iterator;
import java.util.Map;

public class AddInvasionDetails {	
	
	//TODO: Create a static method to add invasions to the screen 
	public static void addInvasions(int id, InvasionData data){
		Iterator it = CurrentInvasions.getData().getInvasions().getDistricts().entrySet().iterator();
		while(it.hasNext()){
			Map.Entry pairs = (Map.Entry)it.next();
	        it.remove();		        
		}
	}
	
}
