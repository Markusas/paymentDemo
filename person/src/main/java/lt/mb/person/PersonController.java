package lt.mb.person;

import lt.mb.common.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.LogManager;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/get/{id}")
    public Person getPerson(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new PersonNotfoundException(id));
    }
}
