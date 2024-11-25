package models;

import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class MainPane {

    public static VBox createMainPane() {
        VBox mainPane = new VBox(10);

        // Секція черги клієнтів
        ListView<String> clientQueue = new ListView<>();
        clientQueue.getItems().addAll("Client 1: Order (Pizza Margherita)", "Client 2: Order (Pizza Pepperoni)");

        // Секція кухарів
        ListView<String> chefsStatus = new ListView<>();
        chefsStatus.getItems().addAll("Chef 1: Cooking Pizza Margherita", "Chef 2: Idle");

        mainPane.getChildren().addAll(clientQueue, chefsStatus);
        return mainPane;
    }
}
