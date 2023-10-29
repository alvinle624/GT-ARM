package com.cs2340.armadillo.View;

public interface EntityCollision {
    abstract boolean isPlayer();
    abstract boolean overlap(EntityCollision entity1, EntityCollision entity2);
}
