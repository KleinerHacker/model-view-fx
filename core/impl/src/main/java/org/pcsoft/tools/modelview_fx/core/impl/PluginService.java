package org.pcsoft.tools.modelview_fx.core.impl;

import org.pcsoft.tools.modelview_fx.common.ModelviewFxConstants;
import org.pcsoft.tools.modelview_fx.plugin.model_loader.core.ModelLoaderPlugin;
import org.pcsoft.tools.modelview_fx.plugin.model_loader.core.ModelLoaderPluginManager;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by Christoph on 16.11.2014.
 */
public final class PluginService {

    private static final File PLUGIN_DIRECTORY = new File(ModelviewFxConstants.BASE_PATH, "plugins");
    private static final File PLUGIN_DIRECTORY_MODEL_LOADER = new File(PLUGIN_DIRECTORY, "model-loader");

    private static final ModelLoaderPluginManager MODEL_LOADER_PLUGIN_MANAGER = new ModelLoaderPluginManager(PLUGIN_DIRECTORY_MODEL_LOADER);

    public static Map<String, ModelLoaderPlugin> getModelLoaderPluginMap() {
        return MODEL_LOADER_PLUGIN_MANAGER.getPluginMap();
    }

    public static List<ModelLoaderPlugin> getModelLoaderPluginList() {
        return MODEL_LOADER_PLUGIN_MANAGER.getPluginList();
    }
}
