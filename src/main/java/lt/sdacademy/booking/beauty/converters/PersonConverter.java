package lt.sdacademy.booking.beauty.converters;

import static java.util.stream.Collectors.toList;
import java.util.List;
import lt.sdacademy.booking.beauty.models.dto.PersonDTO;
import lt.sdacademy.booking.beauty.models.entities.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonConverter {

    public List<PersonDTO> personConvert(List<PersonEntity> personEntityList) {
        return personEntityList.stream().map(this::personConvert)
            .collect(toList());
    }

    public PersonDTO personConvert(PersonEntity personEntity) {
        PersonDTO personDTO = new PersonDTO(personEntity.getId(), personEntity.getName(), personEntity.getSurname(), personEntity.getBirthday());
        return personDTO;
    }
    public PersonEntity personEntityConvert(PersonDTO personDTO) {
        PersonEntity personEntity = new PersonEntity(personDTO.getName(), personDTO.getSurname(), personDTO.getBirthday());
        personEntity.setId(personDTO.getId());
        return personEntity;
    }
}



