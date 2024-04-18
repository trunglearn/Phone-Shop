package model;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> items;
    private long cartID;

    public Cart() {
        items = new ArrayList<>();
        cartID = System.currentTimeMillis();
    }

    public Cart(List<CartItem> items, long cartID) {
        this.items = items;
        this.cartID = cartID;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public long getCartID() {
        return cartID;
    }

    public void setCartID(long cartID) {
        this.cartID = cartID;
    }

    public void addToCart(Product sp, int numberOfProduct) {
        boolean exists = false;
        for (CartItem item : items) {
            if (item.getProduct().getID_Product() == sp.getID_Product()) {
                item.setQuantity(item.getQuantity() + numberOfProduct);
                exists = true;
                break;
            }
        }

        if (!exists) {
            items.add(new CartItem(sp, numberOfProduct));
        }
    }

    public void subToCart(Product sp, int numberOfProduct) {
        for (CartItem item : items) {
            if (item.getProduct().getID_Product() == sp.getID_Product()) {
                int newQuantity = item.getQuantity() - numberOfProduct;
                if (newQuantity <= 0) {
                    items.remove(item);
                } else {
                    item.setQuantity(newQuantity);
                }
                break;
            }
        }
    }

    public void removeToCart(Product sp) {
        items.removeIf(item -> item.getProduct().getID_Product() == sp.getID_Product());
    }

    public int count() {
        return items.size();
    }

    public float total() {
        float count = 0;
        for (CartItem item : items) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();
            count += (product.getUnit_price() * quantity - product.getUnit_price() * quantity * product.getDiscount() / 100);
        }
        return count;
    }
}
