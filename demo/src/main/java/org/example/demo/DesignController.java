package org.example.demo;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.util.Objects;

public class DesignController {

    @FXML
    private TextField cashierCountField;

    @FXML
    private ComboBox<String> comboBox; // Замість speedField використовуємо comboBox

    @FXML
    private TextField chefCountField;

    @FXML
    private Button startButton;

    @FXML
    private Canvas canvas;

    private Image pizzaImage;
    private Image cashierIcon;
    private Image chefIcon;

    // Замість простих змінних використовуємо DoubleProperty для анімації
    private final DoubleProperty currentPizzaX = new SimpleDoubleProperty(50); // Початкова координата X піци
    private final DoubleProperty currentPizzaY = new SimpleDoubleProperty(100); // Початкова координата Y піци

    @FXML
    public void initialize() {
        // Завантаження зображення піци та іконок
        pizzaImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pizza.png")));
        cashierIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/cashier.png")));
        chefIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/chef.png")));

        // Малюємо початкове розташування елементів
        drawSimulation();

        // Додаємо початкове малювання піци з ID
        drawPizza(currentPizzaX.get(), currentPizzaY.get(), "1"); // Приклад з ID "1"
    }

    @FXML
    private void startSimulation() {
        // Виклик функції для малювання, яка використовує введені значення
        drawSimulation();
    }

    private void drawSimulation() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Очищення Canvas перед новим малюванням
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        try {
            int cashierCount = Integer.parseInt(cashierCountField.getText());
            int chefCount = Integer.parseInt(chefCountField.getText());
            String speed = comboBox.getValue(); // Отримуємо значення швидкості з ComboBox

            // Малюємо каси з ID
            drawCashiers(gc, cashierCount);

            // Малюємо кухарів з ID
            drawChefs(gc, chefCount);

            // Малюємо зону видачі
            drawDeliveryZone(gc);

        } catch (NumberFormatException e) {
            System.out.println("Будь ласка, введіть коректні числові значення.");
        }
    }

    private void drawCashiers(GraphicsContext gc, int cashierCount) {
        int x = 50;       // Позиція x для початку малювання касирів
        int y = 50;       // Початкова позиція у для касирів
        int spacing = 70; // Відстань між касирами
        int iconSize = 30; // Розмір іконки касира

        for (int i = 0; i < cashierCount; i++) {
            // Малюємо іконку касира
            gc.drawImage(cashierIcon, x, y + i * spacing, iconSize, iconSize);

            // Малюємо ID під касиром
            gc.fillText("ID: " + (i + 1), x + 15, y + i * spacing + iconSize + 15);
        }
    }

    private void drawChefs(GraphicsContext gc, int chefCount) {
        int y = 200;      // Позиція у для малювання кухарів (рівень останнього касира)
        int x = 250;      // Початкова позиція x для кухарів
        int spacing = 70; // Відстань між кухарями
        int iconSize = 30; // Розмір іконки кухаря

        for (int i = 0; i < chefCount; i++) {
            // Малюємо іконку кухаря
            gc.drawImage(chefIcon, x + i * spacing, y, iconSize, iconSize);

            // Малюємо ID під кухарем
            gc.fillText("ID: " + (i + 1), x + i * spacing + 15, y + iconSize + 15);
        }
    }

    private void drawDeliveryZone(GraphicsContext gc) {
        int x = 50;         // Початкова позиція x для зони видачі
        int y = 10;         // Розташування зони видачі зверху над касирами
        int width = 200;    // Ширина зони видачі
        int height = 30;    // Висота зони видачі

        gc.setFill(javafx.scene.paint.Color.LIGHTGRAY);
        gc.fillRect(x, y, width, height);
        gc.setStroke(javafx.scene.paint.Color.BLACK);
        gc.strokeRect(x, y, width, height);

        gc.setFill(javafx.scene.paint.Color.BLACK);
        gc.fillText("Зона видачі", x + 20, y + 20);
    }

    private void drawPizza(double x, double y, String id) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(pizzaImage, x, y, 30, 30); // Малюємо піцу як іконку розміром 30x30

        // Малюємо ID під піцою
        gc.fillText("OrderID: " + id, x + 5, y + 45); // Позиція тексту трохи нижче іконки піци
    }

    private void animatePizza(double targetX, double targetY, String id) {

        currentPizzaX.removeListener((obs, oldVal, newVal) -> updateCanvas(id));
        currentPizzaY.removeListener((obs, oldVal, newVal) -> updateCanvas(id));

        Timeline timeline = new Timeline();

        // Використовуємо DoubleProperty для анімації
        KeyValue kvX = new KeyValue(currentPizzaX, targetX);
        KeyValue kvY = new KeyValue(currentPizzaY, targetY);

        // Створюємо KeyFrame з тривалістю 2 секунди
        KeyFrame kf = new KeyFrame(Duration.seconds(2), kvX, kvY);
        timeline.getKeyFrames().add(kf);

        currentPizzaX.addListener((obs, oldVal, newVal) -> updateCanvas(id));
        currentPizzaY.addListener((obs, oldVal, newVal) -> updateCanvas(id));

        // Запускаємо анімацію
        timeline.play();
    }

    private void updateCanvas(String id) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Перемальовуємо основні зони та елементи
        drawSimulation();

        // Малюємо піцу на новій позиції з ID
        drawPizza(currentPizzaX.get(), currentPizzaY.get(), id);
    }
}
