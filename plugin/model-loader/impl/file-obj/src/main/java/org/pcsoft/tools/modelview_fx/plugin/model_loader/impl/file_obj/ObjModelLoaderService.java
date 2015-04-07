package org.pcsoft.tools.modelview_fx.plugin.model_loader.impl.file_obj;

import com.interactivemesh.jfx.importer.FilePath;
import com.interactivemesh.jfx.importer.obj.ObjModelImporter;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import org.pcsoft.tools.modelview_fx.plugin.model_loader.api.ModelLoaderService;
import org.pcsoft.tools.modelview_fx.plugin.model_loader.api.annotations.ModelLoaderDescription;
import org.pcsoft.tools.modelview_fx.plugin.model_loader.api.types.ImageItem;
import org.pcsoft.tools.modelview_fx.plugin.model_loader.api.types.MaterialItem;
import org.pcsoft.tools.modelview_fx.plugin.model_loader.api.types.MeshItem;
import org.pcsoft.tools.modelview_fx.plugin.model_loader.api.types.ModelResult;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Christoph on 16.11.2014.
 */
@ModelLoaderDescription(id = "obj", name = "OBJ Model Loader", description = "Load *.obj files", fileExtension = "*.obj")
public class ObjModelLoaderService implements ModelLoaderService {

    @Override
    public ModelResult loadModel(File file) {
        final ObjModelImporter modelImporter = new ObjModelImporter();
        modelImporter.read(file);

        final Map<String, MeshItem> meshMap = new LinkedHashMap<>();
        final Map<String, MeshView> namedMeshViews = modelImporter.getNamedMeshViews();
        if (namedMeshViews != null) {
            for (final String name : namedMeshViews.keySet()) {
                meshMap.put(name, new MeshItem(name, namedMeshViews.get(name)));
            }
        }

        final Map<String, ImageItem> imageMap = new LinkedHashMap<>();
        final Map<Image, FilePath> imageFilePaths = modelImporter.getImageFilePaths();
        if (imageFilePaths != null) {
            for (final Image image : imageFilePaths.keySet()) {
                final FilePath filePath = imageFilePaths.get(image);
                imageMap.put(filePath.getAbsolutePath().toString(),
                        new ImageItem(filePath.getAbsolutePath().toString(), filePath.getImportedPath(), image));
            }
        }

        final Map<String, MaterialItem> materialMap = new LinkedHashMap<>();
        final Map<String, PhongMaterial> namedMaterials = modelImporter.getNamedMaterials();
        if (namedMaterials != null) {
            for (final String name : namedMaterials.keySet()) {
                materialMap.put(name, new MaterialItem(name, namedMaterials.get(name)));
            }
        }

        modelImporter.close();

        return new ModelResult(meshMap, imageMap, materialMap);
    }
}
