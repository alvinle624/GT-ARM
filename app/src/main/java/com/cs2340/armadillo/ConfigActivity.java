package com.cs2340.armadillo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.content.Intent;
import android.widget.EditText;
import android.text.TextUtils;
import android.view.View;

public class ConfigActivity extends AppCompatActivity {

    private static Player player;
    private EditText playerName;
    private RadioGroup difficultyRadioGroup;
    private RadioGroup spriteRadioGroup;

    public ConfigActivity() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_configuration_screen);
        player = new Player();
        playerName = findViewById(R.id.nameInput);
        difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup);
        spriteRadioGroup = findViewById(R.id.spriteGroup);
        Button startButton = findViewById(R.id.startButton);
//        if (TextUtils.isEmpty((playerName.getText().toString().trim()))) {
//            startButton.setVisibility(View.GONE);
//        } else {
//            startButton.setVisibility(View.VISIBLE);
//        }

        startButton.setOnClickListener(v -> {
            player.setName(playerName.getText().toString());
            int difficultyRadioId = difficultyRadioGroup.getCheckedRadioButtonId();
            if (difficultyRadioId == R.id.mediumButton) {
                player.setDifficulty("Medium");
                player.setHP(4);
            } else if (difficultyRadioId == R.id.hardButton) {
                player.setDifficulty("Hard");
                player.setHP(3);
            } else {
                player.setDifficulty("Easy");
                player.setHP(5);
            }
            int spriteRadioId = spriteRadioGroup.getCheckedRadioButtonId();
            if (spriteRadioId == R.id.sprite1) {
                player.setSprite(1);
            } else if (spriteRadioId == R.id.sprite1) {
                player.setSprite(2);
            } else {
                player.setSprite(3);
            }
            Intent gameScreen = new Intent(ConfigActivity.this, GameActivity.class);
            startActivity(gameScreen);
        });
    }
    public static Player getPlayer() {
        return player;
    }
}
