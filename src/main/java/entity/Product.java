package entity;

public class Product {
    private String name;
    private double price;
    private int quantity;


    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product (){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addProduct(int productAdded) {
        quantity += productAdded;
        System.out.println("There are now " + quantity + " quantity left in the store");
    }

    public void buyProduct(Product products, int quantityToBuy) {
        if ((quantity - quantityToBuy) <= 0) {
            System.out.println("There are no enough quantity of this product in the store. We only have " + quantity +
                    " quantity left");
        } else {
            quantity -= products.quantity;
            System.out.println("Thank you for shopping with us. You have just bought " + " quantity" +
                    "of product.");

        }
    }
}
