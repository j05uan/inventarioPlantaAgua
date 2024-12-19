package plantaagua.plantaagua.store.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import plantaagua.plantaagua.contacts.entity.Contact;
import plantaagua.plantaagua.tipeStore.entity.TipeStore;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NonNull
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    @NonNull
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String address;

    @NonNull
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "tipoBodega")
    private TipeStore tipeStore;

    @ManyToOne
    @JoinColumn(name = "contacto")
    private Contact contact;

    public Store(String name, String address, String phone, TipeStore tipeStore, Contact contact) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.tipeStore = tipeStore;
        this.contact = contact;
    }

    
    

}
