package org.example.models.category;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import lombok.Data;
import org.example.models.product.Product;

@Data
public class ProductCategory {

    private int id;
    private String categoryName;
    private List<Product> products;
    private double price;

    public ProductCategory(int id, String categoryName, double price) {
        this.id = id;
        this.categoryName = categoryName;
        this.products = new ArrayList<>();
        this.price = price;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProducts(int count) {
        if (products.size() >= count) {
            products.subList(0, count).clear();
        }
    }

    public void addProducts(int count) {
        products.addAll(Stream.generate(this::generateRandomProduct).limit(count).toList());
    }

    public Product generateRandomProduct() {
        Random random = new Random();
        int id = random.nextInt(100) + 1;
        String name = "Product " + id;
        return new Product(id, name);
    }
}
