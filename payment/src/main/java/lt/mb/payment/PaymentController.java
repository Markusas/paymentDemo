package lt.mb.payment;

import lt.mb.common.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api")
public class PaymentController {

    private PaymentRepository repository;

    @GetMapping("/payment")
    public List<Payment> getAll(){
        return repository.findAll();
    }


}
