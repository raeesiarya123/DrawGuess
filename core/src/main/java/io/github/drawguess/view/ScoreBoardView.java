package io.github.drawguess.view;

import com.github.czyzby.autumn.mvc.stereotype.View;
import com.github.czyzby.lml.annotation.LmlAction;
import com.github.czyzby.lml.parser.action.ActionContainer;

import io.github.drawguess.model.GameSession;

@View(id = "scoreboard", value = "ui/templates/scoreboard.lml")
public class ScoreBoardView implements ActionContainer, GameState {

    private GameSession gameSession;

    public ScoreBoardView(GameSession gameSession) {
        this.gameSession = gameSession;
    }

    @Override
    public void enterState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enterState'");
    }

    @Override
    public void handleAction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleAction'");
    }
    
} 