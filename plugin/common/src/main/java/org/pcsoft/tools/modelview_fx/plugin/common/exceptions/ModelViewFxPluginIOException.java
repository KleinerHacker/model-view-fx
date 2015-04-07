package org.pcsoft.tools.modelview_fx.plugin.common.exceptions;

/**
 * Created by Christoph on 19.10.2014.
 */
public abstract class ModelViewFxPluginIOException extends ModelViewFxPluginException {

    protected ModelViewFxPluginIOException() {
    }

    protected ModelViewFxPluginIOException(String message) {
        super(message);
    }

    protected ModelViewFxPluginIOException(String message, Throwable cause) {
        super(message, cause);
    }

    protected ModelViewFxPluginIOException(Throwable cause) {
        super(cause);
    }
}
