package org.pcsoft.tools.modelview_fx.ui.utils;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import org.pcsoft.tools.modelview_fx.common.utils.MouseMoving;

/**
 * Created by Christoph on 16.11.2014.
 */
public final class ObjectTranslator {

    private static double calculateMinimumCameraDistance(Bounds bounds) {
        return Math.min(bounds.getWidth(), Math.min(bounds.getHeight(), bounds.getDepth())) * -3;
    }

    private final SimpleDoubleProperty rotateYValue = new SimpleDoubleProperty(0);
    private final SimpleDoubleProperty rotateXValue = new SimpleDoubleProperty(0);
    private final SimpleDoubleProperty zoomValue = new SimpleDoubleProperty(0);
    private final SimpleDoubleProperty translateYValue = new SimpleDoubleProperty(0);

    private final Node camera, object;
    private final MouseMoving mouseMoving = new MouseMoving();

    public ObjectTranslator(Node camera, Node object) {
        this.camera = camera;
        this.object = object;

        final double minDistance = calculateMinimumCameraDistance(this.object.getBoundsInLocal());
        this.zoomValue.set(minDistance);
        this.translateYValue.set(minDistance / (2 * 3));

        final Rotate rotateY = new Rotate(rotateYValue.get(), Rotate.Y_AXIS);
        final Rotate rotateX = new Rotate(rotateXValue.get(), Rotate.X_AXIS);
        final Translate translate = new Translate(0, -translateYValue.get(), 0);
        this.object.getTransforms().addAll(translate, rotateY, rotateX);

        this.camera.translateZProperty().bind(zoomValue);
        rotateY.angleProperty().bind(rotateYValue);
        rotateX.angleProperty().bind(rotateXValue);
        translate.yProperty().bind(translateYValue.negate());

        this.mouseMoving.relativeXProperty().addListener((v, o, n) -> {
            rotateYValue.set(rotateYValue.get() + n.doubleValue() * 0.1);
        });
        this.mouseMoving.relativeYProperty().addListener((v, o, n) -> {
            rotateXValue.set(rotateXValue.get() - n.doubleValue() * 0.1);
        });
    }

    public void resetTranslation() {
        final double minDistance = calculateMinimumCameraDistance(this.object.getBoundsInLocal());
        this.zoomValue.set(minDistance);
        this.translateYValue.set(minDistance / (2 * 3));
        this.rotateXValue.set(0);
        this.rotateYValue.set(0);
    }

    public void startMouseMoving() {
        mouseMoving.startMouseMoving();
    }

    public void onMouseMoving(double x, double y) {
        mouseMoving.onMouseMoving(x, y);
    }

    public void finishMouseMoving() {
        mouseMoving.finishMouseMoving();
    }

    public void mouseScroll(double delta) {
        this.zoomValue.set(this.zoomValue.get() + delta * 0.01);
    }
}
