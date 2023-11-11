package com.cs2340.armadillo.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.cs2340.armadillo.Models.*;
import com.cs2340.armadillo.R;

import java.util.ArrayList;

public class GameActivity3 extends AppCompatActivity {
    private Button endBtn;
    private Action action;
    private GridView gridView;
    private Enemies allEnemies;
    private CountDownTimer countDown;
    private long currentScore;

    ConstraintLayout gameLayout;

    CheckCollision checkCollision;
    Player player;
    int hpLoss;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);
        
        // sets tiled map to tile 3
        gridView = (GridView) findViewById(R.id.tile_map);
        gridView.setAdapter(new Map(this, 2));
        player = ConfigActivity.getPlayer();

        switch(player.getDifficulty()) {
            case ("Hard"):
                hpLoss = 3;
                break;
            case ("Medium"):
                hpLoss = 2;
                break;
            case("Easy"):
                hpLoss  = 1;
                break;
        }

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
        allEnemies = new Enemies();

        action = new Action(up, right, down, left, player, allEnemies);
        action.setListeners();

        playerHp.setText("PlayerHP: " + player.getHP());
        playerName.setText(player.getName());
        difficulty.setText("Difficulty: " + player.getDifficulty());

        gameLayout = findViewById(R.id.game_screen3);
        gameLayout.addView(player);

        countDown = null;
        startScoreTimer(score, player);
        handler.postDelayed(collision, 10);
    }

    Handler handler = new Handler(Looper.getMainLooper());
    Runnable collision = new Runnable() {
        @Override
        public void run() {
            int delay = 100;
            for (int i = 0; i < allEnemies.getEnemyList().size(); i++) {
                EnemyView enemy = allEnemies.findE(i);
                if (enemy != null) {
                    checkCollision = new CheckCollision(enemy, player);
                    if (checkCollision.checkCollide()) {
                        TextView playerHP = (TextView) findViewById(R.id.player_hp);
                        player.setHP(player.getHP() - hpLoss);
                        playerHP.setText("PlayerHP: " + player.getHP());
                        delay = 1200;
                    }
                }
            }
            handler.postDelayed(this, delay);
        }
    };


    private void startScoreTimer(TextView tView, Player p) {
        currentScore = (long) getIntent().getLongExtra("currentScore", 0);
        countDown = new CountDownTimer(currentScore, 1000) {
            @Override
            public void onTick(long untilFinish) {
                currentScore = untilFinish;
                updateScore(tView, currentScore);
                boolean winner = true;

                if ((p.getY() > 2200 && p.getX() < 800) || (p.getHP() <= 0)) {
                    gameLayout.removeAllViews();
                    Intent next = new Intent(GameActivity3.this, EndActivity.class);
                    if (p.getHP() <= 0) {
                        winner = false;
                        currentScore = 0;
                    }
                    next.putExtra("currentScore", currentScore);
                    next.putExtra("winorlose", winner);
                    startActivity(next);
                    countDown.cancel();
                    countDown = null;
                    action.stopButton();
                    handler.removeCallbacks(collision);
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
