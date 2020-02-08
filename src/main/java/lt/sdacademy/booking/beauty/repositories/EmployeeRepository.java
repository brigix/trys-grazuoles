package lt.sdacademy.booking.beauty.repositories;

import lt.sdacademy.booking.beauty.models.entities.EmployeeEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface EmployeeRepository extends Repository<EmployeeEntity, Integer> {
    List<EmployeeEntity> findAll();

    List<EmployeeEntity> findAllByServiceEntityListTitle(String title);

    EmployeeEntity findOneById(Integer id);

    EmployeeEntity save(EmployeeEntity employeeEntity);

    void deleteById(Integer id);
}
