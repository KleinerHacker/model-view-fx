package org.pcsoft.tools.modelview_fx.plugin.model_loader.api.types;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Christoph on 17.11.2014.
 */
public final class ModelResult {

    private final Map<String, MeshItem> meshMap;
    private final Map<String, ImageItem> imageMap;
    private final Map<String, MaterialItem> materialMap;

    public ModelResult(Map<String, MeshItem> meshMap, Map<String, ImageItem> imageMap, Map<String, MaterialItem> materialMap) {
        this.meshMap = meshMap;
        this.imageMap = imageMap;
        this.materialMap = materialMap;
    }

    public Map<String, MeshItem> getMeshMap() {
        return meshMap;
    }

    public List<MeshItem> getMeshList() {
        return new ArrayList<>(meshMap.values());
    }

    public Map<String, ImageItem> getImageMap() {
        return imageMap;
    }

    public List<ImageItem> getImageList() {
        return new ArrayList<>(imageMap.values());
    }

    public Map<String, MaterialItem> getMaterialMap() {
        return materialMap;
    }

    public List<MaterialItem> getMaterialList() {
        return new ArrayList<>(materialMap.values());
    }
}
