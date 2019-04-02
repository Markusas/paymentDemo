package lt.mb.person.service;

import lt.mb.common.Person;
import lt.mb.person.PersonNotfoundException;
import lt.mb.person.db.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {


    public final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person getPersonById(Long id) {
        return repository.findById(id).orElseThrow(() -> new PersonNotfoundException(id));
    }

    public List<Person> getAllPersons() {
        return repository.findAll();
    }
}
