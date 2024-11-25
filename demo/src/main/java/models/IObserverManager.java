package models;

import java.util.Observer;

public interface IObserverManager {
    public void attach(Observer observer);
    public void detach(Observer observer);
    public void notifyObservers(String step, String status);
}
