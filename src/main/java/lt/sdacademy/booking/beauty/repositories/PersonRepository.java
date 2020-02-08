package lt.sdacademy.booking.beauty.repositories;

import java.util.List;
import lt.sdacademy.booking.beauty.models.entities.PersonEntity;
import org.springframework.data.repository.Repository;

public interface PersonRepository extends Repository<PersonEntity, Integer> {

    List<PersonEntity> findAll();

    PersonEntity save(PersonEntity personEntity);

    PersonEntity findOneById(Integer id);

    void deleteById(Integer id);

}
