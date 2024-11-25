package models;

import java.util.List;

public class Order {
    private int orderId;
    private Client client;
    private List<Pizza> pizzas;
    private double totalPrice;
    private Status orderStatus;

    // Конструктор
    public Order(int orderId, Client client, List<Pizza> pizzas) {
        this.orderId = orderId;
        this.client = client;
        this.pizzas = pizzas;
        this.totalPrice = calculateTotalPrice();
        this.orderStatus = Status.NEW;
    }

    // Методи для додавання/видалення піци
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
        totalPrice = calculateTotalPrice();
    }

    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
        totalPrice = calculateTotalPrice();
    }

    // Отримання загальної ціни
    public double getTotalPrice() {
        return totalPrice;
    }

    // Отримання списку піц
    public List<Pizza> getPizzas() {
        return pizzas;
    }

    // Оновлення статусу
    public void updateStatus(Status status) {
        this.orderStatus = status;
    }

    // Отримання клієнта
    public Client getClient() {
        return client;
    }

    // Отримання статусу замовлення
    public Status getOrderStatus() {
        return orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    // Розрахунок загальної ціни замовлення
    private double calculateTotalPrice() {
        double price = 0;
        for (Pizza pizza : pizzas) {
            price += pizza.getPrice();
        }
        return price;
    }
}
