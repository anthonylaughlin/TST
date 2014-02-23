package edu.umkc.laughlina;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;

public class ScoreBoardActivity extends Activity implements OnClickListener {

	private int you_set1 = 0;
	private int you_set2 = 0;
	private int you_set3 = 0;
	private int you_set4 = 0;
	private int you_set5 = 0;
	
	private int opp_set1 = 0;
	private int opp_set2 = 0;
	private int opp_set3 = 0;
	private int opp_set4 = 0;
	private int opp_set5 = 0;
	
	private int you_game_score = 0;
	private int opp_game_score = 0;
	
	private boolean game_win = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score_board);
		// Show the Up button in the action bar.
		setupActionBar();
		View winButton = findViewById(R.id.win_button);
        winButton.setOnClickListener(this);
        View loseButton = findViewById(R.id.lose_button);
        loseButton.setOnClickListener(this);
        updateDisplay();
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
		getMenuInflater().inflate(R.menu.score_board, menu);
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

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.win_button:
			if (you_game_score == 0)
				you_game_score = 15;
			else if (you_game_score == 15)
				you_game_score = 30;
			else if (you_game_score == 30)
				you_game_score = 40;
			else if (you_game_score == 40 && opp_game_score < 40) {
				you_game_score = 0;
				opp_game_score = 0;
				game_win = true;
				updateSets(game_win);
			}
			else if (you_game_score == 40 && opp_game_score > 40)
				opp_game_score = 40;
			else if (you_game_score == 40 && opp_game_score == 40)
				you_game_score = 405;
			else {
				you_game_score = 0;
				opp_game_score = 0;
				game_win = true;
				updateSets(game_win);
			}
			updateDisplay();
			break;
		case R.id.lose_button:
			if (opp_game_score == 0)
				opp_game_score = 15;
			else if (opp_game_score == 15)
				opp_game_score = 30;
			else if (opp_game_score == 30)
				opp_game_score = 40;
			else if (opp_game_score == 40 && you_game_score < 40) {
				you_game_score = 0;
				opp_game_score = 0;
				game_win = false;
				updateSets(game_win);
			}
			else if (opp_game_score == 40 && you_game_score > 40)
				you_game_score = 40;
			else if (opp_game_score == 40 && you_game_score == 40)
				opp_game_score = 405;
			else {
				you_game_score = 0;
				opp_game_score = 0;
				game_win = false;
				updateSets(game_win);
			}
			updateDisplay();
			break;
		}
	}
	
	private void updateSets(boolean win) {
		if (win == true) {
			if (you_set1 < 6 && opp_set1 < 6)
				you_set1++;
			else if (you_set2 < 6 && opp_set2 < 6)
				you_set2++;
			else if (you_set3 < 6 && opp_set3 < 6)
				you_set3++;
			else if (you_set4 < 6 && opp_set4 < 6)
				you_set4++;
			else
				you_set5++;
		}
		else {
			if (opp_set1 < 6 && you_set1 < 6)
				opp_set1++;
			else if (opp_set2 < 6 && you_set2 < 6)
				opp_set2++;
			else if (opp_set3 < 6 && you_set3 < 6)
				opp_set3++;
			else if (opp_set4 < 6 && you_set4 < 6)
				opp_set4++;
			else
				opp_set5++;
		}
	}

	private void updateDisplay() {
		TextView y = (TextView)findViewById(R.id.you_game);
		y.setText(Integer.toString(you_game_score));
		TextView o = (TextView)findViewById(R.id.opp_game);
		o.setText(Integer.toString(opp_game_score));
		TextView y1 = (TextView)findViewById(R.id.you_set1);
		y1.setText(Integer.toString(you_set1));
		TextView y2 = (TextView)findViewById(R.id.you_set2);
		y2.setText(Integer.toString(you_set2));
		TextView y3 = (TextView)findViewById(R.id.you_set3);
		y3.setText(Integer.toString(you_set3));
		TextView y4 = (TextView)findViewById(R.id.you_set4);
		y4.setText(Integer.toString(you_set4));
		TextView y5 = (TextView)findViewById(R.id.you_set5);
		y5.setText(Integer.toString(you_set5));
		TextView o1 = (TextView)findViewById(R.id.opp_set1);
		o1.setText(Integer.toString(opp_set1));
		TextView o2 = (TextView)findViewById(R.id.opp_set2);
		o2.setText(Integer.toString(opp_set2));
		TextView o3 = (TextView)findViewById(R.id.opp_set3);
		o3.setText(Integer.toString(opp_set3));
		TextView o4 = (TextView)findViewById(R.id.opp_set4);
		o4.setText(Integer.toString(opp_set4));
		TextView o5 = (TextView)findViewById(R.id.opp_set5);
		o5.setText(Integer.toString(opp_set5));
	}
	
}
