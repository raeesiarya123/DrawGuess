package io.github.drawguess.controller;

import com.github.czyzby.autumn.annotation.Inject;
import com.github.czyzby.autumn.mvc.stereotype.ViewActionContainer;
import io.github.drawguess.model.Player;
import io.github.drawguess.model.User;
import io.github.drawguess.controller.PlayerFactory;
import io.github.drawguess.model.GameSession;
import io.github.drawguess.model.GuessChecker;
import io.github.drawguess.view.WaitingForPlayers;
import io.github.drawguess.view.GameOver;

import java.util.ArrayList;
import java.util.List;

@ViewActionContainer("player")
public class PlayerController {

    private static PlayerController instance;

    @Inject
    private GameSession gameSession;

    
    private PlayerController() {
        // Ensures singleton 
    }

    // Statisk metode for å få tilgang til den eneste instansen av PlayerController
    public static PlayerController getInstance() {
        if (instance == null) {
            instance = new PlayerController();
        }
        return instance;
    }

    public void handlePlayerJoin(User user) {
        Player new_player = PlayerFactory.createPlayerFromUser(user, false);
        gameSession.addPlayer(new_player);
    }

    public void handlePlayerLeave(int playerID) {
        Player playerToRemove = findPlayerById(playerID);
        if (playerToRemove != null) {
            gameSession.removePlayer(playerToRemove);
        }
    }

    public Player getPlayerInfo(int playerID) {
        return findPlayerById(playerID);
    }


    //Method for handling a players guess
   
    public void handlePlayerGuess(int playerID, String guess) {
        GuessChecker guessCheck = new GuessChecker();
        int guessAmount = GuessChecker.getGuessAmount();
        Player player = findPlayerById(playerID);
        if (player != null) {
            guessCheck.validate(player, guess, null, null);
        }

        if (guessAmount >= gameSession.getPlayers().size()) {
            GameController.getInstance().startScoreBoardPhase();
        }
    }

    public void setGameSession(GameSession gameSession) {
        this.gameSession = gameSession;
    }

    public List<Player> getAllPlayers() {
        return gameSession.getPlayers();
    }

    private Player findPlayerById(int playerID) {
        for (Player player : gameSession.getPlayers()) {
            if (player.getPlayerID() == playerID) {
                return player;
            }
        }
        return null;
    }



   

    
    
} 