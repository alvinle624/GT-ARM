package com.cs2340.armadillo.Models;

import android.content.Context;

import com.cs2340.armadillo.R;

public class PlayerT {
    private String name;
    private String difficulty;
    private int sprite;
    private int HP;
    private int spriteID;

    private float x, y;
    private String winText;

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public PlayerT(float x, float y, int HP) {
        this.x = x;
        this.y = y;
        this.sprite = 1;
        this.HP = HP;
        this.setWinText("You Win!");
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
    }
    public int getSpriteID() {
        return spriteID;
    }

    public void changePos(float x, float y) {
        this.x += x;
        this.y += y;
    }
    public void setXCoor(float x) {
        this.x = x;
    }
    public float getXCoor() {
        return x;
    }
    public void setYCoor(float y) {
        this.y = y;
    }
    public float getYCoor() {
        return y;
    }

    public void setWinText(String winText) {
        this.winText = winText;
    }
    public String getWinText() {
        return winText;
    }
    public boolean playerCanMove(int direction, MapLayout map) {
        switch(Player.Direction.values()[direction]) {
            case UP:
                if (map.getLayout()[(int)x][(int)y-20] > 2) {
                    return false;
                }
                break;
            case DOWN:
                if (map.getLayout()[(int)x][(int)y+20] > 2) {
                    return false;
                }
                break;
            case LEFT:
                if (map.getLayout()[(int)x-20][(int)y] > 2) {
                    return false;
                }
                break;
            case RIGHT:
                if (map.getLayout()[(int)x+20][(int)y] > 2) {
                    return false;
                }
                break;
            default:
                return true;
        }
        return true;
    }
}

