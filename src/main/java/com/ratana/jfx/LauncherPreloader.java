package com.ratana.jfx;

import com.ratana.jfx.utils.ScreenUtils;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class LauncherPreloader extends Preloader {

    private Stage preloadStage;

    @Override
    public void start(Stage stage) throws Exception {
        preloadStage = stage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/preloader.fxml")));
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        ScreenUtils.centerScreen(stage);
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        if (info.getType() == StateChangeNotification.Type.BEFORE_START) {
            preloadStage.hide();
        }
    }
}
