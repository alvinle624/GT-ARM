package com.cs2340.armadillo.Models;

public interface Enemy {
    abstract void setHP(int hp);
    abstract void setDmg(int dmg);
    abstract int getSpriteID();

}