package plantaagua.plantaagua.inventarioProducto.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

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
import lombok.ToString;
import plantaagua.plantaagua.productos.entity.Porducto;
import plantaagua.plantaagua.store.entity.Store;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class ProductInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String observation;

    @NonNull
    private String cantidad;

    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Porducto porducto;

    @ManyToOne
    @JoinColumn(name = "idBodega")
    private Store store;

    public ProductInventory(Integer id, String observation, String cantidad, LocalDateTime createdAt, Porducto porducto,
            Store store) {
        this.id = id;
        this.observation = observation;
        this.cantidad = cantidad;
        this.createdAt = createdAt;
        this.porducto = porducto;
        this.store = store;
    }

    

}
