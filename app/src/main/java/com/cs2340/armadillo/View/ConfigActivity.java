package com.cs2340.armadillo.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.RadioGroup;
import android.content.Intent;
import android.widget.EditText;

import com.cs2340.armadillo.Models.Player;
import com.cs2340.armadillo.R;

public class ConfigActivity extends AppCompatActivity {

    private Button startButton;

    private float playerX, playerY;
    private static Player player;
    private EditText playerName;
    private RadioGroup difficultyRadioGroup;
    private RadioGroup spriteRadioGroup;

    private int playerSprite;
    private int playerHP;

    TextWatcher textwatcher = new TextWatcher(){
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int before, int count) {
            // change value of player name
            playerName = findViewById(R.id.nameInput);
            String playerNameVal = playerName.getText().toString();
            System.out.println("Player nameInput onChange" + playerName.getText().toString());
        }

        @Override
        public void afterTextChanged(Editable editable) {
            startButton = findViewById(R.id.start_button);
            String tempPlayerName = editable.toString();
            if (tempPlayerName.isEmpty()){
                startButton.setEnabled(false);
            } else  {
                startButton.setEnabled(true);
            }
        }
    };
    public ConfigActivity() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_configuration_screen);
        playerX = (float) 500;
        playerY = (float) 500;
        player = new Player(this, playerX, playerY, playerHP);
        playerName = findViewById(R.id.nameInput);
        difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup);
        spriteRadioGroup = findViewById(R.id.spriteGroup);
        startButton = findViewById(R.id.start_button);
        startButton.setEnabled(false);
        playerName.addTextChangedListener(textwatcher);

        startButton.setOnClickListener(v -> {
            player.setName(playerName.getText().toString());
            int difficultyRadioId = difficultyRadioGroup.getCheckedRadioButtonId();

            if (difficultyRadioId == R.id.mediumButton) {
                player.setDifficulty("Medium");
                player.setHP(15);
            } else if (difficultyRadioId == R.id.hardButton) {
                player.setDifficulty("Hard");
                player.setHP(10);
            } else {
                player.setDifficulty("Easy");
                player.setHP(20);
            }


            int spriteRadioId = spriteRadioGroup.getCheckedRadioButtonId();

            if (spriteRadioId == R.id.sprite1) {
                player.setSprite(1);
            } else if (spriteRadioId == R.id.sprite2) {
                player.setSprite(2);
            } else if (spriteRadioId == R.id.sprite3){
                player.setSprite(3);
            }

            Intent gameScreen = new Intent(ConfigActivity.this, GameActivity.class);
            gameScreen.putExtra("difficulty", player.getDifficulty());
            startActivity(gameScreen);
        });
    }
    public static Player getPlayer() {
        return player;
    }

//    public int setPlayerHP(int difficultyID) {
//
//    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}
