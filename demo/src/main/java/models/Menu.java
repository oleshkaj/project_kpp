package models;

import java.util.ArrayList;
import java.util.List;

public class Menu
{
    private List<Pizza> menuItems = new ArrayList<>();

    public void addPizza(Pizza pizza)
    {
        menuItems.add(pizza);
    }

    public void removePizza(Pizza pizza)
    {
        menuItems.remove(pizza);
    }

    public List<Pizza> getPizzaList()
    {
        return menuItems;
    }
}