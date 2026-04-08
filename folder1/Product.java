// File 4: Product.java - Used by Order, has dependency chain
package folder1;

import java.util.List;
import java.util.ArrayList;

public class Product extends BaseModel {
    private String name;
    private double price;
    private int stock;
    private List<String> categories;
    
    public Product(String id, String name, double price, int stock) {
        super(id);
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.categories = new ArrayList<>();
    }
    
    @Override
    public String getType() {
        return "PRODUCT";
    }
    
    @Override
    public boolean validate() {
        return id != null && !id.isEmpty() && 
               price >= 0 && stock >= 0 &&
               name != null && !name.isEmpty();
    }
    
    public void addCategory(String category) {
        if (category != null && !category.isEmpty()) {
            categories.add(category);
        }
    }
    
    public boolean isInStock(int quantity) {
        return stock >= quantity;
    }
    
    public void reduceStock(int quantity) {
        if (isInStock(quantity)) {
            stock -= quantity;
        }
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getStock() {
        return stock;
    }
    
    public List<String> getCategories() {
        return new ArrayList<>(categories);
    }
    
    // Static helper to filter products by category
    public static List<Product> filterByCategory(List<Product> products, String category) {
        List<Product> filtered = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategories().contains(category)) {
                filtered.add(product);
            }
        }
        return filtered;
    }
}
