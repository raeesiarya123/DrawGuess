package io.github.drawguess.view;

import io.github.drawguess.model.GameSession;

public interface GameState {
    void enterState();
    void handleAction();
} 