package org.pcsoft.tools.modelview_fx.ui.window.main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Christoph on 12.11.2014.
 */
public final class MainWindow {

    public static void show(final Stage rootStage, final Stage splashStage) {
        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(cl -> {
                try {
                    return cl.newInstance();
                } catch (Exception e) {
                    try {
                        return cl.getConstructor(Stage.class).newInstance(rootStage);
                    } catch (Exception e1) {
                        throw new RuntimeException(e1);
                    }
                }
            });
            loader.setLocation(Thread.currentThread().getContextClassLoader().getResource("fxml/window.main.fxml"));
            final Pane pane = loader.load();

            rootStage.setScene(new Scene(pane));
            rootStage.getIcons().add(new Image(Thread.currentThread().getContextClassLoader().getResourceAsStream("icon.png")));
            rootStage.setOnShowing(e -> splashStage.close());

            rootStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private MainWindow() {
    }
}
