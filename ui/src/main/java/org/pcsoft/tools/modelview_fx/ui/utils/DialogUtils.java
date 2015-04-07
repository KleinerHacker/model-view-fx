package org.pcsoft.tools.modelview_fx.ui.utils;

import javafx.stage.FileChooser;

import java.io.File;

/**
 * Created by Christoph on 17.11.2014.
 */
public final class DialogUtils {

    public static File showOpenPictureDialog() {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Portable Network Graphic", "*.png")
        );

        return fileChooser.showOpenDialog(null);
    }

    private DialogUtils() {
    }
}
