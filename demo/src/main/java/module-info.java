module org.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls; // Додаємо ControlsFX
    requires javafx.graphics;
    requires javafx.media; // Якщо використовується media
    requires javafx.web; // Якщо використовується web
    //requires org.kordamp.ikonli.javafx; // Якщо використовується Ikonli

    opens org.example.demo to javafx.fxml;
    exports org.example.demo;
}
