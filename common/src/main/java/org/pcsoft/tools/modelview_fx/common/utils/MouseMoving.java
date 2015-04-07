package org.pcsoft.tools.modelview_fx.common.utils;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Created by Christoph on 16.11.2014.
 */
public final class MouseMoving {

    private final SimpleDoubleProperty x = new SimpleDoubleProperty(-1), y = new SimpleDoubleProperty(-1);
    private final ReadOnlyDoubleWrapper relativeX = new ReadOnlyDoubleWrapper(0), relativeY = new ReadOnlyDoubleWrapper(0);

    public MouseMoving() {
        x.addListener((v, o, n) -> {
            if (o.doubleValue() < 0 || n.doubleValue() < 0)
                return;

            relativeX.set(o.doubleValue() - n.doubleValue());
        });
        y.addListener((v, o, n) -> {
            if (o.doubleValue() < 0 || n.doubleValue() < 0)
                return;

            relativeY.set(o.doubleValue() - n.doubleValue());
        });
    }

    public void startMouseMoving() {
        setX(-1);
        setY(-1);
    }

    public void onMouseMoving(double x, double y) {
        setX(x);
        setY(y);
    }

    public void finishMouseMoving() {

    }

    public double getX() {
        return x.get();
    }

    public SimpleDoubleProperty xProperty() {
        return x;
    }

    public void setX(double x) {
        this.x.set(x);
    }

    public double getY() {
        return y.get();
    }

    public SimpleDoubleProperty yProperty() {
        return y;
    }

    public void setY(double y) {
        this.y.set(y);
    }

    public double getRelativeX() {
        return relativeX.get();
    }

    public ReadOnlyDoubleProperty relativeXProperty() {
        return relativeX.getReadOnlyProperty();
    }

    public double getRelativeY() {
        return relativeY.get();
    }

    public ReadOnlyDoubleProperty relativeYProperty() {
        return relativeY.getReadOnlyProperty();
    }
}
