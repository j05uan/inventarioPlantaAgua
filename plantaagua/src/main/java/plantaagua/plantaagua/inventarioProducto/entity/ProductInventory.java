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
import plantaagua.plantaagua.employee.entity.Employee;
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
    private String reason;

    @NonNull
    private String amount;

    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Porducto porducto;

    @ManyToOne
    @JoinColumn(name = "idStore")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "responsible")
    private Employee employee;

    @NonNull
    private String unitPrice;

    @NonNull
    private String discount;

    @NonNull
    private String total;

    public ProductInventory(Integer id, String observation, String reason, String amount, LocalDateTime createdAt,
            Porducto porducto, Store store, Employee employee, String unitPrice, String discount, String total) {
        this.id = id;
        this.observation = observation;
        this.reason = reason;
        this.amount = amount;
        this.createdAt = createdAt;
        this.porducto = porducto;
        this.store = store;
        this.employee = employee;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.total = total;
    }
    
    

    

}
