package io.github.drawguess.controller;

public class ScoreManager {
    public void updateScore(Player player, int points) {
        player.setScore(player.getScore() + points);
    }

    public List<Player> getHighScores() {
        // Retrieve high scores from the scoreboard
        return null;
    }
}
