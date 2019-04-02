package lt.mb.payment.contoller;

import lt.mb.common.Payment;
import lt.mb.common.Person;
import lt.mb.payment.PaymentNotFoundException;
import lt.mb.payment.db.PaymentRepository;
import lt.mb.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/payment")
public class PaymentController {

    public final PaymentService service;

    @Autowired
    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping("/get/payments")
    public List<Payment> getAllPayments() {
        return service.getAllPayments();
    }

    @GetMapping("/get/{id}")
    public Payment getPayment(@PathVariable Long id) {
        return service.getPaymentById(id);
    }

    @PostMapping
    public Payment addPayment(@RequestBody Payment newPayment) {
        return service.addPayment(newPayment);
    }

    @GetMapping("/getPayments")
    public List<Person> getPayments(){
        return service.getPersonByOfficialId();
    }


}
