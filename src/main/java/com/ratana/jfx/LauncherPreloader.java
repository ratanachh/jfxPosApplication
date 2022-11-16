package com.ratana.jfx;

import com.ratana.jfx.utils.ViewUtils;
import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LauncherPreloader extends Preloader {

    private Stage preloadStage;

    @Override
    public void start(Stage stage) throws Exception {
        preloadStage = stage;
        stage.setScene(new Scene(ViewUtils.getView("preloader.fxml")));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        ViewUtils.centerScreen(stage);
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        if (info.getType() == StateChangeNotification.Type.BEFORE_START) {
            preloadStage.hide();
        }
    }
}
