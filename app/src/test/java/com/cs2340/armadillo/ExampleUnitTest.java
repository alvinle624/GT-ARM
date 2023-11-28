package com.cs2340.armadillo;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

import com.cs2340.armadillo.Models.Player2;
import com.cs2340.armadillo.Models.Enemy2;

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
    public void powerup1ImpactsPlayer() {
        Player2 player = new Player2();
        int expected = player.getHP() + 1;
        player.powerup(1);
        int actual = player.getHP();
        assertEquals(expected, actual);
    }
    @Test
    public void powerup2ImpactsPlayer() {
        Player2 player = new Player2();
        int expected = player.getSpeed() + 1;
        player.powerup(2);
        int actual = player.getSpeed();
        assertEquals(expected, actual);
    }
    @Test
    public void powerup3ImpactsPlayer() {
        Player2 player = new Player2();
        int expected = player.getDefense() + 1;
        player.powerup(3);
        int actual = player.getDefense();
        assertEquals(expected, actual);
    }
    @Test
    public void playerHpUpdatesScore() {
        Player2 player = new Player2();
        int expected = player.getScore() - 500;
        int hp = player.getHP();
        player.changeHP(hp - 1);
        int actual = player.getScore();
        assertEquals(expected, actual);
    }
    @Test
    public void timeUpdatesScore() {
        Player2 player = new Player2();
        int expected = player.getScore() - 500;
        int time = player.getTime();
        player.setTime(time - 100);
        int actual = player.getScore();
        assertEquals(expected, actual);
    }
    @Test
    public void enemyDestroyedAfterOneAttack() {
        boolean expected = false;
        Enemy2 enemy = new Enemy2();
        Player2 player = new Player2();
        player.attack(enemy);
        boolean actual = enemy.getIsAlive();
        assertEquals(expected, actual);
    }
    @Test
    public void moveFacingUp() {
        Player2 player = new Player2();
        player.moveUp();
        String expected = "UP";
        String actual = player.moveFacing();
        assertEquals(expected, actual);
    }
    @Test
    public void moveFacingDown() {
        Player2 player = new Player2();
        player.moveDown();
        String expected = "DOWN";
        String actual = player.moveFacing();
        assertEquals(expected, actual);
    }

    @Test
    public void moveFacingLeft() {
        Player2 player = new Player2();
        player.moveLeft();
        String expected = "LEFT";
        String actual = player.moveFacing();
        assertEquals(expected, actual);
    }

    @Test
    public void moveFacingRight() {
        Player2 player = new Player2();
        player.moveRight();
        String expected = "RIGHT";
        String actual = player.moveFacing();
        assertEquals(expected, actual);
    }
}
