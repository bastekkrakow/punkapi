package pl.splon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"food_pairing"})

public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String tagline;
    private String first_brewed;
    @Column(length = 700)
    private String description;
    private String image_url;
    private Long ibu;
    @Transient
    private List<String> food_pairing;
    @Column(name = "food_pairing1", nullable = true)
    private String foodPairing1;
    @Column(name = "food_pairing2", nullable = true)
    private String foodPairing2;
    @Column(name = "food_pairing3", nullable = true)
    private String foodPairing3;

    public Beer() {
    }
}

