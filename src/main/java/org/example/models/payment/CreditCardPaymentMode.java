package org.example.models.payment;

public class CreditCardPaymentMode implements PaymentMode {

    private static volatile PaymentMode paymentMode;

    private CreditCardPaymentMode() {}

    public static PaymentMode getPaymentMode() {
        if (paymentMode == null) {
            synchronized (PaymentMode.class) {
                if (paymentMode == null) {
                    paymentMode = new CreditCardPaymentMode();
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
