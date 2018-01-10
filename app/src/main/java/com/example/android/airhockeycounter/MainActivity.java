package com.example.android.airhockeycounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scorePlayerA = 0;
    int scorePlayerB = 0;
    int overallScoreViewA = 0;
    int overallScoreViewB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * increase the point by 1 for Player A
     */
    public void goal_a(View v) {
        scorePlayerA = scorePlayerA + 1;
        displayForPlayerA(scorePlayerA);

        /**
         * when points of Player A reaches 8, one score is added to Player A and players' score resets
         */

        if (scorePlayerA == 8) {
            overallScoreViewA = overallScoreViewA + 1;
            scorePlayerA = 0;
            scorePlayerB = 0;
            displayForOverallPlayerA(overallScoreViewA);
            displayForPlayerA(scorePlayerA);
            displayForPlayerB(scorePlayerB);

            if (overallScoreViewA > overallScoreViewB) {
                String winner = "Player\n*A*\nis\nwinning";
                displayMessage(winner);
            }
            if (overallScoreViewA == overallScoreViewB) {
                String winner = "**Even**\nNo one\nis\nwinning";
                displayMessage(winner);
            }
        }
    }

    /**
     *
     */

    public void foul_a(View v) {
        scorePlayerA = scorePlayerA + 0;
        displayForPlayerA(scorePlayerA);
    }

    /**
     * Displays the given score for Player A.
     */

    public void displayForPlayerA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_a);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * increase the point by 1 for Player B
     */

    public void goal_b(View v) {
        scorePlayerB = scorePlayerB + 1;
        displayForPlayerB(scorePlayerB);
        /**
         * when points of Player B reaches 8, one score is added to Player B and players' score resets
         */
        if (scorePlayerB == 8) {
            overallScoreViewB = overallScoreViewB + 1;
            scorePlayerB = 0;
            scorePlayerA = 0;
            displayForOverallPlayerB(overallScoreViewB);
            displayForPlayerB(scorePlayerB);
            displayForPlayerA(scorePlayerA);

            if (overallScoreViewB > overallScoreViewA) {
                String winner = "Player\n*B*\nis\nwinning";
                displayMessage(winner);
            }
            if (overallScoreViewB == overallScoreViewA) {
                String winner = "**Even**\nNo one\nis\nwinning";
                displayMessage(winner);
            }
        }
    }

    /**
     *
     */
    public void foul_b(View v) {
        scorePlayerB = scorePlayerB + 0;
        displayForPlayerB(scorePlayerB);
    }

    /**
     * Displays the given score for Player B.
     */

    public void displayForPlayerB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_b);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * resets the game to restart
     */

    public void reset(View v) {
        scorePlayerA = 0;
        scorePlayerB = 0;
        overallScoreViewA = 0;
        overallScoreViewB = 0;
        displayForPlayerB(scorePlayerB);
        displayForPlayerA(scorePlayerA);
        displayForOverallPlayerA(overallScoreViewA);
        displayForOverallPlayerB(overallScoreViewB);
        String winner = "";
        displayMessage(winner);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.winner_player);
        priceTextView.setText(message);

    }


    /**
     * display given overall score for Player A
     */

    public void displayForOverallPlayerA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.overall_score_a);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * display given overall score for Player B
     */
    public void displayForOverallPlayerB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.overall_score_b);
        scoreView.setText(String.valueOf(score));
    }
}

