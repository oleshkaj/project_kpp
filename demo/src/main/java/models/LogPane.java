package models;

import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;

public class LogPane {

    public static HBox createLogPane() {
        HBox logPane = new HBox();

        // Поле для журналу подій
        TextArea logArea = new TextArea();
        logArea.setEditable(false);
        logArea.appendText("Simulation log:\n");

        logPane.getChildren().add(logArea);
        return logPane;
    }
}
