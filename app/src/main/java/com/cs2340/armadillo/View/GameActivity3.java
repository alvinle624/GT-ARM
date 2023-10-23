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

public class GameActivity3 extends AppCompatActivity {
    private Button endBtn;
    private CountDownTimer countDown;
    private long currentScore;

    Action action;
    ConstraintLayout gameLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);
        Player player = ConfigActivity.getPlayer();
        player.setXCoor(500);
        player.setYCoor(500);
        player.setX(500);
        player.setY(500);


        TextView playerHp = (TextView) findViewById(R.id.player_hp3);
        TextView playerName = (TextView) findViewById(R.id.player_name3);
        TextView difficulty = (TextView) findViewById(R.id.difficulty3);
        TextView score = (TextView) findViewById(R.id.score3);

        ImageButton up = findViewById(R.id.upButton3);
        ImageButton right = findViewById(R.id.rightButton3);
        ImageButton down = findViewById(R.id.downButton3);
        ImageButton left = findViewById(R.id.leftButton3);
        action = new Action(up, right, down, left, player);
        action.setListeners();

        playerHp.setText("PlayerHP: " + player.getHP());
        playerName.setText(player.getName());
        difficulty.setText("Difficulty: " + player.getDifficulty());

        gameLayout = findViewById(R.id.game_screen3);
        gameLayout.addView(player);

        countDown = null;
        startScoreTimer(score, player);
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
                    Intent next = new Intent(GameActivity3.this, EndActivity.class);
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
