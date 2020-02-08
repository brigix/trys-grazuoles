package lt.sdacademy.booking.beauty.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeDTO {
    private String name;
    private String surname;
    private List<String> serviceNamePrice;
}
