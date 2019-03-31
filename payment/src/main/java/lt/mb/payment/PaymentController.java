package lt.mb.payment;

import lt.mb.common.Payment;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentRepository repository;

    public PaymentController(PaymentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/get/payments")
    public List<Payment> getAllPayments() {
        return repository.findAll();
    }

    @GetMapping("/get/{id}")
    public Payment getPayment(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new PaymentNotFoundException(id));
    }

    @PostMapping
    public Payment addPayment(@RequestBody Payment newPayment){
        return repository.save(newPayment);
    }

}
