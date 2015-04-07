package org.pcsoft.tools.modelview_fx.ui.window.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.ArrayUtils;
import org.pcsoft.tools.modelview_fx.core.impl.PluginService;
import org.pcsoft.tools.modelview_fx.plugin.model_loader.core.ModelLoaderPlugin;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Christoph on 16.11.2014.
 */
class MainWindowMenuController implements Initializable {

    public static interface ActionListener {
        void onResetView();
        void onLoadModel(File file, ModelLoaderPlugin plugin);
    }

    private ActionListener actionListener;

    private final Stage parent;

    public MainWindowMenuController(Stage parent) {
        this.parent = parent;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    @FXML
    private void onActionOpen(ActionEvent actionEvent) {
        final FileChooser fileChooser = new FileChooser();
        for (final ModelLoaderPlugin plugin : PluginService.getModelLoaderPluginList()) {
            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter(plugin.getName(), plugin.getFileExtensions())
            );
        }

        final File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            final String extension = FilenameUtils.getExtension(file.getAbsolutePath());
            final ModelLoaderPlugin plugin = PluginService.getModelLoaderPluginList().stream()
                    .filter(item -> ArrayUtils.contains(item.getFileExtensions(), "*." + extension))
                    .findFirst().get();

            actionListener.onLoadModel(file, plugin);
        }
    }

    @FXML
    private void onActionExit(ActionEvent actionEvent) {
        parent.close();
    }

    @FXML
    private void onActionAbout(ActionEvent actionEvent) {

    }

    @FXML
    private void onActionReset(ActionEvent actionEvent) {
        actionListener.onResetView();
    }
}
