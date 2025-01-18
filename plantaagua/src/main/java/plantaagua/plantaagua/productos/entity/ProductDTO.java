package plantaagua.plantaagua.productos.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import plantaagua.plantaagua.tipoProducto.entity.TipeProducts;

@Getter
@Setter
public class ProductDTO {
    @NotBlank(message="el nombre es obligatorio")
    private String name;

    @NotBlank(message="descripcion es obligatorio")
    private String description;
    @NotBlank(message="el precio es obligatorio")
    private String price;
    @NotBlank(message="el tipo de producto es obligatorio")
    private TipeProducts tipoProducto;

}
