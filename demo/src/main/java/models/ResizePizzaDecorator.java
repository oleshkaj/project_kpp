package models;

public class ResizePizzaDecorator extends IngredientsDecorator {
    private PizzaSize newSize;

    public ResizePizzaDecorator(IngredientsComponent ingredient, PizzaSize newSize) {
        super(ingredient);
        this.newSize = newSize;
    }

    @Override
    public PizzaSize getSize() {
        return newSize;
    }
}
