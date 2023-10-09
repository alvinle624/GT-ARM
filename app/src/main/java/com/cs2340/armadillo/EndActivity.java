package com.cs2340.armadillo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        Player player;
        TextView boardName = (TextView) findViewById(R.id.name_text);
        TextView boardScore = (TextView) findViewById(R.id.score_text);
        TextView currName = (TextView) findViewById(R.id.current_player);
        TextView currScore = (TextView) findViewById(R.id.current_score);
        Button restart = (Button) findViewById(R.id.reset_button);
        restart.setOnClickListener(v -> {
            Intent end = new Intent(EndActivity.this, MainActivity.class);
            startActivity(end);
            finish();
        });

        Leaderboard leaderboard = Leaderboard.getLeaderboard();
        leaderboard.addScore("New Player", 0);

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
        currName.setText("PLayer");
        currScore.setText("0");
    }
}