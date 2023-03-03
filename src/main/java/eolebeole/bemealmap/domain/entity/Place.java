package eolebeole.bemealmap.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Place")
@Table(name="placeTable")
public class Place {

    @Id
    @Column(name = "placeId")
    private int id;

    @Column
    private String addressName;

    @Column
    private String categoryGroupCode;

    @Column
    private String categoryGroupName;

    @Column
    private String categoryName;

    @Transient
    private Long distance;

    @Column
    private String phone;

    @Column
    private String placeName;

    @Column
    private String placeUrl;

    @Column
    private String roadAddressName;

    @Column
    private Double x;

    @Column
    private Double y;
}
