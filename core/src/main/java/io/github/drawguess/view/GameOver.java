package io.github.drawguess.view;

import io.github.drawguess.model.GameSession;
import io.github.drawguess.model.ScoreBoard;

public class GameOver implements GameState {
    private GameSession gameSession;
    
    public GameOver(GameSession gameSession) {
        this.gameSession = gameSession;
    }
    
    @Override
    public void enterState() {
        // Display final scores and game results
    }
    
    @Override
    public void handleAction() {
        // Handle post-game options (play again, exit)
    }
} 