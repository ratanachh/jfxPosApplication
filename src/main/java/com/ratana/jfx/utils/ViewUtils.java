package com.ratana.jfx.utils;

import com.ratana.jfx.Launcher;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewUtils {

    public static void centerScreen(Stage stage) {
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }

    public static FXMLLoader getViewLoader(String viewName) {
        return new FXMLLoader(Launcher.class.getResource(String.format("/view/%s", viewName)));
    }

    public static FXMLLoader getComponentViewLoader(String viewName) {
        return new FXMLLoader(Launcher.class.getResource(String.format("/view/component/%s", viewName)));
    }

    public static Parent getView(String viewName) throws IOException {
        return getViewLoader(viewName).load();
    }
}
