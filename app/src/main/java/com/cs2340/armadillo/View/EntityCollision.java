package com.cs2340.armadillo.View;

import com.cs2340.armadillo.Models.*;

public interface EntityCollision {
        abstract boolean overlap(Player player, EntityCollision entity);
        abstract boolean checkCollide();
}
