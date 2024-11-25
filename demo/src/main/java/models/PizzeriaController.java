package models;

public class PizzeriaController implements IPizzeriaController
{
    private Pizzeria pizzeria;
    private PizzeriaView view;

    public PizzeriaController(Pizzeria pizzeria, PizzeriaView view)
    {
        this.pizzeria = pizzeria;
        this.view = view;
    }

    @Override
    public void Notify(Object sender, String event)
    {
        // Реалізація
    }
}
