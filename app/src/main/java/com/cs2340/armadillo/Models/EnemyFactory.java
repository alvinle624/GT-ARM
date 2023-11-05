package com.cs2340.armadillo.Models;

public class EnemyFactory {

    public Enemy getEnemy(String enemyType, float xPos, float yPos) {
        if (enemyType == null) {
            return null;
        }
        if (enemyType.equalsIgnoreCase("COYOTE")) {
            return new Coyote(xPos, yPos);
        } else if (enemyType.equalsIgnoreCase("BEAR")) {
            return new Bear(xPos, yPos);
        } else if (enemyType.equalsIgnoreCase("WOLF")) {
            return new Wolf(xPos, yPos);
        } else if (enemyType.equals("HUMAN")) {
            return new Human(xPos, yPos);
        } else {
            return null;
        }
    }

}
