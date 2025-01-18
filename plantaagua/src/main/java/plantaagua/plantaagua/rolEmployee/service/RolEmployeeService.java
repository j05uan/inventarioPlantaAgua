package plantaagua.plantaagua.rolEmployee.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import plantaagua.plantaagua.employee.entity.Employee;
import plantaagua.plantaagua.exceptions.ResourceNotFoundException;
import plantaagua.plantaagua.rolEmployee.entity.RolEmployee;
import plantaagua.plantaagua.rolEmployee.repository.RolEmployeeRepository;

@AllArgsConstructor
@Service
public class RolEmployeeService {

    private final RolEmployeeRepository rolEmployeeRepository;
    private final ModelMapper mapper;
    public Iterable<RolEmployee> findAll(){
        return rolEmployeeRepository.findAll();
    }

    public RolEmployee findById(Integer id){
        return rolEmployeeRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public RolEmployee create(RolEmployee rolEmployee){
        RolEmployee rolEmployee2 = mapper.map(rolEmployee, RolEmployee.class);
        return rolEmployeeRepository.save(rolEmployee2);
    }

    public RolEmployee update(Integer id, RolEmployee rolEmployee){
        RolEmployee rolEmployeeFomDb = findById(id);
        mapper.map(rolEmployee, rolEmployeeFomDb );
        return rolEmployeeRepository.save(rolEmployeeFomDb);
    }

    public void delete(Integer id){
        RolEmployee rolEmployeeFromDb = findById(id);
        rolEmployeeRepository.delete(rolEmployeeFromDb);
    }
}
