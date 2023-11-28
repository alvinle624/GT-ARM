package com.cs2340.armadillo.View;

import com.cs2340.armadillo.Models.Player;

public class PowerUp {
    Player player;
    public PowerUp (Player player) {
        this.player = player;
    }

    public void execute() {
        System.out.println("Execute Order 66!");
    }
}
