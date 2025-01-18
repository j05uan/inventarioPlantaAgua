package plantaagua.plantaagua.tipeDocument.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class TipeDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String TipeDocument;

    public TipeDocument(Integer id, String tipeDocument) {
        this.id = id;
        TipeDocument = tipeDocument;
    }

    
}
