package services;

import entity.Customer;
import entity.Product;
import entity.Store;

public interface ICustomerService {
    String buyProduct (Product product, Customer customer);
    void purchaseProduct(Store store, int quantity) throws InterruptedException;
}
