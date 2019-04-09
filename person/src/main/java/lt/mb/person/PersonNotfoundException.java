package lt.mb.person;

public class PersonNotfoundException extends RuntimeException {
    public PersonNotfoundException(Long id) {
        super("Person not found with " + id);
    }
}
