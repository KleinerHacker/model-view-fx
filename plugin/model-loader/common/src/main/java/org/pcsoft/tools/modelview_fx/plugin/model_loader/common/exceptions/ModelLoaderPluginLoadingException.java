package org.pcsoft.tools.modelview_fx.plugin.model_loader.common.exceptions;

import org.pcsoft.tools.modelview_fx.plugin.common.exceptions.ModelViewFxPluginLoadingException;

/**
 * Created by Christoph on 16.11.2014.
 */
public class ModelLoaderPluginLoadingException extends ModelViewFxPluginLoadingException {

    public ModelLoaderPluginLoadingException() {
    }

    public ModelLoaderPluginLoadingException(String message) {
        super(message);
    }

    public ModelLoaderPluginLoadingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModelLoaderPluginLoadingException(Throwable cause) {
        super(cause);
    }
}
