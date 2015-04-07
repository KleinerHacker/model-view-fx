package org.pcsoft.tools.modelview_fx.plugin.model_loader.api;

import org.pcsoft.tools.modelview_fx.plugin.model_loader.api.types.ModelResult;

import java.io.File;

/**
 * Created by Christoph on 16.11.2014.
 */
public interface ModelLoaderService {

    ModelResult loadModel(File file);

}
