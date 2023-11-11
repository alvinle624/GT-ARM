package com.cs2340.armadillo.Models;

public class Bear implements Enemy {
    private int hp;
    private int dmg;
    private final int spriteID = 2;

    public Bear(float xPos, float yPos) {
        hp = 5;
        dmg = 1;
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
}
