package org.example.models.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.Data;
import org.example.models.category.ProductCategory;
import org.example.models.product.Product;

@Data
public class Inventory {

    private List<ProductCategory> productCategoryList;

    public Inventory() {
        this.productCategoryList = new ArrayList<>();
    }

    public void addProductCategory(int id, String categoryName, double price) {
        if (productCategoryList.stream().noneMatch(p -> p.getId() == id)) {
            productCategoryList.add(new ProductCategory(id, categoryName, price));
        }
    }

    public void removeProductCategory(int productCategoryId) {
        productCategoryList.removeIf(p -> p.getId() == productCategoryId);
    }

    public void addProduct(int productCategoryId, Product product) {
        Optional<ProductCategory> optionalProductCategory = productCategoryList.stream().filter(productCategory -> productCategory.getId() == productCategoryId).findFirst();
        optionalProductCategory.ifPresent(productCategory -> productCategory.addProduct(product));
    }

    public void removeProducts(Map<ProductCategory, Integer> categoryVsCount) {
        for (Map.Entry<ProductCategory, Integer> entry: categoryVsCount.entrySet()) {
            Optional<ProductCategory> optionalProductCategory = productCategoryList.stream().filter(p -> p == entry.getKey()).findFirst();
            optionalProductCategory.ifPresent(productCategory -> productCategory.removeProducts(entry.getValue()));
        }
    }

    public void addProducts(Map<ProductCategory, Integer> categoryVSCount) {
        for (Map.Entry<ProductCategory, Integer> entry: categoryVSCount.entrySet()) {
            Optional<ProductCategory> optionalProductCategory = productCategoryList.stream().filter(p -> p == entry.getKey()).findFirst();
            optionalProductCategory.ifPresent(productCategory -> productCategory.addProducts(entry.getValue()));
        }
    }

    public ProductCategory getProductCategoryFromId(int productCategoryId) {
        Optional<ProductCategory> optionalProductCategory = productCategoryList.stream().filter(productCategory -> productCategory.getId() == productCategoryId).findAny();
        return optionalProductCategory.orElse(null);
    }
}
