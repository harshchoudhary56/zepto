package org.example.models.payment;

public class DebitCardPaymentMode implements PaymentMode {

    private static volatile PaymentMode paymentMode;

    private DebitCardPaymentMode() {}

    public static PaymentMode getPaymentMode() {
        if (paymentMode == null) {
            synchronized (PaymentMode.class) {
                if (paymentMode == null) {
                    paymentMode = new DebitCardPaymentMode();
                }
            }
        }
        return paymentMode;
    }

    @Override
    public boolean makePayment() {
        return true;
    }
}
