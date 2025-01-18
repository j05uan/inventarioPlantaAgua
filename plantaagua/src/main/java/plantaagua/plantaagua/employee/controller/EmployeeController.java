package plantaagua.plantaagua.employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import plantaagua.plantaagua.employee.entity.Employee;
import plantaagua.plantaagua.employee.entity.EmployeeDto;
import plantaagua.plantaagua.employee.service.EmployeeServices;

@AllArgsConstructor
@RequestMapping("/api/employees")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    private final EmployeeServices employeeServices;

    @GetMapping
    public Iterable<Employee> list(){
        return employeeServices.findAll();
    }

    @GetMapping
    public Employee get(@PathVariable Integer id){
        return employeeServices.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Employee create(@Validated @RequestBody EmployeeDto employeeDto){
        return employeeServices.create(employeeDto);
    }

    @PutMapping("{id}")
    public Employee update(@PathVariable Integer id, @Validated @RequestBody EmployeeDto employeeDto){
        return employeeServices.update(id, employeeDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        employeeServices.delete(id);
    }
}
