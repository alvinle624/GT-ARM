package com.cs2340.armadillo.Models;

import com.cs2340.armadillo.View.EnemyView;

import java.util.ArrayList;

public class Enemies {
    private ArrayList<EnemyView> enemyList;

    /**
     * constructor for Enemies class
     */
    public Enemies() {
        this.enemyList = new ArrayList<EnemyView>();
    }

    /**
     * returns list representation of all enemies
     * @return ArrayList of enemies
     */
    public ArrayList getEnemyList() {
        return this.enemyList;
    }

    /**
     * adds enemy to ArrayList of enemies
     * @param enemy to add
     */
    public void addEnemy(EnemyView enemy) {
        this.enemyList.add(enemy);
    }

    /**
     * removes enemy from ArrayList of enemies
     * @param enemy to remove
     */
    public void removeEnemy(EnemyView enemy) {
        this.enemyList.remove(enemy);
    }

    /**
     * removes all enemies from list
     */
    public void removeAllEnemies() {
        this.enemyList.clear();
    }

    /**
     * returns view of enemy depending on its
     * position in list
     * @param i index of enemy in list
     * @return EnemyView of enemy
     */
    public EnemyView findE(int i) {
        return this.enemyList.get(i);
    }
}
