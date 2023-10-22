package com.cs2340.armadillo;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import android.content.Context;
import android.graphics.Rect;

import com.cs2340.armadillo.Models.Leaderboard;
import com.cs2340.armadillo.Models.MapLayout;
import com.cs2340.armadillo.Models.Player;
import com.cs2340.armadillo.Models.PlayerT;
import com.cs2340.armadillo.Models.Sprite;
import com.cs2340.armadillo.View.ConfigActivity;
import com.cs2340.armadillo.View.Direction;
import com.cs2340.armadillo.View.EndActivity;
import com.cs2340.armadillo.View.MoveDown;
import com.cs2340.armadillo.View.MoveLeft;
import com.cs2340.armadillo.View.MoveRight;
import com.cs2340.armadillo.View.MoveUp;



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
    public void playerMoveUp() {
        PlayerT player = new PlayerT(200,200,5);
        Direction moveUp = new MoveUp();
        moveUp.move(player);
        moveUp.move(player);
        moveUp.move(player);
        assert(player.getXCoor() == 200 && player.getYCoor() == 140);
    }
    @Test
    public void playerMoveDown() {
        PlayerT player = new PlayerT(200,200,5);
        Direction moveDown = new MoveDown();
        moveDown.move(player);
        moveDown.move(player);
        moveDown.move(player);
        assert(player.getXCoor() == 200 && player.getYCoor() == 260);
    }

    @Test
    public void playerMoveRight() {
        PlayerT player = new PlayerT(200,200,5);
        Direction moveRight = new MoveRight();
        moveRight.move(player);
        moveRight.move(player);
        moveRight.move(player);
        assert(player.getXCoor() == 260 && player.getYCoor() == 200);
    }
    @Test
    public void playerMoveLeft() {
        PlayerT player = new PlayerT(200,200,5);
        Direction moveLeft = new MoveLeft();
        moveLeft.move(player);
        moveLeft.move(player);
        moveLeft.move(player);
        assert(player.getXCoor() == 140 && player.getYCoor() == 200);
    }

    @Test
    public void endScreenDisplaysThatPlayerWon() {
        PlayerT player = new PlayerT(200,200,5);
        String expected = "You Win!";
        String actual = player.getWinText();
        assertEquals(expected, actual);
    }

    @Test
    public void checkWallCollisions() {
        MapLayout mapLayout = new MapLayout();
        PlayerT player = new PlayerT(35, 100, 5);
        boolean expected = false;
        boolean actual = player.playerCanMove(2, mapLayout);
        assertEquals(expected, actual);
    }
    @Test
    public void checkPlayerCanMoveNearWall() {
        MapLayout mapLayout = new MapLayout();
        PlayerT player = new PlayerT(53,100,5);
        boolean expected = true;
        boolean actual = player.playerCanMove(2, mapLayout);
        assertEquals(expected, actual);
    }
    @Test
    public void spriteWidthIsCorrect() {
        Rect img = new Rect(0, 0, 32, 32);
        Sprite sprite = new Sprite(R.drawable.sprite_sheet, img);
        int expected = 32;
        int actual = sprite.getWidth();
        assertEquals(expected, actual);
    }

    @Test
    public void spriteHeightIsCorrect() {
        Rect img = new Rect(0, 0, 32, 32);
        Sprite sprite = new Sprite(R.drawable.sprite_sheet, img);
        int expected = 32;
        int actual = sprite.getHeight();
        assertEquals(expected, actual);
    }




}
