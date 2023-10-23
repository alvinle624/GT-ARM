package com.cs2340.armadillo.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.cs2340.armadillo.Models.Action;
import com.cs2340.armadillo.Models.Player;
import com.cs2340.armadillo.R;

public class GameActivity2 extends AppCompatActivity {
    private Button endBtn;
    private Button nxtBtn;
    private CountDownTimer countDown;
    private long currentScore;
    Action action;
    ConstraintLayout gameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
        Player player = ConfigActivity.getPlayer();
        player.setXCoor(500);
        player.setYCoor(500);
        player.setX(500);
        player.setY(500);

        TextView playerHp = (TextView) findViewById(R.id.player_hp2);
        TextView playerName = (TextView) findViewById(R.id.player_name2);
        TextView difficulty = (TextView) findViewById(R.id.difficulty2);
        TextView score = (TextView) findViewById(R.id.score2);

        ImageButton up = findViewById(R.id.upButton2);
        ImageButton right = findViewById(R.id.rightButton2);
        ImageButton down = findViewById(R.id.downButton2);
        ImageButton left = findViewById(R.id.leftButton2);
        action = new Action(up, right, down, left, player);
        action.setListeners();

        playerHp.setText("PlayerHP: " + player.getHP());
        playerName.setText(player.getName());
        difficulty.setText("Difficulty: " + player.getDifficulty());

        gameLayout = findViewById(R.id.game_screen2);
        gameLayout.addView(player);
        gameLayout.getViewById(R.id.player_hp2);


        countDown = null;
        startScoreTimer(score, player);

        nxtBtn.setOnClickListener(v -> {
            gameLayout.removeAllViews();
            Intent next = new Intent(GameActivity2.this, GameActivity3.class);
            next.putExtra("currentScore", currentScore);
            startActivity(next);
        });
    }


    private void startScoreTimer(TextView tView, Player p) {
        currentScore = (long) getIntent().getLongExtra("currentScore", 0);
        countDown = new CountDownTimer(currentScore, 1000) {
            @Override
            public void onTick(long untilFinish) {
                currentScore = untilFinish;
                updateScore(tView, currentScore);

                if (p.getY() > 2250 && p.getX() < 760) {
                    gameLayout.removeAllViews();
                    Intent next = new Intent(GameActivity2.this, GameActivity3.class);
                    next.putExtra("currentScore", currentScore);
                    startActivity(next);
                    countDown.cancel();
                    countDown = null;
                    action.stopButton();
                    finish();
                }
            }
            @Override
            public void onFinish() {
                currentScore = 0;
                countDown.cancel();
                countDown = null;
                updateScore(tView, currentScore);
            }
        }.start();
    }

    private void updateScore(TextView text, long num) {
        int newScore = (int) num;
        text.setText("Score: " + newScore);
    }
}
