package com.cs2340.armadillo.Models;

public class Player2 {
    private int hp;
    private int speed;
    private int defense;
    private int score;

    private int time;

    public Player2() {
        hp = 0;
        speed = 0;
        defense = 0;
        score = 0;
        time = 0;
    }
    public int getHP() {
        return hp;
    }
    public int getSpeed() {
        return speed;
    }
    public int getDefense() {
        return defense;
    }

    public int getScore() {
        return score;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int num) {
        score -= 500;
    }
    public void powerup(int num) {
        if (num == 1) {
            hp++;
        }
        if (num == 2) {
            speed++;
        }
        if (num == 3) {
            defense++;
        }
    }

    public void changeHP(int num) {
        score += 500;
    }


}
