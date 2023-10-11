package com.cs2340.armadillo;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;

public class Leaderboard {

    private int lowest;
    private int size;
    private String[] names = new String[5];
    private int[] scores = new int[5];
    private String[] dates = new String[5];
    private static Leaderboard leaderboard;

    private Leaderboard() {
        for (int i = 0; i < 5; i++) {
            names[i] = "-----";
            scores[i] = 0;
            dates[i] = "";
        }
        lowest = scores[4];
        size = 0;
    }

    public static Leaderboard getLeaderboard() {
        if (leaderboard == null) {
            leaderboard = new Leaderboard();
        }
        return leaderboard;
    }

    public String[] getNames() {
        return names;
    }

    public int[] getScores() {
        return scores;
    }

    public String[] getDates() {
        return dates;
    }

    public void addScore(String playerName, int score, String date) {
        if (size < 5) {
            scores[size] = score;
            names[size] = playerName;
            dates[size] = date;

            for (int i = size; i > 0; i--) {
                if (scores[i - 1] < score) {
                    int tempScore = scores[i - 1];
                    String tempName = names[i-1];
                    String tempDate = dates[i - 1];

                    scores[i-1] = score;
                    names[i-1] = playerName;
                    dates[i - 1] = date;
                    scores[i] = tempScore;
                    names[i] = tempName;
                    dates[i] = tempDate;
                } else {
                    break;
                }
            }
            lowest = scores[size];
            size++;
        } else if (size >= 5) {
            if (score > lowest) {
                scores[4] = score;
                names[4] = playerName;
                dates[4] = date;
                for (int i = 4; i > 0; i--) {
                    if (scores[i - 1] < score) {
                        int tempScore = scores[i - 1];
                        String tempName = names[i-1];
                        String tempDate = dates[i - 1];

                        scores[i-1] = score;
                        names[i-1] = playerName;
                        dates[i - 1] = date;
                        scores[i] = tempScore;
                        names[i] = tempName;
                        dates[i] = tempDate;
                    } else {
                        break;
                    }
                }
                lowest = scores[4];
            }
        }
    }

}
