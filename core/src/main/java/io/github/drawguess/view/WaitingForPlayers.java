package io.github.drawguess.view;

import io.github.drawguess.model.GameSession;

public class WaitingForPlayers implements GameState {
    private GameSession gameSession;
    
    public WaitingForPlayers(GameSession gameSession) {
        this.gameSession = gameSession;
    }
    
    @Override
    public void enterState() {
        // Initialize waiting room UI
    }
    
    @Override
    public void handleAction() {
        // Handle player join/leave actions
    }
} 