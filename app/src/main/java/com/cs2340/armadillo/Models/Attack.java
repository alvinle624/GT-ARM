package com.cs2340.armadillo.Models;

import com.cs2340.armadillo.View.*;
import com.cs2340.armadillo.View.Direction;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Attack {
    Player player;
    Button button;
    Enemies enemyList;
    ImageView visual;

    //enumeration to store attack directions
    public enum AttackDirect {
        UP,
        DOWN,
        RIGHT,
        LEFT
    }

    /**
     * This constructor takes player and a button that
     * becomes the attack button.
     *
     * @param player
     * @param button
     * @param enemyList
     * @param visual
     */
    public Attack (Player player, Button button, Enemies enemyList, ImageView visual) {
        this.player = player;
        this.button = button;
        this.enemyList = enemyList;
        this.visual = visual;
    }

    public void setVisual(ImageView visual) {
        this.visual = visual;
    }

    /**
     * This function takes the buttons passed as
     * parameters and sets them to the attack function.
     */
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

    /**
     * This class creates an
     * attack hitbox in the direction
     * the player is facing and will remove enemies if
     * the hitboxes overlap.
     *
     * @param direction
     * @return
     */
    public boolean enemyAttacked(AttackDirect direction) {
        int[] playerPos = new int[2];
        int[] enemyPos = new int[2];
        Rect attackRect = new Rect(playerPos[0], playerPos[1], playerPos[0] + player.getAttackSize(), playerPos[1] + player.getAttackSize());
        ;
        for (int i = 0; i < enemyList.getEnemyList().size(); i++) {

            // Takes current player and enemy position and creates rectangles there.
            EnemyView enemy = enemyList.findE(i);
            enemy.getLocationOnScreen(enemyPos);
            player.getLocationOnScreen(playerPos);

            Rect enemyRect = new Rect(enemyPos[0], enemyPos[1], enemyPos[0] + enemy.getMeasuredWidth(), enemyPos[1] + enemy.getMeasuredHeight());

            // Attack visual position is changed
            switch (direction) {
                case UP:
                    attackRect = new Rect(playerPos[0], playerPos[1] - player.getAttackSize(), playerPos[0] + player.getAttackSize(), playerPos[1]);
                    visual.setX(player.getX());
                    visual.setY(player.getY() - 110);
                    break;
                case RIGHT:
                    attackRect = new Rect(playerPos[0] + player.getAttackSize(), playerPos[1], playerPos[0] + player.getAttackSize() * 2, playerPos[1] + player.getAttackSize());
                    visual.setX(player.getX() + 110);
                    visual.setY(player.getY());
                    break;
                case DOWN:
                    attackRect = new Rect(playerPos[0], playerPos[1] + player.getAttackSize(), playerPos[0] + player.getAttackSize(), playerPos[1] + player.getAttackSize() * 2);
                    visual.setX(player.getX());
                    visual.setY(player.getY() + 110);
                    break;
                case LEFT:
                    attackRect = new Rect(playerPos[0] - player.getAttackSize(), playerPos[1], playerPos[0], playerPos[1] + player.getAttackSize());
                    visual.setX(player.getX() - 110);
                    visual.setY(player.getY());
                    break;
            }

            // Attack visual visibility is changed so that it briefly appears before disappearing.
            visual.setVisibility(View.VISIBLE);
            if (enemyRect.intersect(attackRect)) {
                enemy.setDead(true);
                enemy.setVisibility(View.INVISIBLE);
            }
            Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(new Runnable() {
                public void run() {
                    visual.setVisibility(View.INVISIBLE);
                }
            }, 400);

        }
        return false;
    }
}
