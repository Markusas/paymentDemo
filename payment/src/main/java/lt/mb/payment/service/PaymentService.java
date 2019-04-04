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

    public String getAllPersons(){
        ResponseEntity<String> resp = restTemplate.getForEntity(URI, String.class);

        return resp.getBody();


//        ResponseEntity<List<Person>> resp = restTemplate.exchange(URI, HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>() {
//        });
//        List<Person> personLists = resp.getBody();
//        return personLists;
    }


//    public Person getPaymentsByOfficialId(String officialId) {
//
//        ResponseEntity<Person> resp = restTemplate.exchange(URI, HttpMethod.GET, null, Person.class);
//        Person personList = resp.getBody();
////            String officialIdFromPersonList = personList.getOfficialId();
////            for (Person person : getAllPersons()) {
////
////                if (officialIdFromPersonList == officialId){
////                    return person;
////                }
////        }
//        return personList;
//
//
//
//
//
//    }
}
