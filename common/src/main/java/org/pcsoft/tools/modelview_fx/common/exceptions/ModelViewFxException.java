package org.pcsoft.tools.modelview_fx.common.exceptions;

/**
 * Created by Christoph on 12.11.2014.
 */
public abstract class ModelViewFxException extends RuntimeException {

    public ModelViewFxException() {
    }

    public ModelViewFxException(String message) {
        super(message);
    }

    public ModelViewFxException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModelViewFxException(Throwable cause) {
        super(cause);
    }
}
