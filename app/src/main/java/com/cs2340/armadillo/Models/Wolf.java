package com.cs2340.armadillo.Models;

public class Wolf implements Enemy {
    private int hp;
    private int dmg;
    private float x, y;
    private final int spriteID = 3;

    private int xPos = 0;

    private int yPos = 0;

    /**
     * Wolf constructor
     */
    public Wolf() {
        hp = 5;
        dmg = 1;
    }

    /**
     * Setter for wolf HP
     * @param hp wolf's health
     */
    public void setHP(int hp) {
        this.hp = hp;
    }

    /**
     * Setter for wolf damage
     * @param dmg damage in int
     */
    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    @Override
    public int getSpriteID() {
        return spriteID;
    }

    /**
     * increments x and y position of wolf
     */
    public void move() {
        xPos++;
        yPos++;
    }

    /**
     * x position of wolf
     * @return x position of wolf
     */
    public int getX() {
        return xPos;
    }

    /**
     * y position of wolf
     * @return y position of wolf
     */
    public int getY() {
        return yPos;
    }

    public String makeNoise() {
        return "howl!";
    }
}
