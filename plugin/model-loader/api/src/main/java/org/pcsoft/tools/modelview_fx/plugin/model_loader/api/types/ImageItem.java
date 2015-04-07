package org.pcsoft.tools.modelview_fx.plugin.model_loader.api.types;

import javafx.scene.image.Image;

import java.util.Objects;

/**
 * Created by Christoph on 17.11.2014.
 */
public final class ImageItem {

    private final String absolutePath, importPath;
    private final Image image;

    public ImageItem(String absolutePath, String importPath, Image image) {
        this.absolutePath = absolutePath;
        this.importPath = importPath;
        this.image = image;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public String getImportPath() {
        return importPath;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public int hashCode() {
        return Objects.hash(absolutePath, importPath);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final ImageItem other = (ImageItem) obj;
        return Objects.equals(this.absolutePath, other.absolutePath) && Objects.equals(this.importPath, other.importPath);
    }

    @Override
    public String toString() {
        return "ImageItem{" +
                "absolutePath='" + absolutePath + '\'' +
                ", importPath='" + importPath + '\'' +
                '}';
    }
}
