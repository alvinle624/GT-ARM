package com.cs2340.armadillo;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

import com.cs2340.armadillo.Models.Coyote;
import com.cs2340.armadillo.Models.Enemy;
import com.cs2340.armadillo.Models.EnemyFactory;




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
        Enemy enemy = factory.getEnemy("COYOTE", 0, 0);
        String expected = "com.cs2340.armadillo.Coyote";
        String actual = enemy.getClass().getName();
        assertEquals(expected, actual);
    }

    @Test
    public void getEnemySetsEnemyCoordinatesCorrectly() {
        EnemyFactory factory = new EnemyFactory();
        Enemy enemy = factory.getEnemy("COYOTE", 0, 0);
        float expected = 0;
        float actual = enemy.getX();
        assertEquals(expected, actual);
    }

}
