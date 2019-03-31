package lt.mb.payment;

import lt.mb.common.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/payment")
public class PaymentController {

//    private PaymentRepository repository;

@GetMapping("/get/{id}")
public Payment getPayment(@PathVariable Long id){
    System.out.println(id);
    return new Payment();
}


}
