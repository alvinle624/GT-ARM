package com.cs2340.armadillo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        TextView boardName = (TextView) findViewById(R.id.name_text);
        TextView boardScore = (TextView) findViewById(R.id.score_text);

        Leaderboard leaderboard = Leaderboard.getLeaderboard();
        String[] names = leaderboard.getNames();
        int[] scores = leaderboard.getScores();

        String nameCol = "";
        String scoreCol = "";
        for (String name: names) {
            nameCol = nameCol + name + "\n\n";
        }
        for (int score: scores) {
            scoreCol = scoreCol + score + "\n\n";
        }

        boardName.setText(nameCol);
        boardScore.setText(scoreCol);
    }
}