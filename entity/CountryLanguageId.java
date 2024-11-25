package pe.edu.i202223255.cl1_jpa_data_mallma_isaac.entity;



import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class CountryLanguageId implements Serializable {

    private String countryCode;

    private String language;
}
