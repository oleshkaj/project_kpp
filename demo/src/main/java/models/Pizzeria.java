package models;

import java.util.List;

public class Pizzeria
{
    private static Pizzeria instance;
    private List<Cashier> cashiers;
    private List<Chef> chefs;
    private Menu menu;
    private OrdersQueue ordersQueue;
    private Logger logger;

    private Pizzeria(List<Cashier> cashiers, List<Chef> chefs, Menu menu, OrdersQueue ordersQueue, Logger logger)
    {
        this.cashiers = cashiers;
        this.chefs = chefs;
        this.menu = menu;
        this.ordersQueue = ordersQueue;
        this.logger = logger;
    }

    public static Pizzeria getInstance(List<Cashier> cashiers, List<Chef> chefs, Menu menu, OrdersQueue ordersQueue, Logger logger)
    {
        if (instance == null)
        {
            instance = new Pizzeria(cashiers, chefs, menu, ordersQueue, logger);
        }
        return instance;
    }

    public void placeOrder(Client client, Order order)
    {
        // Реалізація
    }

    public void assignOrderToChef(Order order)
    {
        // Реалізація
    }

    public void processOrders()
    {
        // Реалізація
    }
}