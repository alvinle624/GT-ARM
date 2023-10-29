package com.cs2340.armadillo.View;


import android.graphics.Rect;
import android.content.Context;

import androidx.appcompat.widget.AppCompatImageView;

import com.cs2340.armadillo.Models.*;
import com.cs2340.armadillo.R;

public class EnemyView extends AppCompatImageView implements EntityCollision {
    Enemy enemy;
    Rect area;
    public EnemyView (Context context, Enemy enemy) {
        super(context);
        this.enemy = enemy;
        setSprite(this.enemy.getSpriteID());
        this.setX(enemy.getX());
        this.setY(enemy.getY());
        this.setMaxHeight(40);
        this.setMaxWidth(50);
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

    public void move() {

    }

    @Override
    public boolean overlap(Player player, EntityCollision entity) {
        return false;
    }

    @Override
    public void setListener() {
        int enemyX = (int)enemy.getX();
        int enemyY = (int)enemy.getY();
        area = new Rect(enemyX - 16, enemyY + 16, enemyY - 16, enemyX + 16);
    }
}