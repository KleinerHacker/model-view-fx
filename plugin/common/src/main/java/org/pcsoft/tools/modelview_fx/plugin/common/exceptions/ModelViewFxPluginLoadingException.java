package org.pcsoft.tools.modelview_fx.plugin.common.exceptions;

/**
 * Created by Christoph on 19.10.2014.
 */
public abstract class ModelViewFxPluginLoadingException extends ModelViewFxPluginException {

    protected ModelViewFxPluginLoadingException() {
    }

    protected ModelViewFxPluginLoadingException(String message) {
        super(message);
    }

    protected ModelViewFxPluginLoadingException(String message, Throwable cause) {
        super(message, cause);
    }

    protected ModelViewFxPluginLoadingException(Throwable cause) {
        super(cause);
    }
}
