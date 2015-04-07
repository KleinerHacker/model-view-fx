package org.pcsoft.tools.modelview_fx.app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.apache.commons.lang.SystemUtils;
import org.pcsoft.tools.modelview_fx.common.threading.ThreadRunner;
import org.pcsoft.tools.modelview_fx.ui.splash.Splash;
import org.pcsoft.tools.modelview_fx.ui.window.main.MainWindow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Christoph on 19.10.2014.
 */
public class Runner extends Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        LOGGER.info("Modelview FX - 2014");
        LOGGER.info("> Java Version: " + SystemUtils.JAVA_VERSION);

        launch(args);
    }

    @Override
    public void start(Stage rootStage) throws Exception {
        final Stage splashStage = Splash.show(false);

        ThreadRunner.submit("Modelview FX Startup", () -> {
            LOGGER.info("Initialize system...");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            LOGGER.info("> System initialized");
            Platform.runLater(() -> MainWindow.show(rootStage, splashStage));
        });
    }
}
