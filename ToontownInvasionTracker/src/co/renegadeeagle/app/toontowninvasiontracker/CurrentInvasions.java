package co.renegadeeagle.app.toontowninvasiontracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import co.renegadeeagle.app.toontowninvasiontracker.InvasionData.DistrictInfo;
import co.renegadeeagle.app.toontowninvasiontracker.InvasionData.Invasions;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class CurrentInvasions extends Activity {

	Gson gson = new Gson();
	public static InvasionData data;
	public static Map<String, DistrictInfo> invasionInfo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_current_invasions);

		update();
	} 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.current_invasions, menu);
		return true;
	} 
	int currentInvasions = 10;

	URL url;
	HttpURLConnection connection = null;
	InputStream is = null;
	JsonParser parser = new JsonParser();
	/*
	 * First time effectively using gson wen't well, I guess.
	 */
	public void update() {
		try{
			url = new URL("https://www.toontownrewritten.com/api/invasions");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			String repo;
			repo = response.toString();

			JsonElement jelement = new JsonParser().parse(repo);
			JsonObject  jobject = jelement.getAsJsonObject();

			long lastUpdated = jobject.get("lastUpdated").getAsLong();
			JsonObject invasionObject = jobject.getAsJsonObject("invasions");

			List<String> activeDistricts = new ArrayList<String>();
			for (Map.Entry<String,JsonElement> entry : invasionObject.entrySet()) {
				activeDistricts.add(entry.getKey());
			}
			Map<String, DistrictInfo> invasionsPerDistrict = new HashMap<String, DistrictInfo>();
			for(String districtName : activeDistricts){
				String asOf = invasionObject.getAsJsonObject(districtName).get("asOf").getAsString();
				String type = invasionObject.getAsJsonObject(districtName).get("type").getAsString();
				String progress = invasionObject.getAsJsonObject(districtName).get("progress").getAsString();
				DistrictInfo di = new DistrictInfo(asOf, type, progress);
				invasionsPerDistrict.put(districtName, di);
			}
			Invasions invasions = new Invasions(invasionsPerDistrict);

			data = new InvasionData(lastUpdated, "null", invasions);

			in.close();
			//Iterator it = data.getInvasions().getDistricts().entrySet().iterator();
			invasionInfo = invasionsPerDistrict;
			/*while(it.hasNext()){
				Map.Entry pairs = (Map.Entry)it.next();
		        it.remove();		        
			}*/


			TextView amountOfInvasions = (TextView) findViewById(R.id.amountofinvasions);
			amountOfInvasions.setText(invasionInfo.size()+"");
		}catch( IOException e){
			e.printStackTrace();
		}
	}

	public Gson getGson() {
		return gson;
	}

	public void setGson(Gson gson) {
		this.gson = gson;
	}

	public static InvasionData getData() {
		return data;
	}

	public static void setData(InvasionData data) {
		CurrentInvasions.data = data;
	}

	public static Map<String, DistrictInfo> getInvasionInfo() {
		return invasionInfo;
	}

	public static void setInvasionInfo(Map<String, DistrictInfo> invasionInfo) {
		CurrentInvasions.invasionInfo = invasionInfo;
	}

	public int getCurrentInvasions() {
		return currentInvasions;
	}

	public void setCurrentInvasions(int currentInvasions) {
		this.currentInvasions = currentInvasions;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public HttpURLConnection getConnection() {
		return connection;
	}

	public void setConnection(HttpURLConnection connection) {
		this.connection = connection;
	}

	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}

	public JsonParser getParser() {
		return parser;
	}

	public void setParser(JsonParser parser) {
		this.parser = parser;
	}

}