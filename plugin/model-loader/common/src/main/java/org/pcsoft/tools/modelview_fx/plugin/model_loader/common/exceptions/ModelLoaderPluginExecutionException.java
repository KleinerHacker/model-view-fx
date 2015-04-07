package org.pcsoft.tools.modelview_fx.plugin.model_loader.common.exceptions;

import org.pcsoft.tools.modelview_fx.plugin.common.exceptions.ModelViewFxPluginExecutionException;

/**
 * Created by Christoph on 16.11.2014.
 */
public class ModelLoaderPluginExecutionException extends ModelViewFxPluginExecutionException {

    public ModelLoaderPluginExecutionException() {
    }

    public ModelLoaderPluginExecutionException(String message) {
        super(message);
    }

    public ModelLoaderPluginExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModelLoaderPluginExecutionException(Throwable cause) {
        super(cause);
    }
}
