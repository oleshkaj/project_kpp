package models;

import java.io.Serializable;

class Chef extends Person implements IObserver {
    private int chefId;
    private String specialization;
    private boolean isAvailable;
    private CookingProcess cookingProcess;

    public Chef(String name, String surname, String phoneNumber, String birthday, int chefId, String specialization) {
        super(name, surname, phoneNumber, birthday);
        this.chefId = chefId;
        this.specialization = specialization;
        this.isAvailable = true;
    }

    public void preparePizza(Order order) {
        //TODO: дописати
    }

    public void takeBreak() {
        //TODO: дописати
    }

    public void resumeWork() {
        //TODO: дописати
    }

    public void update(String step, String status) {
        //TODO: дописати
    }

    public boolean handleOrder(Order order) {
        //TODO: дописати
    }

    public boolean Return(Order order) {
        //TODO: дописати
    }

}