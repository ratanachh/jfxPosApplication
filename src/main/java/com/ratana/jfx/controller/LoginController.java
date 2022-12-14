package com.ratana.jfx.controller;

import com.ratana.jfx.Launcher;
import com.ratana.jfx.exception.ServiceException;
import com.ratana.jfx.model.Account;
import com.ratana.jfx.service.AccountService;
import com.ratana.jfx.utils.ViewUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final AccountService accountService;
    private static Account loginUser;

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

    private void attachEvent() {
        username.getScene().setOnKeyPressed( event -> {
            if (event.getCode() == KeyCode.ENTER) {
                if (closeBtn.isFocused()) {
                    close();
                } else if (loginBtn.isFocused()) {
                    login();
                }
            }
        });
    }

    @FXML
    private void login() {
        try {
            loginUser = accountService.login(username.getText(), password.getText());

            // open main application
            MainFrameController.show();

            // close login view
            close();
        } catch (ServiceException e) {
            message.setText(e.getMessage());
        }catch (RuntimeException e) {
            e.printStackTrace();
            close();
        }
    }

    public static void loadView(Stage stage) throws IOException {
        FXMLLoader loader = ViewUtils.getViewLoader("login.fxml");
        loader.setControllerFactory(Launcher.getApplicationContext()::getBean);
        Parent view = loader.load();
        stage.setScene(new Scene(view));
        LoginController controller = loader.getController();
        controller.attachEvent();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        ViewUtils.centerScreen(stage);
    }
}
