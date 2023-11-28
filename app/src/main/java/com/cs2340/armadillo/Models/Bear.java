package com.cs2340.armadillo.Models;

public class Bear implements Enemy {
    private int hp;
    private int dmg;
    private final int spriteID = 2;

    private int xPos = 0;

    private int yPos = 0;

    /**
     * Bear constructor
     */
    public Bear() {
        hp = 5;
        dmg = 1;
    }

    /**
     * Setter for bear HP
     * @param hp bear's health
     */
    public void setHP(int hp) {
        this.hp = hp;
    }

    /**
     * Setter for bear damage
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
     * increments x and y position of bear
     */
    public void move() {
        xPos++;
        yPos++;
    }

    /**
     * x position of bear
     * @return x position of bear
     */
    public int getX() {
        return xPos;
    }

    /**
     * y position of bear
     * @return y position of bear
     */
    public int getY() {
        return yPos;
    }

    public String growl() {
        return "rawr";
    }
}
