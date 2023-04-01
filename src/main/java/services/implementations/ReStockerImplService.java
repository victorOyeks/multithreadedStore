package services.implementations;

import entity.Store;
import services.IReStockerService;

public class ReStockerImplService implements IReStockerService, Runnable {

    private Store store;
    private int quantity;

    public ReStockerImplService(Store store, int quantity) {
        this.store = store;
        this.quantity = quantity;
    }

    public ReStockerImplService() {

    }

    public void restockProduct(Store store, int quantity) {
        store.getInventoryLock().lock();
        try {
            store.setInventory(store.getInventory() + quantity); ;
//            Thread.sleep(500);
            System.out.println(quantity + " products restocked. Remaining inventory: " + store.getInventory());
//            store.getInventoryLock().newCondition().signalAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            store.getInventoryLock().unlock();
        }
    }

    @Override
    public void run() {
        restockProduct(store, quantity);
    }
}
