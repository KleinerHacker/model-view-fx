package org.pcsoft.tools.modelview_fx.ui.splash;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.Desktop;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

class Controller implements Initializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @FXML
    private ProgressBar pbProgress;
    @FXML
    private Label lblVersion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void onMouseClickBackground(Event event) {

    }

    @FXML
    private void onActionBackgroundGraphic(ActionEvent actionEvent) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI("http://graphicburger.com"));
            } catch (Exception e) {
                LOGGER.error("Unknown error!", e);
                new Alert(Alert.AlertType.ERROR, "Cannot browse to url: " + e.getMessage(), ButtonType.OK).showAndWait();
            }
        }
    }

    @FXML
    private void onActionLicence(ActionEvent actionEvent) {
        //TODO
    }
}