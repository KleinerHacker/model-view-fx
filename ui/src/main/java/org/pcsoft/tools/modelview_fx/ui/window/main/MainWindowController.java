package org.pcsoft.tools.modelview_fx.ui.window.main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.pcsoft.tools.modelview_fx.plugin.model_loader.api.types.MaterialItem;
import org.pcsoft.tools.modelview_fx.plugin.model_loader.api.types.MeshItem;
import org.pcsoft.tools.modelview_fx.plugin.model_loader.api.types.ModelResult;
import org.pcsoft.tools.modelview_fx.plugin.model_loader.core.ModelLoaderPlugin;
import org.pcsoft.tools.modelview_fx.ui.utils.DialogUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Christoph on 15.11.2014.
 */
class MainWindowController implements Initializable {

    @FXML
    private ListView<MaterialItem> lstMaterials;
    @FXML
    private ListView<MeshItem> lstMeshes;

    @FXML
    private MainWindowMenuController menuController;
    @FXML
    private MainWindowSceneController sceneController;

    private final Stage parent;

    public MainWindowController(Stage parent) {
        this.parent = parent;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prepareLists();

        menuController.setActionListener(new MainWindowMenuController.ActionListener() {
            @Override
            public void onResetView() {
                sceneController.resetView();
            }

            @Override
            public void onLoadModel(File file, ModelLoaderPlugin plugin) {
                final ModelResult modelResult = plugin.getInstance().loadModel(file);

                lstMeshes.getItems().setAll(modelResult.getMeshList());
                lstMaterials.getItems().setAll(modelResult.getMaterialList());

                sceneController.setObjectModel(modelResult);
            }
        });
    }

    private void prepareLists() {
        lstMeshes.setCellFactory(param -> new ListCell<MeshItem>() {
            @Override
            protected void updateItem(MeshItem item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                    setContextMenu(null);
                } else {
                    setText(item.getName());
                    setContextMenu(buildContextMenu(item));
                }
            }

            private ContextMenu buildContextMenu(final MeshItem meshItem) {
                return null;
            }
        });
        lstMaterials.setCellFactory(param -> new ListCell<MaterialItem>() {
            @Override
            protected void updateItem(MaterialItem item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                    setContextMenu(null);
                } else {
                    setText(item.getName());
                    setContextMenu(buildContextMenu(item));
                }
            }

            private ContextMenu buildContextMenu(final MaterialItem materialItem) {
                if (!(materialItem.getMaterial() instanceof PhongMaterial))
                    return null;
                final PhongMaterial phongMaterial = (PhongMaterial) materialItem.getMaterial();

                final ContextMenu contextMenu = new ContextMenu();

                final MenuItem miDiffuse = new MenuItem("Set _diffuse texture...");
                miDiffuse.setOnAction(e -> {
                    final File file = DialogUtils.showOpenPictureDialog();
                    if (file != null) {
                        try {
                            phongMaterial.setDiffuseMap(new Image(FileUtils.openInputStream(file)));
                        } catch (IOException e1) {
                            e1.printStackTrace();//TODO
                        }
                    }
                });

                final MenuItem miSpecular = new MenuItem("Set _specular texture...");
                miSpecular.setOnAction(e -> {
                    final File file = DialogUtils.showOpenPictureDialog();
                    if (file != null) {
                        try {
                            phongMaterial.setSpecularMap(new Image(FileUtils.openInputStream(file)));
                        } catch (IOException e1) {
                            e1.printStackTrace();//TODO
                        }
                    }
                });

                final MenuItem miNormal = new MenuItem("Set _normal texture...");
                miNormal.setOnAction(e -> {
                    final File file = DialogUtils.showOpenPictureDialog();
                    if (file != null) {
                        try {
                            phongMaterial.setBumpMap(new Image(FileUtils.openInputStream(file)));
                        } catch (IOException e1) {
                            e1.printStackTrace();//TODO
                        }
                    }
                });

                contextMenu.getItems().addAll(miDiffuse, miNormal, miSpecular);

                return contextMenu;
            }
        });
    }
}
