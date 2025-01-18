package plantaagua.plantaagua.customer.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import plantaagua.plantaagua.Tipecontacts.entity.TipeContacts;
import plantaagua.plantaagua.city.entity.City;
import plantaagua.plantaagua.contacts.entity.Contact;
import plantaagua.plantaagua.tipeDocument.entity.TipeDocument;

@Getter
@Setter
public class CustomerDto {

    @NotBlank(message="el nombre es obligatorio")
    private String name;

    @NotBlank(message = "El tipo de Documento es obligatorio")
    private TipeDocument tipeDocument;

    @NotBlank(message = "El  Documento es obligatorio")
    private String document;

    @Email(message="El email es invalido")
    @NotBlank(message="el email es obligatorio")
    private String email;

    @NotBlank(message = "La direccio es obligatoria")
    private String addres;

    @NotBlank(message = "El Telefono es obligatorio")
    private String phone;

    @NotBlank(message="el contacto es obligatorio")
    private Contact contact;

    @NotBlank(message="La ciudad es obligatoria")
    private City city;

    private String observations;


}
