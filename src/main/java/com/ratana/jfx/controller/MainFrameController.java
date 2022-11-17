package com.ratana.jfx.controller;

import com.ratana.jfx.Launcher;
import com.ratana.jfx.component.Dialog;
import com.ratana.jfx.utils.Menu;
import com.ratana.jfx.utils.ViewUtils;
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

@Controller
public class MainFrameController {
    @FXML
    private VBox sidebar;
    @FXML
    private StackPane contentView;

    private Menu selectedMenuItem;

    @FXML
    private void initialize() {
        loadView(Menu.Home);
    }

    @FXML
    private void clickMenu(MouseEvent event) {
        Node node = (Node) event.getSource();
        if (node.getId().equals("exit")) {
            Dialog.DialogBuilder
                .builder()
                .title("Confirm")
                .message("Do you want to exit program?")
                .okActionListener(() -> sidebar.getScene().getWindow().hide())
                .build().show();
        } else {
            loadView(Menu.valueOf(CaseUtils.toCamelCase(node.getId(), true)));
        }
    }

    private void loadView(Menu menu)  {
        try {
            if (menu.equals(selectedMenuItem)) {
                return;
            }

            for (Node node : sidebar.getChildren()) {
                if (node.getId().equals(CaseUtils.toCamelCase(menu.name(), false))) {
                    node.getStyleClass().add("active");
                } else {
                    node.getStyleClass().remove("active");
                }
            }
            FXMLLoader loader = ViewUtils.getViewLoader(menu.getFxml());
            loader.setControllerFactory(Launcher.getApplicationContext()::getBean);
            Parent view = loader.load();
            AbstractController controller = loader.getController();
            controller.setTitle(menu);
            selectedMenuItem = menu;
            contentView.getChildren().clear();
            contentView.getChildren().add(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void show() {
        try {
            Stage stage = new Stage();
            Parent root = ViewUtils.getView("mainFrame.fxml");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
