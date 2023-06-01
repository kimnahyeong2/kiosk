public class Product extends Menu {

    private final double price;

    public Product(String name, double price, String explain) {
        super(name, explain);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
