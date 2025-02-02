package plantaagua.plantaagua.contacts.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.micrometer.common.lang.NonNull;
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
import plantaagua.plantaagua.Tipecontacts.entity.TipeContacts;
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String position;

    @NonNull
    private String observation;

    @NonNull
    private String phone;

    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn
    private TipeContacts tipeContacts;

    // Constructor personalizado
    public Contact(String name, String email, String position, String observation, String phone, LocalDateTime createdAt, TipeContacts tipeContacts) {
        this.name = name;
        this.email = email;
        this.position = position;
        this.observation = observation;
        this.phone = phone;
        this.createdAt = createdAt;
        this.tipeContacts = tipeContacts;
    }
}
