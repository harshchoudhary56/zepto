package org.example.models.cart;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;
import org.example.models.category.ProductCategory;

@Data
public class Cart {

    private Map<ProductCategory, Integer> categoryVsCount;

    public Cart() {
        categoryVsCount = new HashMap<>();
    }

    public void addItemToCart(ProductCategory productCategory, int count) {
        categoryVsCount.put(productCategory, categoryVsCount.getOrDefault(productCategory, 0) + count);
    }

    public void removeItemFromCart(ProductCategory productCategory, int count) {
        if (categoryVsCount.containsKey(productCategory) && categoryVsCount.get(productCategory) >= count) {
            categoryVsCount.put(productCategory, categoryVsCount.get(productCategory) - count);
        }
    }

    public void emptyCart() {
        categoryVsCount = new HashMap<>();
    }

    public Map<ProductCategory, Integer> getCartItems() {
        return categoryVsCount;
    }
}
