package org.example.models.payment;

public class AmazonPaymentMode implements PaymentMode {

    private static volatile PaymentMode paymentMode;

    private AmazonPaymentMode() {}

    public static PaymentMode getPaymentMode() {
        if (paymentMode == null) {
            synchronized (PaymentMode.class) {
                if (paymentMode == null) {
                    paymentMode = new AmazonPaymentMode();
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
