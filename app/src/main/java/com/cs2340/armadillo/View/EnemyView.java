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
            this.setImageResource(R.drawable.bear);
        } else if (sprite == 3){
            this.setImageResource(R.drawable.wolf);
        } else {
            this.setImageResource(R.drawable.human);
        }
    }




    public boolean isHitPlayer() {
        return hitPlayer;
    }

    public void setIsHitPlayer(boolean hitPlayer) {
        this.hitPlayer = hitPlayer;
    }
}