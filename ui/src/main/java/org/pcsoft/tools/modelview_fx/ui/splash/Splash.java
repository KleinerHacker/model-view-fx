package org.pcsoft.tools.modelview_fx.ui.splash;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Christoph on 12.11.2014.
 */
public final class Splash {

    private static final Logger LOGGER = LoggerFactory.getLogger(Splash.class);



    public static Stage show(boolean standAlone) {
        final Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);

        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(cl -> new Controller());
            loader.setLocation(Thread.currentThread().getContextClassLoader().getResource("fxml/splash.fxml"));
            final Pane pane = loader.load();

            stage.setScene(new Scene(pane));
            stage.show();

            return stage;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Splash() {
    }
}
