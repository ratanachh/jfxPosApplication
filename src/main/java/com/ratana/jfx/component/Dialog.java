package com.ratana.jfx.component;

import com.ratana.jfx.utils.ViewUtils;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class Dialog {
    @FXML
    private Label title;
    @FXML
    private Label message;
    @FXML
    private Button okButton;

    @FXML
    private void cancel() {
        okButton.getScene().getWindow().hide();
    }

    private Stage stage;

    public Dialog show() {
        stage.show();
        return this;
    }

    public void center(Window window) {
        double centerHeightDialog = stage.getHeight() / 2;
        double centerWidthDialog = stage.getWidth() / 2;

        double centerHeightWindow = window.getHeight() / 2;
        double centerWidthWindow = window.getWidth() / 2;

        double pointX = window.getX();
        double pointY = window.getY();
        stage.setX(pointX + (centerWidthWindow - centerWidthDialog));
        stage.setY(pointY + (centerHeightWindow - centerHeightDialog));
    }


    private void attachEvent() {
        stage.getScene().setOnKeyPressed( event -> {
            if (event.getCode() == KeyCode.ENTER) {
                if (okButton.isFocused()) {
                    Platform.exit();
                } else {
                    cancel();
                }
            }
        });
    }

    public static class DialogBuilder {
        private String title;
        private String message;

        private ActionListener okActionListener;

        private DialogBuilder() {
        }

        public static DialogBuilder builder() {
            return new DialogBuilder();
        }

        public DialogBuilder title(String title) {
            this.title = title;
            return this;
        }

        public DialogBuilder message(String message) {
            this.message = message;
            return this;
        }

        public DialogBuilder okActionListener(ActionListener okActionListener) {
            this.okActionListener = okActionListener;
            return this;
        }

        public Dialog build()  {
            try {
                Stage stage = new Stage(StageStyle.UNDECORATED);
                FXMLLoader loader = ViewUtils.getComponentViewLoader("dialog.fxml");

                Parent view = loader.load();
                stage.setScene(new Scene(view));

                Dialog controller = loader.getController();
                stage.initModality(Modality.APPLICATION_MODAL);
                controller.stage = stage;

                controller.title.setText(this.title);
                controller.message.setText(this.message);

                if (null != okActionListener) {
                    controller.okButton.setOnAction((e) -> {
                        controller.cancel();
                        okActionListener.doAction();
                    });
                } else {
                    controller.okButton.setVisible(false);
                }

                controller.attachEvent();

                return controller;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    public static interface ActionListener {
        void doAction();
    }
}
