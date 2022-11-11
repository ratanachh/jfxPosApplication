package com.ratana.jfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {

    @FXML
    private Button closeBtn;
    @FXML
    private Button loginBtn;
    @FXML
    private Label message;
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;

    @FXML
    private void close() {
        loginBtn.getScene().getWindow().hide();
    }

    @FXML
    private void login() {

    }


    public static void loadView(Stage stage) throws IOException {
        Parent view = FXMLLoader.load(Objects.requireNonNull(LoginController.class.getResource("/view/login.fxml")));
        stage.setScene(new Scene(view));
        stage.show();
    }
}
