package eolebeole.bemealmap.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Recommend")
@Table(name = "recommendTable")
public class Recommend {

    @Id
    @Column
    private int recommendId;

    @Column
    private int userId;

    @Column
    private int restaurantId;

    @Column
    private Date date;


}
