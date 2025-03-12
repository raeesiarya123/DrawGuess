package io.github.drawguess.view;

import io.github.drawguess.model.GameSession;

public class GameMenu implements GameState {
    private GameSession gameSession;
    
    public GameMenu(GameSession gameSession) {
        this.gameSession = gameSession;
    }
    
    @Override
    public void enterState() {
        // Display game menu options
    }
    
    @Override
    public void handleAction() {
        // Process menu selections
    }
} 