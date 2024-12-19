package plantaagua.plantaagua.productos.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import plantaagua.plantaagua.tipoProducto.entity.TipeProducts;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class Porducto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NonNull
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    @NonNull
    @Column(columnDefinition = "VARCHAR(200)", nullable = false)
    private String description;

    @NonNull
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String price;

    @ManyToOne
    @JoinColumn(name = "tipoProducto")
    private TipeProducts tipoProducto;

    public Porducto( String name, String description, String price, TipeProducts tipoProducto) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.tipoProducto = tipoProducto;
    }

    
}
