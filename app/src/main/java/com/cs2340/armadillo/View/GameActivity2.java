package com.cs2340.armadillo.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.cs2340.armadillo.Models.*;
import com.cs2340.armadillo.R;

import java.util.ArrayList;

public class GameActivity2 extends AppCompatActivity {
    private Button endBtn;
    private Button nxtBtn;
    private Action action;
    private Attack attack;

    private GridView gridView;
    private Enemies allEnemies;
    private CountDownTimer countDown;
    private long currentScore;
    ConstraintLayout gameLayout;
    CheckCollision checkCollision;
    Player player;
    int hpLoss;
    PowerUpView speedBug;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
        // sets tiled map to map 2
        gridView = (GridView) findViewById(R.id.tile_map);
        gridView.setAdapter(new Map(this, 1));

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

        TextView playerHp = (TextView) findViewById(R.id.player_hp2);
        TextView playerName = (TextView) findViewById(R.id.player_name2);
        TextView difficulty = (TextView) findViewById(R.id.difficulty2);
        TextView score = (TextView) findViewById(R.id.score2);
        ImageView claw = findViewById(R.id.clawSwipe2);
        Button attackButton = findViewById(R.id.attackButton2);

        ImageButton up = findViewById(R.id.upButton2);
        ImageButton right = findViewById(R.id.rightButton2);
        ImageButton down = findViewById(R.id.downButton2);
        ImageButton left = findViewById(R.id.leftButton2);
        allEnemies = new Enemies();

        Enemy bear = new Bear();
        Enemy bear2 = new Bear();
        EnemyView bearView = new EnemyView(this, bear, 800, 700);
        EnemyView bearView2 = new EnemyView(this, bear2, 700, 700);
        allEnemies.addEnemy(bearView2);
        allEnemies.addEnemy(bearView);

        speedBug = new PowerUpView(this, 700, 700, "speed");

        action = new Action(up, right, down, left, player, allEnemies);
        action.setListeners();
        attack = new Attack(player, attackButton, allEnemies, claw);
        attack.attackListener();


        playerHp.setText("PlayerHP: " + player.getHP());
        playerName.setText(player.getName());
        difficulty.setText("Difficulty: " + player.getDifficulty());

        gameLayout = findViewById(R.id.game_screen2);
        gameLayout.addView(player);
        gameLayout.getViewById(R.id.player_hp2);
        gameLayout.addView(bearView);
        gameLayout.addView(bearView2);
        gameLayout.addView(speedBug);


        countDown = null;
        startScoreTimer(score, player);
        handler.postDelayed(collision, 10);
    }

    Handler handler = new Handler(Looper.getMainLooper());
    Runnable collision = new Runnable() {
        @Override
        public void run() {
            int delay = 100;
            if (speedBug.checkCollision(player)) {
                speedBug.setCollected(true);
                speedBug.setVisibility(View.INVISIBLE);
                speedBug.executePowerUp(player, allEnemies);
            }
            for (int i = 0; i < allEnemies.getEnemyList().size(); i++) {
                EnemyView enemy = allEnemies.findE(i);
                if (enemy != null) {
                    checkCollision = new CheckCollision(enemy, player);
                    if (checkCollision.checkCollide()) {
                        TextView playerHP = (TextView) findViewById(R.id.player_hp2);
                        player.setHP(player.getHP() - hpLoss);
                        playerHP.setText("PlayerHP: " + player.getHP());
                        delay = 1200;
                    }
                }
            }
            handler.postDelayed(this, delay);
        }
    };

    // starts timer
    private void startScoreTimer(TextView tView, Player p) {
        currentScore = (long) getIntent().getLongExtra("currentScore", 0);
        countDown = new CountDownTimer(currentScore, 1000) {
            @Override
            public void onTick(long untilFinish) {
                currentScore = untilFinish;
                updateScore(tView, currentScore);

                if ((p.getY() > 2200 && p.getX() < 800) || (p.getHP() <= 0)) {
                    gameLayout.removeAllViews();
                    Intent next = new Intent(GameActivity2.this, GameActivity3.class);

                    if (p.getHP() <= 0) {
                        next = new Intent(GameActivity2.this, EndActivity.class);
                        currentScore = 0;
                    }

                    next.putExtra("currentScore", currentScore);
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

    // method to update score
    private void updateScore(TextView text, long num) {
        int newScore = (int) num;
        text.setText("Score: " + newScore);
    }
}
