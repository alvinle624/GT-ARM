package com.cs2340.armadillo.Models;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.cs2340.armadillo.R;

import java.io.Serializable;

public class Player extends androidx.appcompat.widget.AppCompatImageView implements PlayerInterface {
    private String name;
    private String difficulty;
    private int sprite;
    private int HP;
    private int spriteID;

    private float x, y;

    private String winText;

    private static final int playerWidth = 32;
    private static final int playerHeight = 32;

    private Direction facing;

    public void powerUp() {
        return;
    }

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
        this.winText = "---";
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

    public int powerupID = 1;

    public float speed = 20;

    public void setPowerupID(int powerupID) {
        this.powerupID = powerupID;
    }
    public int getPowerupID () {
        return powerupID;
    }
    public int getSprite() {
        return sprite;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
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
    }
    public int getSpriteID() {
        return spriteID;
    }

    public void changeXPos(float x, float y) {
        if (this.x < 10) {
            this.x = 10;
        } else if (this.x > 1310) {
            this.x = 1310;
        } else {
            this.x += x;
        }

        this.setX(this.x);
        this.setY(this.y);
    }
    public void changeYPos(float x, float y) {
        if (this.y < 10) {
            this.y = 10;
        } else if (this.y > 2760) {
            this.y = 2760;
        } else {
            this.y += y;
        }

        this.setX(this.x);
        this.setY(this.y);
    }
    public void setXCoor(float x) {
        this.x = x;
    }
    public void setYCoor(float y) {
        this.y = y;
    }
    public float x() {
        return this.x;
    }
    public float y() {
        return this.y;
    }
    public void setWinText(String winText) {
        this.winText = winText;
    }

    public String getWinText() {
        return winText;
    }
    // Checks if player will move into a wall:
    // playerCanMove = 1, player can move in @direction
    // playerCanMove = 0, player cannot move in @direction
    public boolean playerCanMove(int direction, int[][] layout) {
        switch(Direction.values()[direction]) {
            // gotta fix the row col (swap the col and rol/x and y)
            case UP:
                if (layout[(int)Math.floor((y-(int)speed)/100)][(int)Math.floor((x/100))] > 0) {
                    return false;
                }
                break;
            case DOWN:
                if (layout[(int)Math.floor(((y+playerHeight+(int)speed)/100))][(int)Math.floor(x/100)] > 0) {
                    return false;
                }
                break;
            case LEFT:
                if (layout[(int)Math.floor(y/100)][(int)Math.floor((x-(int)speed)/100)] > 0) {
                    return false;
                }
                break;
            case RIGHT:
                if (layout[(int)Math.floor(y/100)][(int)Math.floor((x+playerWidth+(int)speed)/100)] > 0) {
                    return false;
                }
                break;
        }
        return true;
    }

    public Direction getFacing() {
        if (facing != null) {
            return facing;
        }
        return Direction.DOWN;
    }

    public void setFacing(Direction direction) {
        facing = direction;
    }
}
