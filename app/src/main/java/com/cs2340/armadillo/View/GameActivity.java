package com.cs2340.armadillo.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.cs2340.armadillo.Models.Action;
import com.cs2340.armadillo.Models.Player;
import com.cs2340.armadillo.R;

public class GameActivity extends AppCompatActivity {

    private Button endBtn;
    private Button nxtBtn;
    private static final long startScore = 300000;
    private CountDownTimer countDown;
    private long currentScore;
    ConstraintLayout gameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Player player = ConfigActivity.getPlayer();

        TextView playerHp = (TextView) findViewById(R.id.player_hp);
        TextView playerName = (TextView) findViewById(R.id.player_name);
        TextView difficulty = (TextView) findViewById(R.id.difficulty);
        TextView score = (TextView) findViewById(R.id.score);

        playerHp.setText("PlayerHP: " + player.getHP());
        playerName.setText(player.getName());

        difficulty.setText("Difficulty: " + player.getDifficulty());

        gameLayout = findViewById(R.id.game_screen);
        ImageView image = player;
        gameLayout.addView(player);
        nxtBtn = (Button) findViewById(R.id.next_button);

        currentScore = startScore;
        countDown = null;
        startScoreTimer(score);

        ImageButton up = findViewById(R.id.upButton);
        ImageButton right = findViewById(R.id.rightButton);
        ImageButton down = findViewById(R.id.downButton);
        ImageButton left = findViewById(R.id.leftButton);
        Action action = new Action(up, right, down, left, player);
        action.setListeners();

        nxtBtn.setOnClickListener(v -> {
            gameLayout.removeAllViews();
            Intent next = new Intent(GameActivity.this, GameActivity2.class);
            next.putExtra("currentScore", currentScore);
            startActivity(next);
            finish();
        });
    }

    public void startScoreTimer(TextView tView) {
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

    public void updateScore(TextView text, long num) {
        int newScore = (int) num;
        text.setText("Score: " + newScore);
    }
}