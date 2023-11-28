package com.cs2340.armadillo.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.cs2340.armadillo.Models.Leaderboard;
import com.cs2340.armadillo.Models.Player;
import com.cs2340.armadillo.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class EndActivity extends AppCompatActivity {
    private static long currentScore;
    private double orgHealth;
    private long fScore;
    Player player;
    boolean win;
    String winText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        player = ConfigActivity.getPlayer();
        TextView boardName = (TextView) findViewById(R.id.name_text);
        TextView boardScore = (TextView) findViewById(R.id.score_text);

        TextView currName = (TextView) findViewById(R.id.current_player);
        TextView currScore = (TextView) findViewById(R.id.current_score);
        TextView boardTime = (TextView) findViewById(R.id.time_text);
        TextView head = (TextView) findViewById(R.id.leaderboard_head);

        Button restart = (Button) findViewById(R.id.reset_button);

        switch(player.getDifficulty()) {
            case ("Hard"):
                orgHealth = 10;
                break;
            case ("Medium"):
                orgHealth = 15;
                break;
            case("Easy"):
                orgHealth  = 20;
                break;
        }

        double healthScore = (player.getHP() / orgHealth);
        currentScore = (long) getIntent().getLongExtra("currentScore", 0);
        fScore = (long) (currentScore * healthScore);

        Leaderboard leaderboard = Leaderboard.getLeaderboard();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String strDate = dateFormat.format(calendar.getTime());

        leaderboard.addScore(player.getName(), fScore, strDate);

        String[] names = leaderboard.getNames();
        long[] scores = leaderboard.getScores();
        String[] times = leaderboard.getDates();

        String nameCol = "";
        String scoreCol = "";
        String timeCol = "";
        for (String name: names) {
            nameCol = nameCol + name + "\n\n";
        }
        for (double score: scores) {
            scoreCol = scoreCol + score + "\n\n";
        }
        for (String time: times) {
            timeCol = timeCol + time +"\n\n";
        }

        boardName.setText(nameCol);
        boardScore.setText(scoreCol);
        boardTime.setText(timeCol);

        currName.setText(player.getName());
        currScore.setText("" + currentScore);

        win = getIntent().getBooleanExtra("winorlose", false);
        if (win) {
            player.setWinText("You Win!");
        } else {
            player.setWinText("You Lose.");
        }
        head.setText(player.getWinText());

        restart.setOnClickListener(v -> {
            Intent res = new Intent(EndActivity.this, MainActivity.class);
            startActivity(res);
            finish();
        });
    }

    public static long getCurrentScore() {
        return currentScore;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}