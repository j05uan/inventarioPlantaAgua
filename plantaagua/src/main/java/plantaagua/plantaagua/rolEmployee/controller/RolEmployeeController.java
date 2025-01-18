package plantaagua.plantaagua.rolEmployee.controller;

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
import plantaagua.plantaagua.rolEmployee.entity.RolEmployee;
import plantaagua.plantaagua.rolEmployee.service.RolEmployeeService;

@AllArgsConstructor
@RequestMapping("/api/rolEmployee")
@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class RolEmployeeController {

    private final RolEmployeeService rolEmployeeService;

    @GetMapping
    public Iterable<RolEmployee> list(){
        return rolEmployeeService.findAll();
    }

    @GetMapping("{id}")
    public RolEmployee get(@PathVariable Integer id){
        return rolEmployeeService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RolEmployee create(@Validated @RequestBody RolEmployee rolEmployee ){
        return rolEmployeeService.create(rolEmployee);
    }

    @PutMapping("{id}")
    public RolEmployee update(@PathVariable Integer id, @Validated @RequestBody RolEmployee rolEmployee){
        return rolEmployeeService.update(id,rolEmployee);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        // Contact contactFromDb = contactRepository.findById(id).orElse(null);
        rolEmployeeService.delete(id);
    }

}
