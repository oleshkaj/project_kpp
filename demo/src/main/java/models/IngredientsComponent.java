package models;

import java.util.List;

public interface IngredientsComponent {
    DoughType getDough();
    SauceType getSauce();
    List<Topping> getToppings();
    PizzaSize getSize();
}
