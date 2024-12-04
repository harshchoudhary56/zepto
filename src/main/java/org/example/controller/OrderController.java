package org.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.Data;
import org.example.models.order.Order;
import org.example.models.user.User;
import org.example.models.warehouse.Warehouse;

@Data
public class OrderController {

    private List<Order> orders;
    private Map<User, List<Order>> userIdVsOrder;

    public OrderController() {
        orders = new ArrayList<>();
        userIdVsOrder = new HashMap<>();
    }

    public Order createOrder(User user, Warehouse warehouse) {
        int orderId = (int)(Math.random() * 100) + 1;
        Order order = new Order(orderId, user, warehouse);
        orders.add(order);
        List<Order> userOrders = userIdVsOrder.getOrDefault(user, new ArrayList<>());
        userOrders.add(order);
        userIdVsOrder.put(user, userOrders);
        return order;
    }

    public void removeOrder(int orderId) {
        orders.removeIf(order -> order.getId() == orderId);

        for (Map.Entry<User, List<Order>> entry: userIdVsOrder.entrySet()) {
            entry.getValue().removeIf(order -> order.getId() == orderId);
        }
    }

    public List<Order> getOrdersByUser(User user) {
        return userIdVsOrder.get(user);
    }

    public Order getOrderByOrderId(int orderId) {
        Optional<Order> optionalOrder = orders.stream().filter(order -> order.getId() == orderId).findFirst();
        return optionalOrder.orElse(null);
    }
}
