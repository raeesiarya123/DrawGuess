package io.github.drawguess.view;

import io.github.drawguess.model.GameSession;

public class GuessingPhase implements GameState {
    private GameSession gameSession;
    
    public GuessingPhase(GameSession gameSession) {
        this.gameSession = gameSession;
    }
    
    @Override
    public void enterState() {
        // Display drawing and guessing interface
    }
    
    @Override
    public void handleAction() {
        // Process guesses and check for correct answers
    }
} 