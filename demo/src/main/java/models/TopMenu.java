package models;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class TopMenu {

    public static HBox createTopMenu() {
        HBox topMenu = new HBox(10);

        // Компоненти меню
        Label cashierLabel = new Label("Cashiers:");
        TextField cashierField = new TextField("2");

        Label chefLabel = new Label("Chefs:");
        TextField chefField = new TextField("3");

        Button startButton = new Button("Start Simulation");
        Button stopButton = new Button("Stop Simulation");

        // Логіка кнопок
        startButton.setOnAction(e -> {
            System.out.println("Simulation started with " +
                    cashierField.getText() + " cashiers and " +
                    chefField.getText() + " chefs.");
        });

        stopButton.setOnAction(e -> {
            System.out.println("Simulation stopped.");
        });

        topMenu.getChildren().addAll(cashierLabel, cashierField, chefLabel, chefField, startButton, stopButton);
        return topMenu;
    }
}
