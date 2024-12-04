package org.example.models.user;

import java.util.ArrayList;
import lombok.Data;
import org.example.models.address.Address;
import org.example.models.cart.Cart;

import java.util.List;

@Data
public class User {

    private int id;
    private String name;
    private Address address;
    private Cart cart;
    private List<Integer> orderIds;

    public User(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cart = new Cart();
        this.orderIds = new ArrayList<>();

    }
}
