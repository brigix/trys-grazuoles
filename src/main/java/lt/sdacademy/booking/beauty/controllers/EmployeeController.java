package lt.sdacademy.booking.beauty.controllers;

import lt.sdacademy.booking.beauty.models.dto.EmployeeDTO;
import lt.sdacademy.booking.beauty.models.entities.EmployeeEntity;
import lt.sdacademy.booking.beauty.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDTO> getEmployeesByService(@RequestParam(required = false) String title) {
        if (title == null) {
            return employeeService.getEmployeesDTO();
        } else return employeeService.getEmployeesDTO(title);
    }

    @PostMapping
    public EmployeeEntity save(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.create(employeeEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        employeeService.deleteById(id);
    }
}
