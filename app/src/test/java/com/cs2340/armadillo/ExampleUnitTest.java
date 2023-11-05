package com.cs2340.armadillo;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

import android.graphics.Rect;

import com.cs2340.armadillo.Models.Coyote;
import com.cs2340.armadillo.Models.Enemy;
import com.cs2340.armadillo.Models.EnemyFactory;
import com.cs2340.armadillo.View.EnemyView;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Ignore
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getEnemyReturnsCorrectEnemyType() {
        EnemyFactory factory = new EnemyFactory();
        Coyote coyote = new Coyote(0, 0);
        Enemy enemy = factory.getEnemy("COYOTE", 0, 0);
        String expected = coyote.getClass().getName();
        String actual = enemy.getClass().getName();
        assertEquals(expected, actual);
    }

    @Test
    public void getEnemySetsCorrectCoordinates() {
        EnemyFactory factory = new EnemyFactory();
        Coyote coyote = new Coyote(0, 0);
        Enemy enemy = factory.getEnemy("COYOTE", 0, 0);
        Float expected = coyote.getX();
        Float actual = enemy.getX();
        assertEquals(expected, actual);
    }

    @Test
    public void enemyMovesUp() {

    }

    @Test
    public void enemyMovesDown() {

    }

    @Test
    public void enemyMovesLeft() {

    }

    @Test
    public void enemyMovesRight() {

    }

    @Test
    public void endingScreenDisplaysPlayerLost() {

    }

    @Test
    public void collisionUpdatesHP() {

    }

}
