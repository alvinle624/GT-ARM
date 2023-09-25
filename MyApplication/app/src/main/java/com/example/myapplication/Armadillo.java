package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioButton;

public class Armadillo extends AppCompatActivity {
    private String name;
    private String difficulty;
    private String sprite;
    public Armadillo() {}

    //Change to set screen to initial config screen when next button on start screen is pressed.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_configuration_screen); // Replace with the name of your XML layout file
    }
    RadioGroup


}
