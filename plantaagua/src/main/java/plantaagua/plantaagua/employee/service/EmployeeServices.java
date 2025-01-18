package plantaagua.plantaagua.employee.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import plantaagua.plantaagua.employee.entity.Employee;
import plantaagua.plantaagua.employee.entity.EmployeeDto;
import plantaagua.plantaagua.employee.repository.EmployeeRepository;
import plantaagua.plantaagua.exceptions.ResourceNotFoundException;

@AllArgsConstructor
@Service
public class EmployeeServices {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;

    public Iterable<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findById(Integer id){
        return employeeRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Employee create(EmployeeDto employeeDto){
        Employee employee = mapper.map(employeeDto, Employee.class);
        return employeeRepository.save(employee);
    }

    public Employee update(Integer id, EmployeeDto employeeDto){
        Employee employeeFromDb = findById(id);
        mapper.map(employeeDto, employeeFromDb);
        return employeeRepository.save(employeeFromDb);
    }

    public void delete(Integer id){
        Employee employeeFromDb = findById(id);
        employeeRepository.delete(employeeFromDb);
    }

}
