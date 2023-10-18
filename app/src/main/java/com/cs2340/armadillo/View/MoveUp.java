package com.cs2340.armadillo.View;

import android.media.Image;
import android.widget.ImageView;

import com.cs2340.armadillo.Models.Player;

public class MoveUp implements Direction {
    public void move(Player player) {
        player.changePos(0, -20);
    }
}
