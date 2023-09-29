package com.cs2340.armadillo;

public class Player {
    private String name;
    private String difficulty;
    private int sprite;
    private int HP;

    public Player() {}

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
    }
}
