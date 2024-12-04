package org.example.models.invoice;

import lombok.Data;
import org.example.models.order.Order;

@Data
public class Invoice {

    private int itemPrice;
    private int tax;
    private int finalPrice;

    public void generateInvoice(Order order) {
        itemPrice = 10;
        tax = 2;
        finalPrice = itemPrice + tax;
    }
}
