package org.example.models.payment;

public class PaytmPaymentMode implements PaymentMode {

    private static volatile PaymentMode paymentMode;

    private PaytmPaymentMode() {}

    public static PaymentMode getPaymentMode() {
        if (paymentMode == null) {
            synchronized (PaymentMode.class) {
                if (paymentMode == null) {
                    paymentMode = new PaytmPaymentMode();
                }
            }
        }
        return paymentMode;
    }

    @Override
    public boolean makePayment() {
        return false;
    }
}
