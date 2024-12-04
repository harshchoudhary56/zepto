package org.example.models.warehouse;

import java.util.Map;
import lombok.Data;
import org.example.models.address.Address;
import org.example.models.category.ProductCategory;
import org.example.models.inventory.Inventory;

@Data
public class Warehouse {

    private int id;
    private Inventory inventory;
    private Address address;

    public void removeItemsFromInventory(Map<ProductCategory, Integer> categoryVsCount) {
        inventory.removeProducts(categoryVsCount);
    }

    public void addItemsToInventory(Map<ProductCategory, Integer> categoryVsCount) {
        inventory.addProducts(categoryVsCount);
    }
}
