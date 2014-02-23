package edu.umkc.laughlina;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;
import android.widget.TextView;

public class RulesActivity extends Activity {

	private TextView scrollText;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        
        this.scrollText = (TextView) this.findViewById(R.id.textViewWithScroll);
        
        scrollText.setText("");
        
        for(int x = 1; x < 11; x++ ) {
        	scrollText.append(" --- HOW TO PLAY --- ");
        	scrollText.append("\n\n\tHello there!" +
        			"\n - Rules on how to play will be added soon." +
        			"\n - Rules on how to keep score will also be added." +
        			"\n - A brief history will be introduced as well." +
        			"\nTHIS IS A SCROLLING TEXT SCREEN\n");
        	}
    }

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rules, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
