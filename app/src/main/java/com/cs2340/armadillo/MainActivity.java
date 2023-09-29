package com.cs2340.armadillo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button start;
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.start_button);
        exit = (Button) findViewById(R.id.exitButton);

//        exit.setOnClickListener(v -> {
//            finish();
//        });
        start.setOnClickListener(v -> {
//            RadioGroup difficultyRadioGroup = findViewById(R.id.radioDifficultyGroup);
//            double difficulty = 1.0;
//
//            int radioID = difficultyRadioGroup.getCheckedRadioButtonId();
//            if (radioID == R.id.radioEasy) {
//                difficulty = 0.5;
//            } else if (radioID == R.id.radioMedium) {
//                difficulty = 0.75;
//            } else if (radioID == R.id.radioHard) {
//                difficulty = 1.0;
//            } else {
//                difficulty = 0.6;
//            }

            Intent configScreen = new Intent(MainActivity.this, ConfigActivity.class);
//            game.putExtra("difficulty", difficulty);
            startActivity(configScreen);
            finish();
        });
    }
}