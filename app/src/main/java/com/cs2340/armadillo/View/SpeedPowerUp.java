package com.cs2340.armadillo.View;

import com.cs2340.armadillo.Models.Player;

public class SpeedPowerUp extends PowerUp {
    public SpeedPowerUp (Player player) {
        super(player);
    }

    @Override
    public void execute() {
        player.setSpeed(30);
    }
}
