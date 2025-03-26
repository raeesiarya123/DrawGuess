package io.github.drawguess.model;

public abstract class Player {
    private boolean host;
    private int playerID;
    private String username;
    private int score;
    private String role;
    private int timesAsDrawer;

    public Player(int playerID, String username, int score, String role, boolean host) {
        this.playerID = playerID;
        this.username = username;
        this.score = score;
        this.role = role;
        this.host = host;
        this.timesAsDrawer = 0;
    }

    public int getPlayerID() {
        return playerID;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }

    public boolean getHost() {
        return host;
    }

    public void setHost(boolean host) {
        this.host = host;
    }

    
    public int getTimesAsDrawer() {
        return timesAsDrawer;
    }

    public void incrementTimesAsDrawer() {
        this.timesAsDrawer++;
    }
    

    
} 