package com.cs2340.armadillo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private Button start;
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.start_button);
        exit = (Button) findViewById(R.id.exitButton);

        exit.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });
        start.setOnClickListener(v -> {
            Intent configScreen = new Intent(MainActivity.this, ConfigActivity.class);
            startActivity(configScreen);
            finish();
        });
    }
}