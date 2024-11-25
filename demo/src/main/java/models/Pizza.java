package models;

import java.util.List;

public class Pizza {
    private String pizzaName;
    private Ingredients ingredients;
    private int cookingTime;
    private double price;

    public Pizza(String pizzaName, Ingredients ingredients, int cookingTime, double price) {
        this.pizzaName = pizzaName;
        this.ingredients = ingredients;
        this.cookingTime = cookingTime;
        this.price = price;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public double getPrice() {
        return price;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }
}
