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

public class GameActivity2 extends AppCompatActivity {
    private Button endBtn;
    private Button nxtBtn;
    private CountDownTimer countDown;
    private long currentScore;

    ConstraintLayout gameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
        Player player = ConfigActivity.getPlayer();

        TextView playerHp = (TextView) findViewById(R.id.player_hp2);
        TextView playerName = (TextView) findViewById(R.id.player_name2);
        TextView difficulty = (TextView) findViewById(R.id.difficulty2);
        TextView score = (TextView) findViewById(R.id.score2);

        playerHp.setText("PlayerHP: " + player.getHP());
        playerName.setText(player.getName());
        difficulty.setText("Difficulty: " + player.getDifficulty());

        gameLayout = findViewById(R.id.game_screen2);
        gameLayout.addView(player);

        endBtn = (Button) findViewById(R.id.end_button2);
        nxtBtn = (Button) findViewById(R.id.next_button2);

        startScoreTimer(score);

        nxtBtn.setOnClickListener(v -> {
            gameLayout.removeAllViews();
            Intent next = new Intent(GameActivity2.this, GameActivity3.class);
            next.putExtra("currentScore", currentScore);
            startActivity(next);
        });

        endBtn.setOnClickListener(v -> {
            Intent end = new Intent(GameActivity2.this, EndActivity.class);
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
