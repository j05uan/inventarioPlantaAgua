package plantaagua.plantaagua.customer.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.annotation.Nonnull;
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
import plantaagua.plantaagua.city.entity.City;
import plantaagua.plantaagua.contacts.entity.Contact;
import plantaagua.plantaagua.tipeDocument.entity.TipeDocument;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "tipeDocument")
    private TipeDocument tipeDocument;

    @NonNull
    private String document;

    @NonNull
    private String phone;

    @ManyToOne
    @JoinColumn
    private City city;

    @NonNull
    private String address;

    @NonNull
    private String email;

    @NonNull
    @Column(columnDefinition = "VARCHAR(500)", nullable = false)
    private String observations;

    @ManyToOne
    @JoinColumn
    private Contact contact;

    public Customer(Integer id, String name, TipeDocument tipeDocument, String document, String phone, City city,
            String address, String email, String observations, Contact contact) {
        this.id = id;
        this.name = name;
        this.tipeDocument = tipeDocument;
        this.document = document;
        this.phone = phone;
        this.city = city;
        this.address = address;
        this.email = email;
        this.observations = observations;
        this.contact = contact;
    }

    

    
    

}
