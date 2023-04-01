package entity;

import services.ICashierService;
import services.ICustomerService;

public class Customer {
    private String name;
    private int wallet;
    private int quantity;
    private ReStocker reStocker;
    private Store store;

    public Customer(String name, int wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public Customer(Store store, int quantity) {
        this.store = store;
        this.quantity = quantity;
    }

    public Customer() {

    }


    public void addMoney (int amount) {
        wallet += amount;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWallet() {
        return wallet;
    }
    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", wallet=" + wallet +
                '}';
    }
}