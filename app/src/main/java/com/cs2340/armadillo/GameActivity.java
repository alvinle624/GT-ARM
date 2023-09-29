package com.cs2340.armadillo;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private Button endBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Player player = ConfigActivity.getPlayer();
        TextView playerHp = (TextView) findViewById(R.id.player_hp);
        TextView playerName = (TextView) findViewById(R.id.player_name);
        TextView difficulty = (TextView) findViewById(R.id.difficulty);
        playerHp.setText("" + player.getHP());
        playerName.setText(player.getName());
        difficulty.setText(player.getDifficulty());
        endBtn = (Button) findViewById(R.id.end_button);
        endBtn.setOnClickListener(v -> {
            Intent end = new Intent(GameActivity.this, EndActivity.class);
            startActivity(end);
            finish();
        });
    }
}