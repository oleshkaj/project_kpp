package models;

import java.util.List;

public class DoubleToppingDecorator extends IngredientsDecorator {
    private Topping toppingToDouble;

    public DoubleToppingDecorator(IngredientsComponent ingredient, Topping toppingToDouble) {
        super(ingredient);
        this.toppingToDouble = toppingToDouble;
    }

    @Override
    public List<Topping> getToppings() {
        List<Topping> toppings = super.getToppings();
        toppings.add(toppingToDouble); // Подвоюємо топінг
        return toppings;
    }
}
