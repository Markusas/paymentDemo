package lt.mb.person.controller;

import lt.mb.common.Person;
import lt.mb.person.PersonNotfoundException;
import lt.mb.person.db.PersonRepository;
import lt.mb.person.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    public final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/get/{id}")
    public Person getPerson(@PathVariable Long id){
        return service.getPersonById(id);
    }
}
