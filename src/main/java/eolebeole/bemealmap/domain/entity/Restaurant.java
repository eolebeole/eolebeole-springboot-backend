package eolebeole.bemealmap.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Restaurant")
@Table(name="restaurantTable")
public class Restaurant {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int restaurantId;

    @Column
    private int userId;

    @Column
    private int imgId;

    @Column
    private double eval;

    @Column
    private String timeTag;

    @Column
    @JsonIgnore
    private int placeId;

    @JoinColumn(name = "placeId", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Place place;
}
