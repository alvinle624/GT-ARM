package com.cs2340.armadillo;

import java.util.Arrays;
public class Leaderboard {

    private String[] names = new String[5];
    private int[] scores = new int[5];
    private int lowest;
    private int size;
    private static Leaderboard leaderboard;

    private Leaderboard() {
        for (int i = 0; i < 5; i++) {
            names[i] = "-----";
            scores[i] = 0;
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

    private void addScore(String playerName, int score) {
        // Check if name already exists in score board

        if (Arrays.asList(names).contains(playerName)) {
            int index = 0;
            for (String name: names) {
                if (name.equals(playerName)) {
                    break;
                }
                index++;
            }
            names[index] = playerName;
            scores[index] = score;
        } else if (size < 5) {
            scores[size] = score;
            names[size] = playerName;

            for (int i = size; i > 0; i--) {
                if (scores[i - 1] < score) {
                    int tempScore = scores[i - 1];
                    String tempName = names[i-1];

                    scores[i-1] = score;
                    names[i-1] = playerName;
                    scores[i] = tempScore;
                    names[i] = tempName;
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
                for (int i = 4; i > 0; i--) {
                    if (scores[i - 1] < score) {
                        int tempScore = scores[i - 1];
                        String tempName = names[i-1];

                        scores[i-1] = score;
                        names[i-1] = playerName;
                        scores[i] = tempScore;
                        names[i] = tempName;
                    } else {
                        break;
                    }
                }
                lowest = scores[4];
            }
        }
    }

}
