package org.pcsoft.tools.modelview_fx.plugin.model_loader.api.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

/**
 * Created by Christoph on 16.11.2014.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={TYPE})
public @interface ModelLoaderDescription {

    /**
     * Unique id for plugin
     * @return
     */
    String id();

    String name();

    String description();

    String[] fileExtension();
}
