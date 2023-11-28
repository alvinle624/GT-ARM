package com.cs2340.armadillo.View;

import android.content.Context;

import androidx.appcompat.widget.AppCompatImageView;

import com.cs2340.armadillo.R;

public class PowerUpView extends AppCompatImageView {
    private int size = 32;
    private float x;
    private float y;

    private boolean health = false;

    private boolean speed = false;

    private boolean nuke = false;
    private String pName;
    public PowerUpView(Context context, float x, float y, String pName) {
        super(context);
        this.pName = pName;
        this.x = x;
        this.y = y;
        this.setX(x);
        this.setY(y);
        if (pName.equals("health")) {
            this.setImageResource(R.drawable.health_bug);
            health = true;
        } else if (pName.equals("speed")) {
            this.setImageResource(R.drawable.speed_bug);
            speed = true;
        } else if (pName.equals("eradicate")) {
            this.setImageResource(R.drawable.nuke);
            nuke = true;
        }
    }

    public boolean checkCollision(float playerX, float playerY) {
        if (playerX == x && playerY == y) {
            return true;
        }
        return false;
    }
}
