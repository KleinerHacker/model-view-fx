package org.pcsoft.tools.modelview_fx.plugin.model_loader.core;

import org.pcsoft.tools.modelview_fx.plugin.common.AbstractPluginManager;
import org.pcsoft.tools.modelview_fx.plugin.common.exceptions.ModelViewFxPluginLoadingException;
import org.pcsoft.tools.modelview_fx.plugin.model_loader.api.ModelLoaderService;
import org.pcsoft.tools.modelview_fx.plugin.model_loader.api.annotations.ModelLoaderDescription;
import org.pcsoft.tools.modelview_fx.plugin.model_loader.common.exceptions.ModelLoaderPluginLoadingException;

import java.io.File;
import java.util.Map;

/**
 * Created by Christoph on 16.11.2014.
 */
public final class ModelLoaderPluginManager extends AbstractPluginManager<ModelLoaderService, ModelLoaderPlugin, ModelLoaderDescription> {

    public ModelLoaderPluginManager(File pluginPath) {
        super(pluginPath, ModelLoaderService.class, ModelLoaderDescription.class);
    }

    @Override
    protected ModelViewFxPluginLoadingException buildLoadingException(String message) {
        return new ModelLoaderPluginLoadingException(message);
    }

    @Override
    protected void putPlugin(Map<String, ModelLoaderPlugin> pluginMap, ModelLoaderDescription annotation, ModelLoaderService instance) {
        pluginMap.put(annotation.id(), new ModelLoaderPlugin(
                annotation.id(), annotation.name(), annotation.description(), annotation.fileExtension(), instance
        ));
    }
}
