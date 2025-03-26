package io.github.drawguess.controller;

import io.github.drawguess.model.Drawer;
import io.github.drawguess.model.Guesser;
import io.github.drawguess.model.Player;
import io.github.drawguess.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerFactory {
    private static Random random = new Random();
    
    /**
     * Create a player from a user, initially as a Guesser
     */
    public static Player createPlayerFromUser(User user, boolean host) {
        return new Guesser(user.getUserID(), user.getUsername(), 0, "Guesser", host);
    }
    
    /**
     * Select a random drawer from players who haven't been drawer yet
     */
    public static void assignRandomDrawer(List<Player> players) {
        // Get list of players who haven't been drawer
        List<Player> availableDrawers = new ArrayList<>();
        for (Player player : players) {
            if (player.getTimesAsDrawer() == 0) {
                availableDrawers.add(player);
            }
        }
        
        if (availableDrawers.isEmpty()) {
            return; // No available drawers
        }
        
        // Reset all to Guessers first
        for (int i = 0; i < players.size(); i++) {
            Player oldPlayer = players.get(i);
            players.set(i, new Guesser(oldPlayer.getPlayerID(), 
                                     oldPlayer.getUsername(), 
                                     oldPlayer.getScore(), 
                                     "Guesser",
                                     oldPlayer.getHost()));
        }
        
        // Pick random available drawer
        int index = random.nextInt(availableDrawers.size());
        Player playerToMakeDrawer = availableDrawers.get(index);
        
        // Find and replace the chosen player with a Drawer instance
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getPlayerID() == playerToMakeDrawer.getPlayerID()) {
                Player newDrawer = new Drawer(player.getPlayerID(),
                                            player.getUsername(),
                                            player.getScore(),
                                            "Drawer",
                                            player.getHost());
                players.set(i, newDrawer);
                newDrawer.incrementTimesAsDrawer();
                break;
            }
        }
    }
}
 