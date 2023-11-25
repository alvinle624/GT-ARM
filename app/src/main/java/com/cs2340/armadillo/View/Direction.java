package com.cs2340.armadillo.View;

import android.widget.ImageView;
import com.cs2340.armadillo.Models.Enemies;
import com.cs2340.armadillo.Models.Player;
import com.cs2340.armadillo.Models.PlayerT;

public interface Direction {
    abstract void move(Player player, Enemies enemies);
}
