package com.cs2340.armadillo.View;

import android.widget.ImageView;

import com.cs2340.armadillo.Models.Player;

public class MoveLeft implements Direction {
    public void move(Player player) {
        player.changePos(-20, 0);
    }
}
