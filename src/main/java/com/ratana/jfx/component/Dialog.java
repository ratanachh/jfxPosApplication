package com.ratana.jfx.component;

import com.ratana.jfx.utils.ViewUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

    public void show() {
        stage.show();
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
