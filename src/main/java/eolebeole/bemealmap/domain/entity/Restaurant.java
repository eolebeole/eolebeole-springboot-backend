package eolebeole.bemealmap.domain.entity;

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
    private int placeId;

}
