package org.example.models.payment;

public class WhatsappPaymentMode implements PaymentMode {

    private static volatile PaymentMode paymentMode;

    private WhatsappPaymentMode() {}

    public static PaymentMode getPaymentMode() {
        if (paymentMode == null) {
            synchronized (PaymentMode.class) {
                if (paymentMode == null) {
                    paymentMode = new WhatsappPaymentMode();
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
