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
import lombok.NoArgsConstructor;
import lombok.Setter;
import plantaagua.plantaagua.city.entity.City;
import plantaagua.plantaagua.contacts.entity.Contact;
import plantaagua.plantaagua.employee.entity.Employee;
import plantaagua.plantaagua.tipeStore.entity.TipeStore;

@Getter
@Setter
@NoArgsConstructor
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
    private String capacitance;


    @NonNull
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "tipoBodega")
    private TipeStore tipeStore;

    @ManyToOne
    @JoinColumn
    private City city;

    @ManyToOne
    @JoinColumn(name = "license")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "contacto")
    private Contact contact;

    public Store(Integer id, String name, String address, String capacitance, String phone, TipeStore tipeStore,
            City city, Employee employee, Contact contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacitance = capacitance;
        this.phone = phone;
        this.tipeStore = tipeStore;
        this.city = city;
        this.employee = employee;
        this.contact = contact;
    }

    


    

    
    

}
