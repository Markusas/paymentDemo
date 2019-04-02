package lt.mb.payment.service;

import lt.mb.common.Payment;
import lt.mb.common.Person;
import lt.mb.payment.PaymentNotFoundException;
import lt.mb.payment.db.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PaymentService {

    public final PaymentRepository repository;
    static final String URI = "http://localhost:8082/person/persons";

    @Autowired
    private RestTemplate restTemplate;

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

    public List<Person> getPersonByOfficialId(){
        ResponseEntity<List<Person>> resp = restTemplate.exchange(URI, HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>() {
        });
        List<Person> personList = resp.getBody();
        return personList;
    }


}
