package plantaagua.plantaagua.employee.repository;

import org.springframework.data.repository.CrudRepository;

import plantaagua.plantaagua.employee.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

}
