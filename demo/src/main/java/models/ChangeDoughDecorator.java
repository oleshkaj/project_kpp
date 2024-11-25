package models;

public class ChangeDoughDecorator extends IngredientsDecorator {
    private DoughType newDough;

    public ChangeDoughDecorator(IngredientsComponent ingredient, DoughType newDough) {
        super(ingredient);
        this.newDough = newDough;
    }

    @Override
    public DoughType getDough() {
        return newDough;
    }
}
