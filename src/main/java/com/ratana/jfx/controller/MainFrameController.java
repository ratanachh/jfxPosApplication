package com.ratana.jfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.stereotype.Controller;

import java.util.Objects;

@Controller
public class MainFrameController {
    @FXML
    private VBox sidebar;
    @FXML
    private StackPane contentView;

    @FXML
    private void clickMenu(MouseEvent event) {
        Node node = (Node) event.getSource();
        System.out.println(node.getId() );
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
