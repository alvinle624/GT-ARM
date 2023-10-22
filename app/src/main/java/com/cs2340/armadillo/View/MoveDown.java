package com.cs2340.armadillo.View;

import android.widget.ImageView;

import com.cs2340.armadillo.Models.Player;
import com.cs2340.armadillo.Models.PlayerT;

public class MoveDown implements Direction{
    public void move(Player player) {
        player.changeYPos(0, 20);
    }
    public void move(PlayerT player) {
        player.changePos(0, 20);
    }
}
