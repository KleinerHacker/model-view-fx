package org.pcsoft.tools.modelview_fx.plugin.common.exceptions;

import org.pcsoft.tools.modelview_fx.common.exceptions.ModelViewFxException;

/**
 * Created by Christoph on 19.10.2014.
 */
public abstract class ModelViewFxPluginException extends ModelViewFxException {

    protected ModelViewFxPluginException() {
    }

    protected ModelViewFxPluginException(String message) {
        super(message);
    }

    protected ModelViewFxPluginException(String message, Throwable cause) {
        super(message, cause);
    }

    protected ModelViewFxPluginException(Throwable cause) {
        super(cause);
    }
}
