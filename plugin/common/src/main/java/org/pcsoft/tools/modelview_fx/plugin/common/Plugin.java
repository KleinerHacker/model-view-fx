package org.pcsoft.tools.modelview_fx.plugin.common;

/**
 * Created by Christoph on 29.10.2014.
 */
public interface Plugin<I> {
    String getId();
    String getName();
    I getInstance();
}
