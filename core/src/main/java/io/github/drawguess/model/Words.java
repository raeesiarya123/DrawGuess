package io.github.drawguess.model;

import java.util.ArrayList;
import java.util.List;

public class Words {
    private List<String> words = new ArrayList<>();

    public List<String> getWords() {
        return words;
    }

    public void addWord(String word) {
        words.add(word);
    }

    public String removeWord(int index) {
        return words.remove(index);
    }

    
}
