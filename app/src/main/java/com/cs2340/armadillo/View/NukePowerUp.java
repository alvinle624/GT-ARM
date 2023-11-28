package com.cs2340.armadillo.View;

import android.view.View;

import com.cs2340.armadillo.Models.Enemies;
import com.cs2340.armadillo.Models.Player;

public class NukePowerUp extends PowerUp {

    Enemies enemies;
    public NukePowerUp(Player player, Enemies enemies) {
        super(player);
        this.enemies = enemies;
    }

    @Override
    public void execute() {
        for (int i = 0; i < enemies.getEnemyList().size(); i++) {
            EnemyView enemy = enemies.findE(i);
            enemy.setDead(true);
            enemy.setVisibility(View.INVISIBLE);
        }
    }
}
