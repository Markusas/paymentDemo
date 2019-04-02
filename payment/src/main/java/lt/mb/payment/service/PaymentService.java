package lt.mb.payment.service;

import lt.mb.common.Payment;
import lt.mb.payment.PaymentNotFoundException;
import lt.mb.payment.db.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    public final PaymentRepository repository;

    @Autowired
    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    public Payment getPaymentById(Long id) {
        return repository.findById(id).orElseThrow(() -> new PaymentNotFoundException(id));
    }

    public List<Payment> getAllPayments() {
        return repository.findAll();
    }

    public Payment addPayment(Payment newPayment) {
        return repository.save(newPayment);
    }

    public Payment getPaymentByOfficialId(String officialId){
        return null;
    }
}
