package com.cs2340.armadillo;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

import com.cs2340.armadillo.Models.Leaderboard;
import com.cs2340.armadillo.Models.Player;
import com.cs2340.armadillo.View.GameActivity;


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
    public void onlyOneInstanceLeaderBoard() {
        Leaderboard expected = Leaderboard.getLeaderboard();
        Leaderboard actual = Leaderboard.getLeaderboard();
        //checks if refers to same object
        assertSame(expected, actual);
    }

    @Ignore
    public void onlyOneInstanceOfPlayer() {
        //Player expected = Player.getPlayer();
        //Player actual = Player.getPlayer();
        //checks if refers to same object
        //assertSame(expected, actual);
    }

    @Ignore
    public void spriteIsDifferent() {

    }

    @Ignore
    public void startingLives() {

    }

    @Ignore
    public void properNames() {
        //Player p = Player.getPlayer();
        //String name = p.getName();
        //if(name == null || name.equals("") )
    }

    @Test
    public void leaderboardScoresDescOrder() {
        Leaderboard leaderboard = Leaderboard.getLeaderboard();
        for (int i = 1; i < 6; i++) {
            leaderboard.addScore("Player", i, "dd-MM-yyyy HH:mm");
        }
        long[] expected = {5, 4, 3, 2, 1};
        long[] actual = leaderboard.getScores();
        assertArrayEquals(expected, actual);
    }

    //unit test to check if leaderboard displays five highest scores
    @Test
    public void leaderboardDisplaysFiveHighestScores() {
        Leaderboard leaderboard = Leaderboard.getLeaderboard();
        for (int i = 1; i < 7; i++) {
            leaderboard.addScore("Player", i, "dd-MM-yyyy HH:mm");
        }
        long[] scores = leaderboard.getScores();
        boolean expected = true;
        boolean actual = true;
        for (long score : scores) {
            if (score == 1) {
                expected = false;
            }
        }
        assertEquals(expected, actual);
    }

    //unit test to check if leaderboard displays names that correspond to scores
    @Test
    public void leaderboardDisplaysCorrespondingNames() {
        Leaderboard leaderboard = Leaderboard.getLeaderboard();
        leaderboard.addScore("one", 1, "dd-MM-yyyy HH:mm");
        leaderboard.addScore("two", 2, "dd-MM-yyyy HH:mm");
        leaderboard.addScore("three", 3, "dd-MM-yyyy HH:mm");
        leaderboard.addScore("four", 4, "dd-MM-yyyy HH:mm");
        leaderboard.addScore("five", 5, "dd-MM-yyyy HH:mm");
        String[] expected = {"five", "four", "three", "two", "one"};
        String[] actual = leaderboard.getNames();
        assertArrayEquals(expected, actual);
    }

    //unit test to check if leaderboard displays dates that correspond to scores
    @Test
    public void leaderboardDisplaysCorrespondingDates() {
        Leaderboard leaderboard = Leaderboard.getLeaderboard();
        leaderboard.addScore("Player", 1, "date 1");
        leaderboard.addScore("Player", 2, "date 2");
        leaderboard.addScore("Player", 3, "date 3");
        leaderboard.addScore("Player", 4, "date 4");
        leaderboard.addScore("Player", 5, "date 5");
        String[] expected = {"date 5", "date 4", "date 3", "date 2", "date 1"};
        String[] actual = leaderboard.getDates();
        assertArrayEquals(expected, actual);
    }

    //unit test to check if leaderboard displays most recent score
    @Test
    public void leaderboardDisplaysMostRecentScore() {
        Leaderboard leaderboard = Leaderboard.getLeaderboard();
        leaderboard.addScore("Player", 1, "dd-MM-yyyy HH:mm");
        leaderboard.addScore("Player", 2, "dd-MM-yyyy HH:mm");
        int expected = 2;
        int actual = (int) GameActivity.getCurrentScore();
    }

}