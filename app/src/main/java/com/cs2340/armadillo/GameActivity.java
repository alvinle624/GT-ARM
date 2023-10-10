package com.cs2340.armadillo;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GameActivity extends AppCompatActivity {

    private Button endBtn;

    ConstraintLayout gameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Player player = ConfigActivity.getPlayer();
        TextView playerHp = (TextView) findViewById(R.id.player_hp);
        TextView playerName = (TextView) findViewById(R.id.player_name);
        TextView difficulty = (TextView) findViewById(R.id.difficulty);
        playerHp.setText("PlayerHP: " + player.getHP());
        playerName.setText(player.getName());
        difficulty.setText("Difficulty: " + player.getDifficulty());
        gameLayout = findViewById(R.id.game_screen);
        gameLayout.addView(player);
        endBtn = (Button) findViewById(R.id.end_button);
        endBtn.setOnClickListener(v -> {
            Intent end = new Intent(GameActivity.this, EndActivity.class);
            startActivity(end);
            finish();
        });
    }
}