package com.cs2340.armadillo.View;

import android.widget.ImageView;

import com.cs2340.armadillo.Models.Player;

public interface Direction {
    abstract void move(Player player);
}
