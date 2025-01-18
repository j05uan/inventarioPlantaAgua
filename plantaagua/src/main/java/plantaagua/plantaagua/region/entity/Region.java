package plantaagua.plantaagua.region.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import plantaagua.plantaagua.coutry.entity.Country;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "IdCountry")
    private Country country;

    public Region(Integer id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    

}
