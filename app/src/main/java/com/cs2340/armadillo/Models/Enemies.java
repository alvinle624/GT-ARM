package com.cs2340.armadillo.Models;

import com.cs2340.armadillo.View.EnemyView;

import java.util.ArrayList;

public class Enemies {
    private ArrayList<EnemyView> enemyList;

    public Enemies() {
        this.enemyList = new ArrayList<EnemyView>();
    }

    public ArrayList getEnemyList() {
        return this.enemyList;
    }
    public void addEnemy(EnemyView enemy) {
        this.enemyList.add(enemy);
    }

    public void removeEnemy(EnemyView enemy) {
        this.enemyList.remove(enemy);
    }

    public void removeAllEnemies() {
        this.enemyList.clear();
    }

    public EnemyView findE(int i) {
        return this.enemyList.get(i);
    }
}
