package org.example.models.payment;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Payment {

    private int id;
    private LocalDateTime paymentDate;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;

    public Payment(int id, PaymentMode paymentMode) {
        this.id = id;
        this.paymentDate = LocalDateTime.now();
        this.paymentMode = paymentMode;
        this.paymentStatus = PaymentStatus.FAILURE;
    }

    public boolean makePayment() {
         if (paymentMode.makePayment()) {
             paymentStatus = PaymentStatus.SUCCESS;
             return true;
         } else {
             return false;
         }
    }
}
