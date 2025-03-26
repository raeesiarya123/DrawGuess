package io.github.drawguess.model;

public class Guesser extends Player {
    public Guesser(int id, String name, int score, String role, boolean host) {
        super(id, name, score, role, host);
    }
    
    // Guesser-specific methods here
    public void makeGuess(String guess, Drawing drawing, ScoreBoard scoreBoard) {
        GuessChecker guessChecker = new GuessChecker();
        guessChecker.validate(this, guess, drawing, scoreBoard);
    }
}
