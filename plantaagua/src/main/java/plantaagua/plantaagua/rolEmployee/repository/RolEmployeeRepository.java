package plantaagua.plantaagua.rolEmployee.repository;

import org.springframework.data.repository.CrudRepository;

import plantaagua.plantaagua.employee.entity.Employee;
import plantaagua.plantaagua.rolEmployee.entity.RolEmployee;

public interface RolEmployeeRepository extends CrudRepository<RolEmployee, Integer> {

}
