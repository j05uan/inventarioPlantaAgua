package plantaagua.plantaagua.rolEmployee.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class RolEmployee {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String name;

    public RolEmployee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    

}
