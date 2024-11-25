package models;
import java.util.*;

class CookingProcess implements IObserverManager {
    private String currentStep;
    private Order order;
    private List<IObserver> observers;

    public CookingProcess() {
        observers = new List<IObserver>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<IObserver> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(IObserver iObserver) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends IObserver> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends IObserver> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public IObserver get(int index) {
                return null;
            }

            @Override
            public IObserver set(int index, IObserver element) {
                return null;
            }

            @Override
            public void add(int index, IObserver element) {

            }

            @Override
            public IObserver remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<IObserver> listIterator() {
                return null;
            }

            @Override
            public ListIterator<IObserver> listIterator(int index) {
                return null;
            }

            @Override
            public List<IObserver> subList(int fromIndex, int toIndex) {
                return List.of();
            }
        };
        //TODO: дописати
    }

    public void startCooking(Order order) {
        this.order = order;
        currentStep = "Started";
        notifyObservers("Started cooking", "fmdkfmdk");

        //TODO: дописати
    }

    public void preparePizza(Pizza pizza) {
        currentStep = "Preparing pizza";
        notifyObservers(currentStep, "fmdfmkd");

        //TODO: дописати
    }

    public void completeCooking() {
        currentStep = "Completed";
        notifyObservers(currentStep, "fdkfkd");

        //TODO: дописати
    }

    public void attach(IObserver observer) {
        observers.add(observer);
    }

    public void detach(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void attach(Observer observer) {

    }

    @Override
    public void detach(Observer observer) {

    }

    public void notifyObservers(String step, String status) {
        for (IObserver observer : observers) {
            observer.update(step, "fndfnkdnf");

        }
    }
}
