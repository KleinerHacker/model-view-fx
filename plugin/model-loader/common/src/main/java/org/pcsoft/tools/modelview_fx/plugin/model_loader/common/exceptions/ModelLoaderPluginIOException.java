package org.pcsoft.tools.modelview_fx.plugin.model_loader.common.exceptions;

import org.pcsoft.tools.modelview_fx.plugin.common.exceptions.ModelViewFxPluginIOException;

/**
 * Created by Christoph on 16.11.2014.
 */
public class ModelLoaderPluginIOException extends ModelViewFxPluginIOException {

    public ModelLoaderPluginIOException() {
    }

    public ModelLoaderPluginIOException(String message) {
        super(message);
    }

    public ModelLoaderPluginIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModelLoaderPluginIOException(Throwable cause) {
        super(cause);
    }
}
