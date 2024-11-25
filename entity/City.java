package pe.edu.i202223255.cl1_jpa_data_mallma_isaac.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "district")
    private String district;

    @Column(name = "population")
    private Integer population;

    @ManyToOne
    @JoinColumn(name = "country_code", nullable = false)
    private Country country;
}
