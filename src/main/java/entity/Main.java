package entity;

import services.ICashierService;
import services.ICustomerService;
import services.IManagerService;
import services.IReStockerService;
import services.implementations.CashierImplService;
import services.implementations.CustomerImplService;
import services.implementations.ManagerImpl;
import services.implementations.ReStockerImplService;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        ICashierService ics = new CashierImplService();
        ICustomerService iCustomer = new CustomerImplService();
        IManagerService iManagerService = new ManagerImpl();

        Cashier cashier1 = new Cashier("Mr John", "Cashier-1", 2);
        Cashier cashier2 = new Cashier("Mrs Jones", "Cashier-2", 0);
        Cashier cashier3 = new Cashier("Mr James", "Cashier-3", 0);

        Product product1 = new Product("Ice-cream", 999, 20);
        Product product2 = new Product("Soft drink", 200, 39);
        Product product3 = new Product("Toiletries", 799, 0);

        Customer customer1 = new Customer("Mr. Mike", 10);
        Customer customer2 = new Customer("Miss Mary", 9536);
        Customer customer3 = new Customer("Miss Jane", 49);

        Thread restockerThread = new Thread(new ReStockerImplService(store, 110));
        restockerThread.start();

        Thread[] customerThreads = new Thread[10];
        for (int i = 1; i < customerThreads.length; i++) {
            int finalI = i;
            customerThreads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        iCustomer.purchaseProduct(store, finalI * 10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            customerThreads[i].start();
        }
    }
}