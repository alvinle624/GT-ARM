package com.cs2340.armadillo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

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
        TextView boardTime = (TextView) findViewById(R.id.time_text);

        Button restart = (Button) findViewById(R.id.reset_button);
        restart.setOnClickListener(v -> {
            Intent end = new Intent(EndActivity.this, MainActivity.class);
            startActivity(end);
            finish();
        });


        Random rand = new Random();
        int random = rand.nextInt(100);
        Leaderboard leaderboard = Leaderboard.getLeaderboard();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String strDate = dateFormat.format(calendar.getTime());

        //TODO Change format to fit changing score and player
        leaderboard.addScore("New Player", 0, strDate);

        String[] names = leaderboard.getNames();
        int[] scores = leaderboard.getScores();
        String[] times = leaderboard.getDates();

        String nameCol = "";
        String scoreCol = "";
        String timeCol = "";
        for (String name: names) {
            nameCol = nameCol + name + "\n\n";
        }
        for (int score: scores) {
            scoreCol = scoreCol + score + "\n\n";
        }
        for (String time: times) {
            timeCol = timeCol + time +"\n\n";
        }

        boardName.setText(nameCol);
        boardScore.setText(scoreCol);
        boardTime.setText(timeCol);
        currName.setText("PLayer");
        currScore.setText("0");
    }
}