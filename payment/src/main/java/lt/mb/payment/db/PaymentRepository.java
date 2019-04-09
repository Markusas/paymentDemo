package lt.mb.payment.db;

import lt.mb.common.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByPersonId(Long personId);

}
