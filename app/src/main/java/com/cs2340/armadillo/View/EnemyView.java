package com.cs2340.armadillo.View;


import android.graphics.Rect;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.widget.AppCompatImageView;

import com.cs2340.armadillo.Models.*;
import com.cs2340.armadillo.R;

public class EnemyView extends AppCompatImageView implements EntityCollision {
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

    @Override
    public boolean overlap(Player player, EntityCollision entity) {
        return false;
    }

    /*
     * This class creates 32 x 32 pixel Rect objects at the player and enemy location and checks if
     * the two are overlapping.
     */
    @Override
    public boolean checkCollide() {
        int enemyX = (int)enemy.getX();
        int enemyY = (int)enemy.getY();
        area = new Rect(enemyX - 16, enemyY + 16, enemyY - 16, enemyX + 16);
        playerRect = new Rect((int)player.getX() - 16,(int)player.getY() + 16, (int)player.getY() - 16, (int)player.getX() + 16);
        hitPlayer = area.intersect(playerRect);
        return area.intersect(playerRect);
    }

    public boolean isHitPlayer() {
        return hitPlayer;
    }

    public void setIsHitPlayer(boolean hitPlayer) {
        this.hitPlayer = hitPlayer;
    }
}