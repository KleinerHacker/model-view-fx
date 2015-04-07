package org.pcsoft.tools.modelview_fx.plugin.common.exceptions;

/**
 * Created by Christoph on 19.10.2014.
 */
public abstract class ModelViewFxPluginExecutionException extends ModelViewFxPluginException {

    public ModelViewFxPluginExecutionException() {
    }

    public ModelViewFxPluginExecutionException(String message) {
        super(message);
    }

    public ModelViewFxPluginExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModelViewFxPluginExecutionException(Throwable cause) {
        super(cause);
    }
}
