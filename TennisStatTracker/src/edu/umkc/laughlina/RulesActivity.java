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
       
        scrollText.append(" --- HOW TO PLAY --- \n");
        getServingText(scrollText);
        getRallyingText(scrollText);
        getFaultsText(scrollText);
        getScoringText(scrollText);
        getEquipmentText(scrollText);
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
	
	private void getServingText(TextView text) {
		text.append(" --- SERVING ---\n");
		text.append("\tServing in tennis is how you start each point. " +
				"It is one of the most technical parts of the game and can " +
				"generally take a lot of practice to master. Each player takes turns " +
				"serving the ball to each other, switching after each game. The server " +
				"must stand behind the baseline on his/her side of the court between " +
				"the center line and the sideline. The ball must be tossed up and then " +
				"hit diagonally across the court to the service box and must bounce " +
				"before the receiving player can hit the ball. After each serve, the " +
				"server must switch between the left and right side of the court. " +
				"Later, when discussing faults, there will be more information on what " +
				"is considered a legal serve and what is a fault in serves.");
	}
	
	private void getRallyingText(TextView text) {
		text.append("\n\n --- RALLYING ---\n");
		text.append("\tA Rally is simply the ball traveling back and forth over the " +
				"net between opponents while the ball is still in legal play. The " +
				"ball stays in legal play as long as it is returned everytime by the " +
				"receiving player and does not hit the net, double bounce, or go out " +
				"of bounds. The player can not touch the net when hitting the ball, or " +
				"the point is done and the other wins the point. Also, if the ball hits " +
				"the net and proceeds to go over the net, it is still in legal play. " +
				"The rectangle areas on the side of the court are for doubles play. " +
				"Anything hit landing in these boxes is out of bounds in singles, but " +
				"is considered in bounds in doubles. Anything further off the court " + 
				"is out of bounds in both singles and doubles. A ball hitting the " +
				"player anywhere on the body and not on the hand touching the raquet " +
				"grip results in the end of the point, giving the other the point.");
	}
	
	private void getFaultsText(TextView text) {
		text.append("\n\n --- FAULTS ---\n");
		text.append("\tThere are multiple ways to fault in Tennis. To start, serving " +
				"has multiple different ways to fault. By stepping on the baseline " +
				"or over as the server, not landing in the diagonal direction service " +
				"box, and hitting the net and the ball not landing in the service box." +
				"If the ball hits the net and then lands in the correct servic box, it " +
				"is called a 'let' and the serve is redone and is not a fault. You " +
				"are only allowed one fault per serve. If there are two faults, it is " +
				"called a 'double fault' and the point is over and the receiving person " +
				"wins that individual point.");
	}
	
	private void getScoringText(TextView text) {
		text.append("\n\n --- SCORING ---\n");
		text.append("\tScoring in tennis is very different from your standard sport " +
				"and I suggest seeing and playing with the scoreboard to understand " +
				"how scoring is kept. The score goes love (0), 15, 30, 40, and then " +
				"deuce if both players have 40, and there is an advantage point, then " +
				"game. Once a deuce has occured, someone must win at least two points " +
				"in a row to win the game. This is the scoring for an individual game. " +
				"\n\tThe next part in tennis are sets. The general games are either " +
				"best of three or best of five. To win a set, you must be the first to " +
				"six games and ahead by two. If both players are at five, then the " +
				"first to seven wins. If both are at six, a tie breaker will commence." +
				"\n\tAfter each odd number of games has been played (1,3,5,7, etc) the " +
				"players will switch sides on the court.");
	}
	
	private void getEquipmentText(TextView text) {
		text.append("\n\n --- EQUIPMENT ---\n");
		text.append("\tThe only equipment needed is two to four players, a raquet for " +
				"each player, and some tennis balls. Of course, you need a court and " +
				"net to play, but there are four different kinds of courts. Grass, " + 
				"clay, hardcourt (asphalt), and synthetic clay. Each has a different " +
				"style, speed, and difficulty. The ball bounces less for instance, on " +
				"a grass court.");
	}
}
