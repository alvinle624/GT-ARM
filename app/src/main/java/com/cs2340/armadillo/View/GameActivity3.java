package com.cs2340.armadillo.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

import com.cs2340.armadillo.Models.Player;
import com.cs2340.armadillo.R;

public class GameActivity3 extends AppCompatActivity {
    private Button endBtn;
    private CountDownTimer countDown;
    private long currentScore;

    ConstraintLayout gameLayout;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);
        Player player = ConfigActivity.getPlayer();

        TextView playerHp = (TextView) findViewById(R.id.player_hp3);
        TextView playerName = (TextView) findViewById(R.id.player_name3);
        TextView difficulty = (TextView) findViewById(R.id.difficulty3);
        TextView score = (TextView) findViewById(R.id.score3);

        playerHp.setText("PlayerHP: " + player.getHP());
        playerName.setText(player.getName());
        difficulty.setText("Difficulty: " + player.getDifficulty());

        gameLayout = findViewById(R.id.game_screen3);
        gameLayout.addView(player);
        endBtn = (Button) findViewById(R.id.end_button3);

        countDown = null;
        startScoreTimer(score);

        endBtn.setOnClickListener(v -> {
            gameLayout.removeAllViews();
            Intent end = new Intent(GameActivity3.this, EndActivity.class);
            end.putExtra("currentScore", currentScore);
            startActivity(end);
            finish();
        });
    }

    private void startScoreTimer(TextView tView) {
        currentScore = (long) getIntent().getLongExtra("currentScore", 0);

        countDown = new CountDownTimer(currentScore, 1000) {
            @Override
            public void onTick(long untilFinish) {
                currentScore = untilFinish;
                updateScore(tView, currentScore);
            }

            @Override
            public void onFinish() {
                currentScore = 0;
                updateScore(tView, currentScore);
            }
        }.start();
    }

    private void updateScore(TextView text, long num) {
        int newScore = (int) num;
        text.setText("Score: " + newScore);
    }
}
