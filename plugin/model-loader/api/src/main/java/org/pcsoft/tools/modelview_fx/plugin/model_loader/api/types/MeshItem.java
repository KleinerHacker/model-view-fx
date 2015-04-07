package org.pcsoft.tools.modelview_fx.plugin.model_loader.api.types;

import javafx.scene.shape.Shape3D;

import java.util.Objects;

/**
 * Created by Christoph on 17.11.2014.
 */
public final class MeshItem {

    private final String name;
    private final Shape3D shape;

    public MeshItem(String name, Shape3D shape) {
        this.name = name;
        this.shape = shape;
    }

    public String getName() {
        return name;
    }

    public Shape3D getShape() {
        return shape;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final MeshItem other = (MeshItem) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return "MeshItem{" +
                "name='" + name + '\'' +
                '}';
    }
}
