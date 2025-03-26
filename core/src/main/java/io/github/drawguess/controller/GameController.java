package io.github.drawguess.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.github.czyzby.autumn.annotation.Inject;
import com.github.czyzby.autumn.mvc.stereotype.ViewActionContainer;
import io.github.drawguess.model.GameSession;
import io.github.drawguess.model.Player;
import io.github.drawguess.model.ScoreBoard;
import io.github.drawguess.view.*;
import io.github.drawguess.model.User;

@ViewActionContainer("game")
public class GameController {
    private static GameController instance;
    private GameSession gameSession;

    

    
    private GameController() {
        //Ensures singleton
    }

    // Statisk metode for å få tilgang til den eneste instansen av GameController
    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public void startLobby(User user) {
        this.gameSession = new GameSession();
        Player host = PlayerFactory.createPlayerFromUser(user, true);
        gameSession.addPlayer(host);
        PlayerController.getInstance().setGameSession(gameSession);
        gameSession.changeState(new WaitingForPlayers(gameSession));
    }
    

    public void startDrawingPhase() {
        gameSession.prepareNewDrawingPhase();
    }

    
    public void startGuessingPhase() {
        gameSession.changeState(new GuessingPhase(gameSession));
    }

    public void startScoreBoardPhase() {

        List<Player> players = gameSession.getPlayers();
    
        for (Player player : players) {
            System.out.println("Player: " + player.getUsername() + ", Score: " + player.getScore()); 
        }
    
        gameSession.changeState(new ScoreBoardView(gameSession));
    }

    public void endGame() {
        gameSession.changeState(new GameOver(gameSession));
    }

    
} 