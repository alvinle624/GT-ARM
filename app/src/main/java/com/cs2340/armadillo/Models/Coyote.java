package com.cs2340.armadillo.Models;

public class Coyote implements Enemy {

    private int hp;
    private int dmg;
    private final int spriteID = 1;

    private int xPos = 0;

    private int yPos = 0;

    /**
     * Coyote constructor
     */
    public Coyote() {
        hp = 5;
        dmg = 1;
    }

    /**
     * Setter for coyote HP
     * @param hp coyote's health
     */
    public void setHP(int hp) {
        this.hp = hp;
    }

    /**
     * Setter for coyote damage
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
     * increments x and y position of coyote
     */
    public void move() {
        xPos++;
        yPos++;
    }

    /**
     * x position of coyote
     * @return x position of coyote
     */
    public int getX() {
        return xPos;
    }

    /**
     * y position of coyote
     * @return y position of coyote
     */
    public int getY() {
        return yPos;
    }


}