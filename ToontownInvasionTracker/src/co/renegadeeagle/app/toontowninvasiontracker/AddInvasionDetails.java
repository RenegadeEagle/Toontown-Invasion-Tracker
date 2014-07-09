package co.renegadeeagle.app.toontowninvasiontracker;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import co.renegadeeagle.app.toontowninvasiontracker.InvasionData.District;
import android.app.Activity;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

public class AddInvasionDetails {	
	public CurrentInvasions mainActivity;
	public AddInvasionDetails(CurrentInvasions mainActivity){
		this.mainActivity = mainActivity;
	}
	
	static List<View> textViews = new ArrayList<View>();
	public void addDetails(){
		ListIterator<View> it = textViews.listIterator();    
		while(it.hasNext()){
			View next = it.next();
			LinearLayout layout = (LinearLayout) mainActivity.findViewById(R.id.linearlayout);
			layout.removeViewInLayout(next);
		}
		
		for(District district: CurrentInvasions.getData().getDistricts()){
			LinearLayout layout = (LinearLayout) mainActivity.findViewById(R.id.linearlayout);
			TextView districtName = new TextView(mainActivity);
			districtName.setText(district.getName());
			districtName.setGravity(Gravity.CENTER);
			districtName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
			layout.addView(districtName);

			TextView type = new TextView(mainActivity);
			type.setText("Cog Type: "+district.getInfo().getType());
			type.setGravity(Gravity.CENTER);
			type.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
			layout.addView(type);

			TextView progress = new TextView(mainActivity);
			progress.setText("Cogs destroyed: "+district.getInfo().getProgress());
			progress.setGravity(Gravity.CENTER);
			progress.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
			layout.addView(progress);

			View ruler = new View(mainActivity); ruler.setBackgroundColor(Color.GRAY);
			layout.addView(ruler, new ViewGroup.LayoutParams( ViewGroup.LayoutParams.FILL_PARENT, 2));

			textViews.add(ruler);
			textViews.add(progress);
			textViews.add(districtName);
			textViews.add(type);
			Toast toast = Toast.makeText(mainActivity, "Updated!", Toast.LENGTH_SHORT);
			toast.show();
		}
		if(CurrentInvasions.getData().getDistricts().size() == 0){
			Toast toast = Toast.makeText(mainActivity, "No current invasions!", Toast.LENGTH_LONG);
			toast.show();
		}
	}
}
