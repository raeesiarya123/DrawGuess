package io.github.drawguess.model;

import io.github.drawguess.controller.GameController;
import io.github.drawguess.controller.PlayerController;
import io.github.drawguess.controller.PlayerFactory;
import io.github.drawguess.view.*;
import java.util.ArrayList;
import java.util.List;

public class GameSession {
    private int sessionID;
    private String status;
    private GameState currentState;
    private List<Player> players = new ArrayList<>();
    private ScoreBoard scores;
    
    public GameSession() {
        // Initialize session with waiting for players state
        this.currentState = new WaitingForPlayers(this);
        this.scores = new ScoreBoard();
        this.currentState.enterState();
    }
    
    public void addPlayer(Player player) {
        players.add(player);
        scores.addPlayer(player);
    }
    
    public void removePlayer(Player player) {
        players.remove(player);
        // Update state
    }
    
    public void changeState(GameState newState) {
        this.currentState = newState;
        this.currentState.enterState();
    }
    
    public List<Player> getPlayers() {
        return players;
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public void prepareNewDrawingPhase() {
        // Select new random drawer from available players
        PlayerFactory.assignRandomDrawer(this.players);
        
        // Change to drawing phase
        changeState(new DrawingPhase(this));
    }

    public ScoreBoard getScoreBoard() {
        return scores;
    }

    public static void main(String[] args) {
        User u1 = new User(0, "ben", null);
        User u2 = new User(1, "isak", null);
        User u3 = new User(2, "arya", null);
        User u4 = new User(3, "jacob", null);

        GameController gc = GameController.getInstance();
        PlayerController pc = PlayerController.getInstance();
        
        

        gc.startLobby(u1);
        pc.handlePlayerJoin(u2);
        pc.handlePlayerJoin(u3);
        pc.handlePlayerJoin(u4);
        gc.startScoreBoardPhase();

    }
    
} 