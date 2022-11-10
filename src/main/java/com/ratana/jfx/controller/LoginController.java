package com.ratana.jfx.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {

    public static void loadView(Stage stage) throws IOException {
        Parent view = FXMLLoader.load(Objects.requireNonNull(LoginController.class.getResource("/view/login.fxml")));
        stage.setScene(new Scene(view));
        stage.show();
    }
}
