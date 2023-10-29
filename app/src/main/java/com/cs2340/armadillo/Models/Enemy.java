package com.cs2340.armadillo.Models;

public interface Enemy {
    abstract void move();
    abstract void setHP(int hp);
    abstract void setDmg(int dmg);
    abstract void createView();
    abstract int getSpriteID();
    abstract float getX();
    abstract float getY();

}