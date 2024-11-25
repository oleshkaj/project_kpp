package models;

import java.util.List;

public class PizzeriaView extends BaseComponent
{
    public PizzeriaView(IPizzeriaController pizzeriaController)
    {
        super(pizzeriaController);
    }

    public void showMenu(Menu menu)
    {
        // Реалізація
    }

    public void showOrderDetails(Order order)
    {
        // Реалізація
    }

    public void showChefStatus(Chef chef)
    {
        // Реалізація
    }

    public void showOrderQueue(List<Order> orderQueue)
    {
        // Реалізація
    }

    public void showTechnicalBreak(Chef chef, int duration)
    {
        // Реалізація
    }

    public void showOrderStatus(int orderId, Status status)
    {
        // Реалізація
    }

    public void showPizzaPrepared(Pizza pizza)
    {
        // Реалізація
    }
}