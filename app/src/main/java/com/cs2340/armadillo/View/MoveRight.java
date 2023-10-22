package com.cs2340.armadillo.View;

import android.widget.ImageView;

import com.cs2340.armadillo.Models.Player;
import com.cs2340.armadillo.Models.PlayerT;

public class MoveRight implements Direction{
    public void move(Player player) {
        player.changeXPos(20, 0);
    }
    public void move(PlayerT player) {
        player.changePos(20, 0);
    }
}
