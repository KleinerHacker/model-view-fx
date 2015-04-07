package org.pcsoft.tools.modelview_fx.plugin.model_loader.api.types;

import javafx.scene.paint.Material;

import java.util.Objects;

/**
 * Created by Christoph on 17.11.2014.
 */
public final class MaterialItem {

    private final String name;
    private final Material material;

    public MaterialItem(String name, Material material) {
        this.name = name;
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public Material getMaterial() {
        return material;
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
        final MaterialItem other = (MaterialItem) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return "MaterialItem{" +
                "name='" + name + '\'' +
                '}';
    }
}
