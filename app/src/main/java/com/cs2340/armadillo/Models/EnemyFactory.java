package com.cs2340.armadillo.Models;

public class EnemyFactory {

    /**
     * gets an enemy given an enemyType
     * @param enemyType String type of enemy
     * @return Enemy object
     */
    public Enemy getEnemy(String enemyType){
        if (enemyType == null) {
            return null;
        }
        if (enemyType.equalsIgnoreCase("COYOTE")) {
            return new Coyote();

        } else if (enemyType.equalsIgnoreCase("BEAR")) {
            return new Bear();

        } else if (enemyType.equalsIgnoreCase("WOLF")) {
            return new Wolf();
        } else if (enemyType.equalsIgnoreCase("HUMAN")) {
            return new Human();
        }
        return null;
    }
}
