package org.pcsoft.tools.modelview_fx.plugin.model_loader.core;

import org.pcsoft.tools.modelview_fx.plugin.common.Plugin;
import org.pcsoft.tools.modelview_fx.plugin.model_loader.api.ModelLoaderService;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by Christoph on 16.11.2014.
 */
public final class ModelLoaderPlugin implements Plugin<ModelLoaderService> {

    private final String id, name, description;
    private final String[] fileExtensions;
    private final ModelLoaderService instance;

    public ModelLoaderPlugin(String id, String name, String description, String[] fileExtensions, ModelLoaderService instance) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.fileExtensions = fileExtensions;
        this.instance = instance;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ModelLoaderService getInstance() {
        return instance;
    }

    public String getDescription() {
        return description;
    }

    public String[] getFileExtensions() {
        return fileExtensions;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final ModelLoaderPlugin other = (ModelLoaderPlugin) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "ModelLoaderPlugin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", fileExtensions='" + Arrays.toString(fileExtensions) + '\'' +
                '}';
    }
}
