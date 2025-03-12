package io.github.drawguess.gwt;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.github.czyzby.autumn.gwt.scanner.GwtClassScanner;
import com.github.czyzby.autumn.mvc.application.AutumnApplication;
import io.github.drawguess.DrawGuessMain;

/** Launches the GWT application. */
public class GwtLauncher extends GwtApplication {
    @Override
    public GwtApplicationConfiguration getConfig() {
        GwtApplicationConfiguration configuration = new GwtApplicationConfiguration(DrawGuessMain.WIDTH, DrawGuessMain.HEIGHT);
        return configuration;
    }

    @Override
    public ApplicationListener createApplicationListener() {
        return new AutumnApplication(new GwtClassScanner(), DrawGuessMain.class);
    }
}