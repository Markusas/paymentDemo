package lt.mb.payment.contoller;

import lt.mb.common.Payment;
import lt.mb.common.Person;
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

    @GetMapping("/getAllPersons")
    public List<Person> getAllPersons(){
        return service.getAllPersons();
    }

    @GetMapping("/{personOfficialId}")
    public List<Payment> getPaymentsByOfficialId(@PathVariable String personOfficialId){
        return service.getPaymentsByOfficialId(personOfficialId);
    }

    @PostMapping("/{personOfficialId}")
    public Payment addPaymentForPerson(@RequestBody Payment newPayment, @PathVariable String personOfficialId){
        return service.addPaymentForPerson(newPayment, personOfficialId);
    }

}
