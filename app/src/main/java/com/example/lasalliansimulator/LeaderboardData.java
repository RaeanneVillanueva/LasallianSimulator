package com.example.lasalliansimulator;

import java.util.ArrayList;

public class LeaderboardData {

    private int rank;
    private String name, score;

    public LeaderboardData(int rank, String name, String score) {
        this.rank = rank;
        this.name = name;
        this.score = score;
    }

    public int getRank() { return rank; }
    public String getName() { return  name; }
    public String getScore() { return score; }

}
