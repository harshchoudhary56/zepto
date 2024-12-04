package org.example.models.payment.factory;

import org.example.models.payment.AmazonPaymentMode;
import org.example.models.payment.CashPaymentMode;
import org.example.models.payment.CreditCardPaymentMode;
import org.example.models.payment.DebitCardPaymentMode;
import org.example.models.payment.GooglePayPaymentMode;
import org.example.models.payment.PaymentMode;
import org.example.models.payment.PaymentType;
import org.example.models.payment.PaytmPaymentMode;
import org.example.models.payment.PhonePayPaymentMode;
import org.example.models.payment.WhatsappPaymentMode;

public class PaymentModeFactory {

    public static PaymentMode getPaymentMode(PaymentType type) {
        PaymentMode paymentMode;

        switch (type) {
            case CASH -> paymentMode = CashPaymentMode.getPaymentMode();
            case DEBIT_CARD -> paymentMode = DebitCardPaymentMode.getPaymentMode();
            case CREDIT_CARD -> paymentMode = CreditCardPaymentMode.getPaymentMode();
            case PAYTM -> paymentMode = PaytmPaymentMode.getPaymentMode();
            case PHONE_PE -> paymentMode = PhonePayPaymentMode.getPaymentMode();
            case GOOGLE_PAY -> paymentMode = GooglePayPaymentMode.getPaymentMode();
            case AMAZON_PAY -> paymentMode = AmazonPaymentMode.getPaymentMode();
            case WHATSAPP_PAY -> paymentMode = WhatsappPaymentMode.getPaymentMode();
            default -> paymentMode = null;
        }
        return paymentMode;
    }
}
