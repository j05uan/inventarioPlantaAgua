package plantaagua.plantaagua.employee.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import plantaagua.plantaagua.city.entity.City;
import plantaagua.plantaagua.rolEmployee.entity.RolEmployee;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull 
    private String phone;

    private String observation;

    @ManyToOne
    @JoinColumn
    private City city;

    @ManyToOne
    @JoinColumn
    private RolEmployee rolEmployee;

    public Employee(Integer id, String name, String email, String phone, String observation, City city,
            RolEmployee rolEmployee) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.observation = observation;
        this.city = city;
        this.rolEmployee = rolEmployee;
    }

    


    
}
