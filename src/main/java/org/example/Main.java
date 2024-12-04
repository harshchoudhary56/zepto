package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.example.models.address.Address;
import org.example.models.category.ProductCategory;
import org.example.models.inventory.Inventory;
import org.example.models.order.Order;
import org.example.models.product.Product;
import org.example.models.user.User;
import org.example.models.warehouse.NearestWarehouseSelectionStrategy;
import org.example.models.warehouse.Warehouse;
import org.example.zepto.Zepto;

public class Main {

    public static void main(String[] args) {
        List<Warehouse> warehouseList = new ArrayList<>();
        warehouseList.add(addWarehouseAndItsInventory());

        List<User> userList = new ArrayList<>();
        userList.add(createUser());

        Zepto zepto = new Zepto(userList, warehouseList);

        runDeliveryFlow(zepto, userList.getFirst().getId());


    }

    private static void runDeliveryFlow(Zepto zepto, int userId) {
        User user = zepto.getUser(userId);
        Warehouse warehouse = zepto.getWarehouse(new NearestWarehouseSelectionStrategy());
        Inventory inventory = zepto.getInventory(warehouse);

        Optional<ProductCategory> optionalProductCategory = inventory.getProductCategoryList().stream().filter(productCategory -> productCategory.getCategoryName().equals("Pepsi Large Cold Drink")).findFirst();
        optionalProductCategory.ifPresent(productCategory -> zepto.addProductToCart(user, productCategory, 2));

        Order order = zepto.placeOrder(user, warehouse);

        zepto.checkout(order);
    }

    private static User createUser(){
        return new User(1, "SJ", new Address("Bhojpur", "Ghaziabad", "Uttar Pradesh", "India", "245304"));
    }

    private static Warehouse addWarehouseAndItsInventory(){

        Warehouse warehouse = new Warehouse();

        Inventory inventory = new Inventory();

        inventory.addProductCategory(1, "Pepsi Large Cold Drink" , 100);
        inventory.addProductCategory(2, "Dove small Soap" , 50);

        //CREATE 3 Products

        Product product1 = new Product(1, "Pepsi");
        Product product2 = new Product(2, "Pepsi");
        Product product3 = new Product(3, "Dove");

        inventory.addProduct(1, product1);
        inventory.addProduct(1, product2);
        inventory.addProduct(2, product3);

        warehouse.setInventory(inventory);
        return warehouse;
    }

}