package edu.umkc.laughlina;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        View rulesButton = findViewById(R.id.rules_button);
        rulesButton.setOnClickListener(this);
        View scoreButton = findViewById(R.id.score_button);
        scoreButton.setOnClickListener(this);
        View statButton = findViewById(R.id.stat_button);
        statButton.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_about:
			openAbout();
			return true;
		case R.id.action_settings:
			openSettings();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
    }
    
	private void openAbout() {
		Intent intent = new Intent(this, AboutActivity.class);
		startActivity(intent);
	}

	private void openSettings() {
		Intent intent = new Intent(this, SettingsActivity.class);
		startActivity(intent);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.rules_button:
			openRules();
			break;
		case R.id.score_button:
			openScoreBoard();
			break;
		case R.id.stat_button:
			openStatsPage();
			break;
		}
	}

	private void openRules() {
		Intent intent = new Intent(this, RulesActivity.class);
		startActivity(intent);
	}

	private void openScoreBoard() {
		Intent intent = new Intent(this, ScoreBoardActivity.class);
		startActivity(intent);
	}

	private void openStatsPage() {
		Intent intent = new Intent(this, StatsActivity.class);
		startActivity(intent);
	}
    
}
