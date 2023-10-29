package com.cs2340.armadillo.View;


import android.content.Context;

import androidx.appcompat.widget.AppCompatImageView;

import com.cs2340.armadillo.Models.*;
import com.cs2340.armadillo.R;

public class EnemyView extends AppCompatImageView {
    Enemy enemy;
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


}