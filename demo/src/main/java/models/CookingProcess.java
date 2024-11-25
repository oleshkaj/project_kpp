package models;
import java.util.ArrayList;

class CookingProcess implements IObserverManager {
    private String currentStep;
    private Order order;
    private List<Observer> observers;

    public CookingProcess() {
        observers = new List<Observer>();
        //TODO: дописати
    }

    public void startCooking(Order order) {
        this.order = order;
        currentStep = "Started";
        notifyObservers("Started cooking");

        //TODO: дописати
    }

    public void preparePizza(Pizza pizza) {
        currentStep = "Preparing pizza";
        notifyObservers(currentStep);

        //TODO: дописати
    }

    public void completeCooking() {
        currentStep = "Completed";
        notifyObservers(currentStep);

        //TODO: дописати
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String step, String status) {
        for (Observer observer : observers) {
            observer.update(step);
        }
    }
}
