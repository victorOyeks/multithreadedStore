package services;

import entity.Customer;
import entity.Product;

public interface ICashierService {
    void sellProduct (Customer customer, Product product);
    void dispenseReceipt(Customer customer);
}

