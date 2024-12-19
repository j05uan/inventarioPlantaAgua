package plantaagua.plantaagua.tipoProducto.entity;

import jakarta.persistence.Column;
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
public class TipeProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    // Constructor para creación de instancias sin ID (JPA manejará el ID)
    public TipeProducts(String name) {
        this.name = name;
    }
}
