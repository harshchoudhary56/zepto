package org.example.models.payment;

public class PhonePayPaymentMode implements PaymentMode {

    private static volatile PaymentMode paymentMode;

    private PhonePayPaymentMode() {}

    public static PaymentMode getPaymentMode() {
        if (paymentMode == null) {
            synchronized (PaymentMode.class) {
                if (paymentMode == null) {
                    paymentMode = new PhonePayPaymentMode();
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
