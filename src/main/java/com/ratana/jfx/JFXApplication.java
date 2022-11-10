package com.ratana.jfx;

import com.ratana.jfx.controller.LoginController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;


@Configuration
@SpringBootApplication
public class JFXApplication extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        applicationContext = SpringApplication.run(JFXApplication.class);
    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }

    @Override
    public void start(Stage stage) throws Exception {
        LoginController.loadView(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
