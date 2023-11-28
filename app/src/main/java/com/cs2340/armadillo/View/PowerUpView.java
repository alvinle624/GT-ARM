package com.cs2340.armadillo.View;

import android.content.Context;
import android.graphics.Rect;

import androidx.appcompat.widget.AppCompatImageView;

import com.cs2340.armadillo.Models.Enemies;
import com.cs2340.armadillo.Models.Player;
import com.cs2340.armadillo.R;

public class PowerUpView extends AppCompatImageView {
    private int size = 32;
    private float x;
    private float y;

    private boolean health = false;

    private boolean speed = false;

    private boolean nuke = false;
    private boolean collected;
    private String pName;
    public PowerUpView(Context context, float x, float y, String pName) {
        super(context);
        this.pName = pName;
        this.x = x;
        this.y = y;
        this.setX(x);
        this.setY(y);
        collected = false;
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

    public boolean checkCollision(Player player) {
        if (collected) {
            return false;
        }
        int[] enemyPos = new int[2];
        int[] playerPos = new int[2];

        this.getLocationOnScreen(enemyPos);
        player.getLocationOnScreen(playerPos);

        // Creates Rect objects for enemy and player and checks if they overlap.
        Rect enemyRect = new Rect(enemyPos[0], enemyPos[1], enemyPos[0] + this.getMeasuredWidth(), enemyPos[1] + this.getMeasuredHeight());
        Rect playerRect = new Rect(playerPos[0], playerPos[1], playerPos[0] + player.getMeasuredWidth(), playerPos[1] + player.getMeasuredHeight());

        return enemyRect.intersect(playerRect);
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    public void executePowerUp(Player player, Enemies enemies) {
        PowerUp powerUp;
        if (pName.equals("health")) {
            powerUp = new HealthPowerUp(player);
            powerUp.execute();
        } else if (pName.equals("speed")) {
            powerUp = new SpeedPowerUp(player);
            powerUp.execute();
        } else if (pName.equals("eradicate")) {
            powerUp = new NukePowerUp(player, enemies);
            powerUp.execute();
        }
    }
}
