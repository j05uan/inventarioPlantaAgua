package plantaagua.plantaagua.inventarioProducto.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import plantaagua.plantaagua.employee.entity.Employee;
import plantaagua.plantaagua.productos.entity.Porducto;
import plantaagua.plantaagua.store.entity.Store;

@Getter
@Setter
public class ProductInventoryDto {

    @NotNull
    private String observation;

    @NotBlank(message = "La cantidad es obligatoria")
    private String amount;

    @NotBlank(message = "El motivo es obligatorio")
    private String reason;

    @NotBlank(message = "El producto es obligatorio")
    private Porducto porducto;

    @NotBlank(message = "La bodega es obligatorio")
    private Store store;

    @NotBlank(message = "El responsable es obligatorio")
    private Employee employee;

    @NotBlank(message = "El precio es obligatorio")
    private String unitPrice;

    private String discount;

    private String total;

}
