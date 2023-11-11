package com.cs2340.armadillo.Models;

public class Human implements Enemy {
    private int hp;
    private int dmg;
    private final int spriteID = 1;

    public Human() {
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
