package lt.mb.payment;

public class PaymentNotFoundException extends RuntimeException {
    public PaymentNotFoundException(Long id) {
        super ("Could not find payment for " + id);
    }
}
