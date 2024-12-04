package org.example.models.order;

import java.util.Map;
import lombok.Data;
import org.example.models.address.Address;
import org.example.models.category.ProductCategory;
import org.example.models.invoice.Invoice;
import org.example.models.payment.Payment;
import org.example.models.payment.PaymentMode;
import org.example.models.payment.PaymentType;
import org.example.models.payment.factory.PaymentModeFactory;
import org.example.models.user.User;
import org.example.models.warehouse.Warehouse;

@Data
public class Order {

    private int id;
    private User user;
    private Address deliveryAddress;
    private Map<ProductCategory, Integer> categoryVsCount;
    private Warehouse warehouse;
    private OrderStatus orderStatus;
    private Invoice invoice;
    private Payment payment;
    
    public Order(int id, User user, Warehouse warehouse) {
        this.id = id;
        this.user = user;
        this.deliveryAddress = user.getAddress();
        this.categoryVsCount = user.getCart().getCategoryVsCount();
        this.warehouse = warehouse;
        this.orderStatus = OrderStatus.PENDING;
    }

    public void checkout() {
        warehouse.removeItemsFromInventory(categoryVsCount);
        boolean status = makePayment(PaymentModeFactory.getPaymentMode(PaymentType.AMAZON_PAY));
        if (status) {
            user.getCart().emptyCart();
        } else {
            warehouse.addItemsToInventory(categoryVsCount);
        }
    }

    public boolean makePayment(PaymentMode paymentMode) {
        return paymentMode.makePayment();
    }

    public void generateOrderInvoice() {
        invoice.generateInvoice(this);
    }
}
