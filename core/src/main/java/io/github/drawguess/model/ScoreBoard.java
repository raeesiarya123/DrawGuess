package io.github.drawguess.model;

import java.util.HashMap;
import java.util.Map;

public class ScoreBoard {
    private Map<Player, Integer> scores = new HashMap<>();
    
    public void updateScore(Player player, int points) {
        scores.computeIfPresent(player, (existingPlayer, oldScore) -> oldScore + points);
    }
    
    public void addPlayer(Player player) {
        scores.putIfAbsent(player, player.getScore());
    }
    
    public Map<Player, Integer> getScoreBoard() {
        return scores;
    }
    
    public void resetScores() {
        scores.entrySet().forEach(entry -> entry.setValue(0));
    }

    
    
} 