package plantaagua.plantaagua.store.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import plantaagua.plantaagua.contacts.entity.Contact;
import plantaagua.plantaagua.tipeStore.entity.TipeStore;

@Getter
@Setter
public class StoreDTO {

    @NotBlank(message="el nombre es obligatorio")
    private String name;

    @NotBlank(message="la direccion es obligatorio")
    private String address;

    @NotBlank(message="el telefono es obligatorio")
    private String phone;

    @NotBlank(message="el tipo de bodega es obligatorio")
    private TipeStore tipeStore;

    // @NotBlank(message="el nombre es obligatorio")
    private Contact contact;

}
