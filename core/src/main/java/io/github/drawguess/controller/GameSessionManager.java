package io.github.drawguess.controller;

import io.github.drawguess.model.*;
import java.util.List;

public class GameSessionManager {
    private static GameSessionManager instance;
    private List<GameSession> sessions;

    private GameSessionManager() {}

    public static GameSessionManager getInstance() {
        if (instance == null) {
            instance = new GameSessionManager();
        }
        return instance;
    }

    public GameSession createSession() {
        GameSession session = new GameSession();
        sessions.add(session);
        return session;
    }

    public GameSession getSessionByID(int sessionID) {
        return sessions.stream().filter(s -> s.getSessionID() == sessionID).findFirst().orElse(null);
    }
}
