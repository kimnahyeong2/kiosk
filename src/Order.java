import java.util.*;

public class Order {
    private final HashMap<Product, Integer> cartList;
    private HashMap<Product, Integer> orderList;
    public Order(){
        this.cartList  = new HashMap<Product, Integer>();
    }
    public HashMap<Product, Integer> getCartList(){
        return cartList;
    }
    public HashMap<Product, Integer> getOrderList(){
        return orderList;
    }
    public void add(Product product, int cnt){
        cartList.put(product, cnt);
    }
    public void remove(Product product){
        cartList.remove(product);
    }
    public void clear(){
        cartList.clear();
    }
}
