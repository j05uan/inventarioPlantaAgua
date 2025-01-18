package plantaagua.plantaagua.city.entity;

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
import plantaagua.plantaagua.region.entity.Region;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String city;

    @ManyToOne
    @JoinColumn(name = "idRegion")
    private Region region;

    public City(Integer id, String city, Region region) {
        this.id = id;
        this.city = city;
        this.region = region;
    }

    


}
