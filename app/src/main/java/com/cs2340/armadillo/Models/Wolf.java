package com.cs2340.armadillo.Models;

public class Wolf implements Enemy {
    private int hp;
    private int dmg;
    private float x, y;
    private final int spriteID = 3;

    public Wolf(float xPos, float yPos) {
        hp = 5;
        dmg = 1;
        x = xPos;
        y = yPos;
    }

    public void createView() {

    }
    @Override
    public void move() {

    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    @Override
    public int getSpriteID() {
        return spriteID;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
