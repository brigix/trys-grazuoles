package lt.sdacademy.booking.beauty.converters;

import lt.sdacademy.booking.beauty.models.dto.EmployeeDTO;
import lt.sdacademy.booking.beauty.models.entities.EmployeeEntity;
import lt.sdacademy.booking.beauty.models.entities.PersonEntity;
import lt.sdacademy.booking.beauty.models.entities.ServiceEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeConverterTest {
    private EmployeeConverter employeeConverter;

    @BeforeEach
    public void init() {
        employeeConverter = new EmployeeConverter();
    }

    @Test
    void employeeConvert() {
        ServiceEntity serviceEntity = ServiceEntity.builder()
                .price(new BigDecimal(60))
                .title("plovimas")
                .build();
        ServiceEntity serviceEntity1 = ServiceEntity.builder()
                .price(new BigDecimal(40))
                .title("gremžimas")
                .build();
        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .person(PersonEntity.builder()
                        .name("Petras")
                        .surname("Katinas")
                        .birthday(LocalDate.now())
                        .build())
                .coefficient(new BigDecimal(2))
                .serviceEntityList(Arrays.asList(serviceEntity,serviceEntity1))
                .build();

        EmployeeDTO testDTO = employeeConverter.employeeConvert(employeeEntity);
        assertEquals("Petras", testDTO.getName());
        assertEquals("Katinas", testDTO.getSurname());
        Assert.hasText("plovimas", testDTO.getServiceNamePrice().toString());
        Assert.hasText("60", testDTO.getServiceNamePrice().toString());

    }
}
