package com.ratana.jfx;

import com.ratana.jfx.controller.LoginController;
import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;


@Configuration
@SpringBootApplication
public class Launcher extends Application {

    private static ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        applicationContext = SpringApplication.run(Launcher.class);
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
        LauncherImpl.launchApplication(Launcher.class, LauncherPreloader.class, args);
    }

    public static ConfigurableApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
