package org.example.zepto;

import java.util.List;
import org.example.controller.OrderController;
import org.example.controller.UserController;
import org.example.controller.WarehouseController;
import org.example.models.cart.Cart;
import org.example.models.category.ProductCategory;
import org.example.models.inventory.Inventory;
import org.example.models.order.Order;
import org.example.models.user.User;
import org.example.models.warehouse.Warehouse;
import org.example.models.warehouse.WarehouseSelectionStrategy;

public class Zepto {

    private UserController userController;
    private WarehouseController warehouseController;
    private OrderController orderController;

    public Zepto(List<User> users, List<Warehouse> warehouses) {
        this.userController = new UserController(users);
        this.warehouseController = new WarehouseController(warehouses, null);
        this.orderController = new OrderController();
    }

    public User getUser(int userId) {
        return userController.getUser(userId);
    }

    public Warehouse getWarehouse(WarehouseSelectionStrategy warehouseSelectionStrategy) {
        return warehouseController.selectWarehouse(warehouseSelectionStrategy);
    }

    public Inventory getInventory(Warehouse warehouse) {
       return warehouse.getInventory();
    }

    public void addProductToCart(User user, ProductCategory productCategory, int count) {
        Cart cart = user.getCart();
        cart.addItemToCart(productCategory, count);
    }

    public Order placeOrder(User user, Warehouse warehouse) {
        return orderController.createOrder(user, warehouse);
    }

    public void checkout(Order order) {
        order.checkout();
    }
}
