package io.github.drawguess.model;

import io.github.drawguess.view.GameState;
import io.github.drawguess.view.WaitingForPlayers;
import java.util.ArrayList;
import java.util.List;

public class GameSession {
    private int sessionID;
    private String status;
    private GameState currentState;
    private List<Player> players = new ArrayList<>();
    
    public GameSession() {
        // Initialize session with waiting for players state
        this.currentState = new WaitingForPlayers(this);
        this.currentState.enterState();
    }
    
    public void addPlayer(Player player) {
        players.add(player);
        // Update state
    }
    
    public void removePlayer(Player player) {
        players.remove(player);
        // Update state
    }
    
    public void changeState(GameState newState) {
        this.currentState = newState;
        this.currentState.enterState();
    }

    public int getSessionID(){
        return sessionID;
    }
    
    public List<Player> getPlayers() {
        return players;
    }
} 