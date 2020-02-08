package lt.sdacademy.booking.beauty.converters;


import lt.sdacademy.booking.beauty.models.dto.EmployeeDTO;
import lt.sdacademy.booking.beauty.models.entities.EmployeeEntity;
import org.springframework.stereotype.Component;

import java.math.RoundingMode;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class EmployeeConverter {

    public List<EmployeeDTO> employeeListConvert(List<EmployeeEntity> employeeEntityList) {
        return employeeEntityList.stream().map(this::employeeConvert).collect(toList());
    }

    public EmployeeDTO employeeConvert(EmployeeEntity employeeEntity) {
        EmployeeDTO employeeDTO = new EmployeeDTO(employeeEntity.getPerson().getName(), employeeEntity.getPerson().getSurname(),
                employeeEntity.getServiceEntityList().stream().
                        map(s -> s.getTitle().concat(" " + s.getPrice()
                                .multiply(employeeEntity.getCoefficient()).setScale(2, RoundingMode.HALF_UP))).collect(toList()));
        return employeeDTO;
    }
}
