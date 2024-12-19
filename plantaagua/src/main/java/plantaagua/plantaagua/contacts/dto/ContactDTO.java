package plantaagua.plantaagua.contacts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDTO {
    @NotBlank(message="el nombre es obligatorio")
    private String name;

    @Email(message="El email es invalido")
    @NotBlank(message="el email es obligatorio")
    private String email;
}
