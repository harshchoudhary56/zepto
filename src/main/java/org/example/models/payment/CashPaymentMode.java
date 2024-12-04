package org.example.models.payment;

public class CashPaymentMode implements PaymentMode {

    private static volatile PaymentMode paymentMode;

    private CashPaymentMode() {}

    public static PaymentMode getPaymentMode() {
        if (paymentMode == null) {
            synchronized (PaymentMode.class) {
                if (paymentMode == null) {
                    paymentMode = new CashPaymentMode();
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
