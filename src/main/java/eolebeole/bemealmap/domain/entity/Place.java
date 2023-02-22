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
    @Column
    private int placeId;

    @Column
    private String addressName;

    @Column
    private String categoryGroupCode;

    @Column
    private String categoryGroupName;

    @Column
    private String categoryName;

    @Column
    private Long distance;

    @Column
    private Long phone;

    @Column
    private String placeName;

    @Column
    private String placeUrl;

    @Column
    private String roadAddressName;

    @Column
    private Long x;

    @Column
    private Long y;
}
