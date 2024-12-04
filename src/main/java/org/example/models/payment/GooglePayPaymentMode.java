package org.example.models.payment;

public class GooglePayPaymentMode implements PaymentMode {

    private static volatile PaymentMode paymentMode;

    private GooglePayPaymentMode() {}

    public static PaymentMode getPaymentMode() {
        if (paymentMode == null) {
            synchronized (PaymentMode.class) {
                if (paymentMode == null) {
                    paymentMode = new GooglePayPaymentMode();
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
