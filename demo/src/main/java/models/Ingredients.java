package models;

import java.util.List;

public class Ingredients {
    private DoughType dough;
    private SauceType sauce;
    private List<Topping> toppings;
    private PizzaSize size;

    public Ingredients() {
        // Конструктор за замовчуванням
    }

    public DoughType getDough() {
        return dough;
    }

    public void setDough(DoughType dough) {
        this.dough = dough;
    }

    public SauceType getSauce() {
        return sauce;
    }

    public void setSauce(SauceType sauce) {
        this.sauce = sauce;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }
}
