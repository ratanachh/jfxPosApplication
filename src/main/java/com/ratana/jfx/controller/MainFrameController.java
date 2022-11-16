package com.ratana.jfx.controller;

import com.ratana.jfx.Launcher;
import com.ratana.jfx.utils.Menu;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.commons.text.CaseUtils;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Objects;

@Controller
public class MainFrameController {
    @FXML
    private VBox sidebar;
    @FXML
    private StackPane contentView;

    private Menu currentMenu;

    @FXML
    private void initialize() {
        loadView(Menu.Home);
    }

    @FXML
    private void clickMenu(MouseEvent event) {
        Node node = (Node) event.getSource();
        if (node.getId().equals("exit")) {
            sidebar.getScene().getWindow().hide();
        } else {
            loadView(Menu.valueOf(CaseUtils.toCamelCase(node.getId(), true)));
        }
    }

    private void loadView(Menu menu)  {
        try {
            if (menu.equals(currentMenu)) {
                return;
            }
            FXMLLoader loader = new FXMLLoader(MainFrameController.class.getResource(String.format("/view/%s", menu.getFxml())));
            loader.setControllerFactory(Launcher.getApplicationContext()::getBean);
            currentMenu = menu;
            contentView.getChildren().clear();
            contentView.getChildren().add(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void show() {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(MainFrameController.class.getResource("/view/mainFrame.fxml")));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
