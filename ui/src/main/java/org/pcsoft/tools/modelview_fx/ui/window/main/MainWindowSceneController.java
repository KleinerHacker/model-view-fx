package org.pcsoft.tools.modelview_fx.ui.window.main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SubScene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import org.pcsoft.tools.modelview_fx.plugin.model_loader.api.types.MeshItem;
import org.pcsoft.tools.modelview_fx.plugin.model_loader.api.types.ModelResult;
import org.pcsoft.tools.modelview_fx.ui.utils.ObjectTranslator;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Created by Christoph on 16.11.2014.
 */
class MainWindowSceneController implements Initializable {

    private static final double INIT_ROTATE = 0;
    private static final double INIT_ZOOM = 15;

    @FXML
    private SubScene scene;

    private Camera camera;
    private Group modelGroup;

    private ObjectTranslator objectTranslator;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prepareScene();
    }

    public void resetView() {
        objectTranslator.resetTranslation();
    }
    
    public void setObjectModel(ModelResult modelResult) {
        modelGroup.getChildren().setAll(modelResult.getMeshList().stream().map(MeshItem::getShape).collect(Collectors.toList()));
        resetView();
    }

    private void prepareScene() {
        final Box box = new Box(5, 5, 5);
        box.setMaterial(new PhongMaterial(Color.RED));
        box.setDrawMode(DrawMode.FILL);

        camera = new PerspectiveCamera(true);

        final Group root = new Group();
        root.getChildren().add(new Group(camera));
        modelGroup = new Group(box);
        root.getChildren().add(modelGroup);

        scene.setRoot(root);
        scene.setCamera(camera);

        objectTranslator = new ObjectTranslator(camera, modelGroup);
    }

    @FXML
    private void onMouseDragged(MouseEvent event) {
        objectTranslator.onMouseMoving(event.getSceneX(), event.getSceneY());
    }

    @FXML
    private void onMouseScroll(ScrollEvent event) {
        objectTranslator.mouseScroll(event.getDeltaY());
    }

    @FXML
    private void onMousePressed(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            objectTranslator.startMouseMoving();
        }
    }
}
