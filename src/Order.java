import java.util.ArrayList;

public class Order {
    private final ArrayList<Product> cart;
    public Order(){
        this.cart = new ArrayList<>();
    }
    public ArrayList<Product> getCart() {
        return cart;
    }
    public void add(Product product){
        cart.add(product);
    }
    public void clear(){
        cart.clear();
    }
}
