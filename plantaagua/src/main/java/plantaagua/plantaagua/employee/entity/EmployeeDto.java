package plantaagua.plantaagua.employee.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import plantaagua.plantaagua.city.entity.City;
import plantaagua.plantaagua.rolEmployee.entity.RolEmployee;

@Getter
@Setter
public class EmployeeDto {


    @NotBlank(message="el nombre es obligatorio")
    private String name;

    @Email(message="El email es invalido")
    @NotBlank(message="el email es obligatorio")
    private String email;

    @NotBlank(message = "El Telefono es obligatorio")
    private String phone;

    @NotNull
    private String observation;

    @NotBlank(message = "La ciudad es obligatoria")
    private City city;

    @NotBlank(message = "El rol del empleado es obligatorio")
    private RolEmployee rolEmployee;


}
