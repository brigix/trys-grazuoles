package lt.sdacademy.booking.beauty.repositories;

import lt.sdacademy.booking.beauty.models.entities.EmployeeEntity;
import lt.sdacademy.booking.beauty.models.entities.PersonEntity;
import lt.sdacademy.booking.beauty.models.entities.ServiceEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Test
    void findAllByServiceEntityListTitle() {
        ServiceEntity serviceEntity = ServiceEntity.builder()
                .price(new BigDecimal(60))
                .title("plovimas")
                .build();
        ServiceEntity savedService = serviceRepository.save(serviceEntity);

        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .person(PersonEntity.builder()
                        .name("Petras")
                        .surname("Katinas")
                        .birthday(LocalDate.now())
                        .build())
                .coefficient(new BigDecimal(2))
                .serviceEntityList(Arrays.asList(savedService))
                .build();
        employeeRepository.save(employeeEntity);

        List<EmployeeEntity> result = employeeRepository.findAllByServiceEntityListTitle("plovimas");
        assertEquals(1, result.size());
    }
}
