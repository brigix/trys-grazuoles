package lt.sdacademy.booking.beauty.repositories;

import org.springframework.data.repository.Repository;

import java.util.List;

import lt.sdacademy.booking.beauty.models.entities.ServiceEntity;

public interface ServiceRepository extends Repository<ServiceEntity, Integer> {

    List<ServiceEntity> findAll();

    ServiceEntity findOneById(Integer id);

    ServiceEntity save(ServiceEntity serviceEntity);

    void deleteById(Integer id);
}
