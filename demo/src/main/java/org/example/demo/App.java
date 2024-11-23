package org.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Завантажуємо FXML-файл
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Lab_pr.fxml"));

        // Створюємо кореневий елемент з FXML
        Parent root = fxmlLoader.load();

        // Створюємо сцену з кореневим елементом та задаємо розміри
        Scene scene = new Scene(root, 800, 600); // Встановіть розмір вікна на 800x600 пікселів або змініть на потрібний
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/Styles.css")).toExternalForm());


        // Додаємо сцену до вікна (Stage)
        stage.setTitle("Піцерія Симулятор"); // Назва вікна
        stage.setScene(scene);
        stage.show(); // Показуємо вікно
    }

    public static void main(String[] args) {
        launch(); // Запускає JavaFX додаток
    }
}
