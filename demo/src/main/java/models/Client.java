package models;

class Client extends Person {
    private int clientId;
    private Order order;

    public Client(String name, String surname, String phoneNumber, String birthday, int clientId) {
        super(name, surname, phoneNumber, birthday);
        this.clientId = clientId;
    }

    public void generateOrder(Menu menu) {
        //TODO: дописати
    }

    public Order getOrder() {
        //TODO: дописати
        return order;
    }
}