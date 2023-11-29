package com.cs2340.armadillo.View;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.cs2340.armadillo.Models.Enemy;
import com.cs2340.armadillo.Models.Player;
import com.cs2340.armadillo.R;

public class CheckCollision implements EntityCollision {

    Player player;
    EnemyView enemy;

    /**
     * Constructor for CheckCollision that takes Enemy and Player
     * view.
     * @param enemy
     * @param player
     */
    public CheckCollision (EnemyView enemy, Player player) {
        this.enemy = enemy;
        this.player = player;
    }

    /**
     * This checks if the player hitbox and enemy
     * hitbox overlap. If enemy is already recognized as dead, does not
     * check no matter what.
     * @return
     */
    public boolean checkCollide() {
        if (enemy.isDead()) {
            return false;
        }
        int[] enemyPos = new int[2];
        int[] playerPos = new int[2];

        enemy.getLocationOnScreen(enemyPos);
        player.getLocationOnScreen(playerPos);

        // Creates Rect objects for enemy and player and checks if they overlap.
        Rect enemyRect = new Rect(enemyPos[0], enemyPos[1], enemyPos[0] + enemy.getMeasuredWidth(), enemyPos[1] + enemy.getMeasuredHeight());
        Rect playerRect = new Rect(playerPos[0], playerPos[1], playerPos[0] + player.getMeasuredWidth(), playerPos[1] + player.getMeasuredHeight());
//        System.out.println("Player: " + playerRect.centerX() + ", " + playerRect.centerY());
//        System.out.println("Player: " + enemyRect.centerX() + ", " + enemyRect.centerY());
        return enemyRect.intersect(playerRect);
    }
}
