package models;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private List<String> logEntries;

    // Конструктор
    public Logger() {
        this.logEntries = new ArrayList<>();
    }

    // Логування початку замовлення
    public void logStart(Order order) {
        logEntries.add("Order " + order.getOrderId() + " started.");
    }

    // Логування завершення замовлення
    public void logEnd(Order order) {
        logEntries.add("Order " + order.getOrderId() + " completed.");
    }

    // Отримання списку логів
    public List<String> getLog() {
        return logEntries;
    }
}
