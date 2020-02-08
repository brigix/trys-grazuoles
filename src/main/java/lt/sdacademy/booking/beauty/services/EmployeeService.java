package lt.sdacademy.booking.beauty.services;

import lt.sdacademy.booking.beauty.converters.EmployeeConverter;
import lt.sdacademy.booking.beauty.models.dto.EmployeeDTO;
import lt.sdacademy.booking.beauty.models.entities.EmployeeEntity;
import lt.sdacademy.booking.beauty.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeConverter employeeConverter;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeConverter employeeConverter) {
        this.employeeRepository = employeeRepository;
        this.employeeConverter = employeeConverter;
    }

    public List<EmployeeEntity> getAllEmployeesByService(String title) {
        List<EmployeeEntity> employeeListByService = employeeRepository.findAllByServiceEntityListTitle(title);
        return employeeListByService;
    }

    public List<EmployeeEntity> getEmployees() {
        return employeeRepository.findAll();
    }

    public List<EmployeeDTO> getEmployeesDTO(String title) {
        return employeeConverter.employeeListConvert(employeeRepository.findAllByServiceEntityListTitle(title));
    }

    public List<EmployeeDTO> getEmployeesDTO() {
        return employeeConverter.employeeListConvert(employeeRepository.findAll());
    }

    public EmployeeEntity create(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeEntity getOneById(Integer id) {
        return employeeRepository.findOneById(id);
    }
}
