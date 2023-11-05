package com.cs2340.armadillo.View;


import android.graphics.Rect;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.widget.AppCompatImageView;

import com.cs2340.armadillo.Models.*;
import com.cs2340.armadillo.R;

public class EnemyView extends AppCompatImageView {
    Enemy enemy;
    Player player;
    Rect area;
    Rect playerRect;
    boolean hitPlayer;

    public EnemyView (Context context, Enemy enemy, Player player) {
        super(context);
        this.enemy = enemy;
        setSprite(this.enemy.getSpriteID());
        this.setX(enemy.getX());
        this.setY(enemy.getY());
        this.setMaxHeight(40);
        this.setMaxWidth(50);
        this.player = player;
        hitPlayer = false;
    }

    public void setSprite(int sprite) {
        if (sprite == 1) {
            this.setImageResource(R.drawable.coyote);
        } else if (sprite == 2) {
            this.setImageResource(R.drawable.coyote);
        } else {
            this.setImageResource(R.drawable.coyote);
        }
    }



    /*
     * This class creates 32 x 32 pixel Rect objects at the player and enemy location and checks if
     * the two are overlapping.
     */
//    @Override
//    public boolean checkCollide() {
//        int[] enemyPos = new int[2];
//        int[] playerPos = new int[2];
//
//        this.getLocationOnScreen(enemyPos);
//        player.getLocationOnScreen(playerPos);
//        player.setXCoor(500);
//
//        Rect enemyRect = new Rect(enemyPos[0], enemyPos[1], enemyPos[0] + this.getMeasuredWidth(), enemyPos[1] + this.getMeasuredHeight());
//        Rect playerRect = new Rect(playerPos[0], playerPos[1], playerPos[0] + player.getMeasuredWidth(), playerPos[1] + player.getMeasuredHeight());
//        System.out.println("Player: " + playerRect.centerX() + ", " + playerRect.centerY());
//        System.out.println("Player: " + enemyRect.centerX() + ", " + enemyRect.centerY());
//        return enemyRect.intersect(playerRect);
//    }

    public boolean isHitPlayer() {
        return hitPlayer;
    }

    public void setIsHitPlayer(boolean hitPlayer) {
        this.hitPlayer = hitPlayer;
    }
}