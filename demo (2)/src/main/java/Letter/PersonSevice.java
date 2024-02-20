package Letter.demo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public void save(PersonModel person) {

        personRepository.save(person);
    }

    public PersonModel findOneById(int id) {
        Optional<PersonModel> person = personRepository.findById(id);
        return person.orElse(null);
    }

}
