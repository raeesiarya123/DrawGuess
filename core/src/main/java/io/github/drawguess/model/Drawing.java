package io.github.drawguess.model;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class Drawing {
    private int drawingID;
    private String vectorData;
    private Date submissionTime;
    private String guessWord;

    
    
    public Drawing(int drawingID, String vectorData, Date submissionTime, Words wordsList) {
        this.drawingID = drawingID;
        this.vectorData = vectorData;
        this.submissionTime = submissionTime;
        List<String> words = wordsList.getWords();

        if (words.isEmpty()) {
            throw new IllegalArgumentException("No more words"); 
        }
        
        Random random = new Random();
        int index = random.nextInt(words.size()); // Trekker et tilfeldig indeksnummer
        this.guessWord = words.remove(index); // Fjerner og returnerer ordet
    }

    // Getter for drawingID
    public int getDrawingID() {
        return drawingID;
    }

    // Setter for drawingID
    public void setDrawingID(int drawingID) {
        this.drawingID = drawingID;
    }

    // Getter for vectorData
    public String getVectorData() {
        return vectorData;
    }

    // Setter for vectorData
    public void setVectorData(String vectorData) {
        this.vectorData = vectorData;
    }

    // Getter for submissionTime
    public Date getSubmissionTime() {
        return submissionTime;
    }

    // Setter for submissionTime
    public void setSubmissionTime(Date submissionTime) {
        this.submissionTime = submissionTime;
    }

    public String getGuessWord() {
        // Implementation
        return guessWord;
    }
} 