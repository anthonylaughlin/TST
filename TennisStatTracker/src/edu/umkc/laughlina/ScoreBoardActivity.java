package edu.umkc.laughlina;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;

public class ScoreBoardActivity extends Activity implements OnClickListener {
	
	private Match match = new Match();
	private int matchState = 0;
	private EditText result;
	
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
        View enterButton = findViewById(R.id.enter_button);
        loseButton.setOnClickListener(this);
        result = (EditText)findViewById(R.id.editText);
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
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.score_board, menu);
	    return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		case R.id.reset:
			match.resetScores();
			Context context = getApplicationContext();
			CharSequence text = "Scores reset...";
			int duration = Toast.LENGTH_SHORT;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			updateDisplay();
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.win_button:
			matchState = match.pointWon();
			winOrLose(matchState);
			updateDisplay();
			break;
		case R.id.lose_button:
			matchState = match.pointLost();
			updateDisplay();
			winOrLose(matchState);
			break;
		case R.id.enter_button:
			try {
				final EditText userInput = (EditText) findViewById(R.id.editText);
				result.setText(userInput.getText());
				String numSets = result.getText().toString();
				match.setNumSets(numSets);
			} catch (InvalidNumberOfSets e) {
				e.printStackTrace();
			}
			break;
		}
	}
	
	private void winOrLose(int state) {
		if (state == 1) {
			AlertDialog.Builder wonMatch = new AlertDialog.Builder(this);
			wonMatch = wonMatch.setMessage("You won the Match!");
			wonMatch = wonMatch.setCancelable(false).setPositiveButton("Sweet!", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							match.resetScores();
							updateDisplay();
						}
					});
			wonMatch.show();
		}
		if (state == 2) {
			AlertDialog.Builder lostMatch = new AlertDialog.Builder(this);
			lostMatch = lostMatch.setMessage("You lost the Match!");
			lostMatch = lostMatch.setCancelable(false).setPositiveButton("Darn!", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							match.resetScores();
							updateDisplay();
						}
					});
			lostMatch.show();
		}
	}

	private void updateDisplay() {
		TextView y = (TextView)findViewById(R.id.you_game);
		y.setText(Integer.toString(match.getMyGameScore()));
		TextView o = (TextView)findViewById(R.id.opp_game);
		o.setText(Integer.toString(match.getOppGameScore()));
		TextView y1 = (TextView)findViewById(R.id.you_set1);
		y1.setText(Integer.toString(match.getMySetScore(1)));
		TextView y2 = (TextView)findViewById(R.id.you_set2);
		y2.setText(Integer.toString(match.getMySetScore(2)));
		TextView y3 = (TextView)findViewById(R.id.you_set3);
		y3.setText(Integer.toString(match.getMySetScore(3)));
		TextView y4 = (TextView)findViewById(R.id.you_set4);
		y4.setText(Integer.toString(match.getMySetScore(4)));
		TextView y5 = (TextView)findViewById(R.id.you_set5);
		y5.setText(Integer.toString(match.getMySetScore(5)));
		TextView o1 = (TextView)findViewById(R.id.opp_set1);
		o1.setText(Integer.toString(match.getOppSetScore(1)));
		TextView o2 = (TextView)findViewById(R.id.opp_set2);
		o2.setText(Integer.toString(match.getOppSetScore(2)));
		TextView o3 = (TextView)findViewById(R.id.opp_set3);
		o3.setText(Integer.toString(match.getOppSetScore(3)));
		TextView o4 = (TextView)findViewById(R.id.opp_set4);
		o4.setText(Integer.toString(match.getOppSetScore(4)));
		TextView o5 = (TextView)findViewById(R.id.opp_set5);
		o5.setText(Integer.toString(match.getOppSetScore(5)));
	}
}
