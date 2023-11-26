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
    public CheckCollision (EnemyView enemy, Player player) {
        this.enemy = enemy;
        this.player = player;
    }

    public boolean checkCollide() {
        if (enemy.isDead()) {
            return false;
        }
        int[] enemyPos = new int[2];
        int[] playerPos = new int[2];

        enemy.getLocationOnScreen(enemyPos);
        player.getLocationOnScreen(playerPos);

        Rect enemyRect = new Rect(enemyPos[0], enemyPos[1], enemyPos[0] + enemy.getMeasuredWidth(), enemyPos[1] + enemy.getMeasuredHeight());
        Rect playerRect = new Rect(playerPos[0], playerPos[1], playerPos[0] + player.getMeasuredWidth(), playerPos[1] + player.getMeasuredHeight());
        System.out.println("Player: " + playerRect.centerX() + ", " + playerRect.centerY());
        System.out.println("Player: " + enemyRect.centerX() + ", " + enemyRect.centerY());
        return enemyRect.intersect(playerRect);
    }

    public void gameOver(ConstraintLayout game, Context context, Player player) {

    }
}
