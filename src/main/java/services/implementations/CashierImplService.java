package services.implementations;

import entity.Cashier;
import entity.Customer;
import entity.Product;
import services.ICashierService;

public class CashierImplService implements ICashierService {

    public void sellProduct(Customer customer, Product product) {
        if (product.getQuantity() <= 0) {
            System.out.println("There are not enough " + product.getName() + " in the store.");
        } else {
            System.out.println(product.getName() + " sold to " + customer.getName());
        }
    }
    public void dispenseReceipt(Customer customer) {
        System.out.println("Receipt dispensed receipt to " + customer.getName());
    }
}
