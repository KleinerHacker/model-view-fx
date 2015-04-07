package org.pcsoft.tools.modelview_fx.plugin.common;

import java.util.List;
import java.util.Map;

/**
 * Created by Christoph on 29.10.2014.
 */
public interface PluginManager<I, T extends Plugin<I>> {
    Map<String, T> getPluginMap();
    List<T> getPluginList();
}
