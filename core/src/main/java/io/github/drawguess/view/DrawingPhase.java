package io.github.drawguess.view;

import io.github.drawguess.model.GameSession;
import io.github.drawguess.model.Drawing;

public class DrawingPhase implements GameState {
    private GameSession gameSession;
    
    public DrawingPhase(GameSession gameSession) {
        this.gameSession = gameSession;
    }
    
    @Override
    public void enterState() {
        // Setup drawing canvas and UI
    }
    
    @Override
    public void handleAction() {
        // Handle drawing inputs and timer
    }
} 