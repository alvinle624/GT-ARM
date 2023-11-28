package com.cs2340.armadillo.Models;

public class Human implements Enemy {
    private int hp;
    private int dmg;
    private final int spriteID = 4;

    private int xPos = 0;

    private int yPos = 0;

    /**
     * Human constructor
     */
    public Human() {
        hp = 5;
        dmg = 1;
    }

    /**
     * Setter for human HP
     * @param hp human's health
     */
    public void setHP(int hp) {
        this.hp = hp;
    }

    /**
     * Setter for human damage
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
     * increments x and y position of human
     */
    public void move() {
        xPos++;
        yPos++;
    }

    /**
     * x position of human
     * @return x position of human
     */
    public int getX() {
        return xPos;
    }

    /**
     * y position of human
     * @return y position of human
     */
    public int getY() {
        return yPos;
    }
}
