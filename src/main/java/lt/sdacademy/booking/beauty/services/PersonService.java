package lt.sdacademy.booking.beauty.services;

import lt.sdacademy.booking.beauty.converters.PersonConverter;
import lt.sdacademy.booking.beauty.models.dto.PersonDTO;
import lt.sdacademy.booking.beauty.models.entities.PersonEntity;
import lt.sdacademy.booking.beauty.repositories.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private PersonConverter personConverter;

    public PersonService(PersonRepository personRepository, PersonConverter personConverter) {
        this.personRepository = personRepository;
        this.personConverter = personConverter;
    }

    public PersonDTO getPerson(Integer id) {
        PersonEntity serviceEntity = personRepository.findOneById(id);
        PersonDTO personDTO = personConverter.personConvert(serviceEntity);
        return personDTO;
    }

    public PersonEntity save(PersonDTO personDTO) {
        PersonEntity personEntity = personConverter.personEntityConvert(personDTO);
        return personRepository.save(personEntity);

    }

    public void delete(Integer id) {
        personRepository.deleteById(id);
    }
}
