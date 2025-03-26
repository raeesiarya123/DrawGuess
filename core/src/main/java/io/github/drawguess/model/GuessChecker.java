package io.github.drawguess.model;

import java.util.Date;
import java.util.Random;

public class GuessChecker {
    private static int guessAmount = 0;
    private int guessID;
    private String guessText;
    private boolean isCorrect;
    private Date guessTime;

    public GuessChecker() {
        guessAmount += 1;
    }
    
    public void validate(Player player, String answer, Drawing drawing, ScoreBoard scoreboard) {

        //Her må vi ha en form for tids logikk
        Random random = new Random();
        int randomNumber = random.nextInt(1001);
        
        String word = drawing.getGuessWord();
        if (answer == word) {
            scoreboard.updateScore(player, randomNumber);
        }
    }

    public static int getGuessAmount() {
        return guessAmount;
    }

    public static void setGuessAmount(int guessAmount) {
        GuessChecker.guessAmount = guessAmount;
    }

    
} 