package io.github.drawguess;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;

import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import com.badlogic.gdx.backends.iosrobovm.IOSApplicationConfiguration;
import com.github.czyzby.autumn.mvc.application.AutumnApplication;
import com.github.czyzby.autumn.scanner.FixedClassScanner;
import io.github.drawguess.DrawGuessMain;

/** Launches the iOS (RoboVM) application. */
public class IOSLauncher extends IOSApplication.Delegate {
    @Override
    protected IOSApplication createApplication() {
        IOSApplicationConfiguration configuration = new IOSApplicationConfiguration();
        // Note: there is currently no automatic classpath scanning support on iOS. You have to register all component
        // classes manually with FixedClassScanner. Generated template might not work out of the box because of this.
        return new IOSApplication(new AutumnApplication(new FixedClassScanner(DrawGuessMain.class),
            DrawGuessMain.class), configuration);
    }

    public static void main(String[] argv) {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(argv, null, IOSLauncher.class);
        pool.close();
    }
}