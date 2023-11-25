package com.cs2340.armadillo.Models;

import com.cs2340.armadillo.View.*;
import com.cs2340.armadillo.View.Direction;

import android.graphics.Rect;
import android.view.View;
import android.widget.Button;

public class Attack {
    Player player;
    Button button;
    Enemies enemyList;

    public enum AttackDirect {
        UP,
        DOWN,
        RIGHT,
        LEFT
    }

    public Attack (Player player, Button button, Enemies enemyList) {
        this.player = player;
        this.button = button;
        this.enemyList = enemyList;
    }
    public void attackListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String direction;
                switch (player.getFacing()) {
                    case UP:
                        enemyAttacked(AttackDirect.UP);
                        break;
                    case RIGHT:
                        enemyAttacked(AttackDirect.RIGHT);
                        break;
                    case DOWN:
                        enemyAttacked(AttackDirect.DOWN);
                        break;
                    case LEFT:
                        enemyAttacked(AttackDirect.LEFT);
                        break;
                    default:
                        enemyAttacked(AttackDirect.UP);
                        break;
                }
            }
        });
    }

    public boolean enemyAttacked(AttackDirect direction) {
        int[] playerPos = new int[2];
        int[] enemyPos = new int[2];
        Rect attackRect = new Rect(playerPos[0], playerPos[1], playerPos[0] + player.getMeasuredWidth(), playerPos[1] + player.getMeasuredHeight());
        ;
        for (int i = 0; i < enemyList.getEnemyList().size(); i++) {

            EnemyView enemy = enemyList.findE(i);
            enemy.getLocationOnScreen(enemyPos);
            player.getLocationOnScreen(playerPos);

            Rect enemyRect = new Rect(enemyPos[0], enemyPos[1], enemyPos[0] + enemy.getMeasuredWidth(), enemyPos[1] + enemy.getMeasuredHeight());

            switch (direction) {
                case UP:
                    attackRect = new Rect(playerPos[0], playerPos[1] + player.getMeasuredHeight(), playerPos[0] + player.getMeasuredWidth(), playerPos[1] + player.getMeasuredHeight() * 2);
                    break;
                case RIGHT:
                    attackRect = new Rect(playerPos[0] + player.getMeasuredWidth(), playerPos[1], playerPos[0] + player.getMeasuredWidth() * 2, playerPos[1] + player.getMeasuredHeight());
                    break;
                case DOWN:
                    attackRect = new Rect(playerPos[0], playerPos[1] - player.getMeasuredHeight(), playerPos[0] + player.getMeasuredWidth(), playerPos[1] - player.getMeasuredHeight() * 2);
                    break;
                case LEFT:
                    attackRect = new Rect(playerPos[0] - player.getMeasuredWidth(), playerPos[1], playerPos[0] - player.getMeasuredWidth() * 2, playerPos[1] + player.getMeasuredHeight());
                    break;
            }
            if (enemyRect.intersect(attackRect)) {
                enemy.setDead(true);
                enemy.setVisibility(View.INVISIBLE);
            }
        }
        return false;
    }
}
