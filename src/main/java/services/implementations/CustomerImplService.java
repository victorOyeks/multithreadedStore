package services.implementations;

import entity.Customer;
import entity.Product;
import entity.Store;
import services.ICashierService;
import services.ICustomerService;
import services.IReStockerService;

public class CustomerImplService implements ICustomerService, Runnable {

    private Store store;
    private int quantity;
    IReStockerService irs = new ReStockerImplService();
    ICashierService cashierService = new CashierImplService();

    public String buyProduct (Product product, Customer customer) {
        if (customer.getWallet() - product.getPrice() < 0 ) {
            return "Sorry, you don't have enough cash in your wallet.";
        } else {
            return "Thank you for shopping with us. Do have a nice day.";
        }
    }
    public void purchaseProduct(Store store, int quantity){
        store.getInventoryLock().lock();
        try {
            while (store.getInventory() < quantity) {
//                Thread.sleep(500);
                System.out.println("Not enough product in inventory, waiting for restock...");
                irs.restockProduct(store, 100);
            }
            store.setInventory(store.getInventory() - quantity);
//            Thread.sleep(500);
            System.out.println(quantity + " products purchased. Remaining inventory: " + store.getInventory());
        } finally {
            store.getInventoryLock().unlock();
        }
    }

    @Override
    public void run() {
        try {
            purchaseProduct(store, quantity);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            System.err.println("Customer thread interrupted");
        }
    }
}
