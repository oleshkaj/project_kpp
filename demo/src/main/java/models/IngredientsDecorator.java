package models;

import java.util.List;

public class IngredientsDecorator implements IngredientsComponent {
    protected IngredientsComponent ingredient; // Компонент, який буде декоруватися

    // Конструктор
    public IngredientsDecorator(IngredientsComponent ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public DoughType getDough() {
        return ingredient.getDough();
    }

    @Override
    public SauceType getSauce() {
        return ingredient.getSauce();
    }

    @Override
    public List<Topping> getToppings() {
        return ingredient.getToppings();
    }

    @Override
    public PizzaSize getSize() {
        return ingredient.getSize();
    }
}
