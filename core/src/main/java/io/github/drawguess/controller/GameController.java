package io.github.drawguess.controller;

import com.github.czyzby.autumn.annotation.Inject;
import com.github.czyzby.autumn.mvc.stereotype.ViewActionContainer;
import io.github.drawguess.model.GameSession;

@ViewActionContainer("game")
public class GameController {
    private GameSession gameSession;

    public void startGame() {
        // Start a new game session
    }

    public void processGuess(String guess) {
        // Handle guess processing
    }

    public void updateModel() {
        // Update game state/model
    }
} 