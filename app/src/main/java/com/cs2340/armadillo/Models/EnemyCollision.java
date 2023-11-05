package com.cs2340.armadillo.Models;

import com.cs2340.armadillo.View.*;
import java.util.ArrayList;
public class EnemyCollision {
    ArrayList<EntityCollision> entities = new ArrayList<>();
    Player player;

    public EnemyCollision(Player player) {
        this.player = player;
    }

    public void addEntity(EntityCollision entity) {
        entities.add(entity);
    }

    public void collisionListener() {

    }
}
