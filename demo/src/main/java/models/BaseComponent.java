package models;

public abstract class BaseComponent
{
    protected IPizzeriaController pizzeriaController;
    public BaseComponent(IPizzeriaController pizzeriaController)
    {
        this.pizzeriaController = pizzeriaController;
    }
    public void setMediator(IPizzeriaController pizzeriaController)
    {
        this.pizzeriaController = pizzeriaController;
    }
}