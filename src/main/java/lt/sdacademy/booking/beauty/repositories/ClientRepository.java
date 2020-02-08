package lt.sdacademy.booking.beauty.repositories;

import java.util.List;
import lt.sdacademy.booking.beauty.models.entities.ClientEntity;
import org.springframework.data.repository.Repository;

public interface ClientRepository extends Repository<ClientEntity, Integer> {

    List<ClientEntity> findAll();

    ClientEntity save(ClientEntity clientEntity);

}
