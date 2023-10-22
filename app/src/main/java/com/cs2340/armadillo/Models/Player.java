package com.cs2340.armadillo.Models;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.cs2340.armadillo.R;

import java.io.Serializable;

public class Player extends androidx.appcompat.widget.AppCompatImageView {
    private String name;
    private String difficulty;
    private int sprite;
    private int HP;
    private int spriteID;

    private float x, y;

    private static final int playerWidth = 32;
    private static final int playerHeight = 32;

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
    public Player(Context context, float x, float y, int HP) {
        super(context);
        this.x = x;
        this.y = y;
        this.setY(y);
        this.setX(x);
        this.sprite = 1;
        this.HP = HP;
        this.setImageResource(R.drawable.sprite_one);
        this.setMaxHeight(40);
        this.setMaxWidth(50);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    public int getHP() {
        return HP;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }
    public int getSprite() {
        return sprite;
    }
    public void setSprite(int sprite) {
        this.sprite = sprite;
        if (sprite == 1) {
            spriteID = R.drawable.sprite_one;
        } else if (sprite == 2) {
            spriteID = R.drawable.sprite_two;
        } else {
            spriteID = R.drawable.sprite_three;
        }
        this.setImageResource(spriteID);
//        this.getLayoutParams().height = 30;
    }
    public int getSpriteID() {
        return spriteID;
    }

    public void changePos(float x, float y) {
        this.x += x;
        this.y += y;
        this.setY(this.y);
        this.setX(this.x);
    }
    public void setXCoor(float x) {
        this.x = x;
    }
    public void setYCoor(float y) {
        this.y = y;
    }

    // Checks if player will move into a wall:
    // playerCanMove = 1, player can move in @direction
    // playerCanMove = 0, player cannot move in @direction
    public boolean playerCanMove(int direction, MapLayout map) {
        switch(Direction.values()[direction]) {
            case UP:
                if (map.getLayout()[(int)x][(int)y-20] > 2) {
                    return false;
                }
                break;
            case DOWN:
                if (map.getLayout()[(int)x][(int)y+playerHeight+20] > 2) {
                    return false;
                }
                break;
            case LEFT:
                if (map.getLayout()[(int)x-20][(int)y] > 2) {
                    return false;
                }
                break;
            case RIGHT:
                if (map.getLayout()[(int)x+playerWidth+20][(int)y] > 2) {
                    return false;
                }
                break;
            default:
                return true;
        }
        return true;
    }
}
