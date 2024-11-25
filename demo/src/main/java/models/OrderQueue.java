package models;

import java.util.List;
import java.util.LinkedList;

public class OrderQueue {
    private List<Order> ordersList;

    // Конструктор
    public OrderQueue() {
        this.ordersList = new LinkedList<>();
    }

    // Додавання нового замовлення
    public void addOrder(Order order) {
        ordersList.add(order);
    }

    // Видалення замовлення
    public void removeOrder(Order order) {
        ordersList.remove(order);
    }

    // Отримання наступного замовлення
    public Order getNextOrder() {
        if (!ordersList.isEmpty()) {
            return ordersList.get(0); // Повертає перше замовлення
        }
        return null;
    }

    // Оновлення статусу замовлення
    public void update(String status, Order order) {
        switch (status.toUpperCase()) {
            case "READY":
                order.updateStatus(Status.READY);
                break;
            case "IN_PROGRESS":
                order.updateStatus(Status.IN_PROGRESS);
                break;
            case "CANCELED":
                order.updateStatus(Status.CANCELED);
                break;
            case "COMPLETED":
                order.updateStatus(Status.COMPLETED);
                break;
            default:
                System.out.println("Unknown status");
        }
    }
}
