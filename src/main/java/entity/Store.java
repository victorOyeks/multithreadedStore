package entity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Store {
    private int inventory = 0;
    private final Lock inventoryLock = new ReentrantLock();

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public Lock getInventoryLock() {
        return inventoryLock;
    }
}