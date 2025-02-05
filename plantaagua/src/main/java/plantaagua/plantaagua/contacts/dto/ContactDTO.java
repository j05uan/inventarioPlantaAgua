package plantaagua.plantaagua.contacts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import plantaagua.plantaagua.Tipecontacts.entity.TipeContacts;

@Getter
@Setter
public class ContactDTO {
    @NotBlank(message="el nombre es obligatorio")
    private String name;

    @Email(message="El email es invalido")
    @NotBlank(message="el email es obligatorio")
    private String email;

    @NotBlank(message = "El puesto del contacto es obligatorio")
    private String position;

    @NotBlank(message = "El Telefono es obligatorio")
    private String phone;

    @NotNull
    private String observation;

    @NotBlank(message = "El tipo de Contacto es obligatorio")
    private TipeContacts tipeContacts;


}
