package com.cs2340.armadillo.View;

import com.cs2340.armadillo.Models.Player;

public class HealthPowerUp extends PowerUp{
    public HealthPowerUp(Player player) {
        super(player);
    }

    @Override
    public void execute() {
        player.setHP(player.getHP() + 5);
    }
}
