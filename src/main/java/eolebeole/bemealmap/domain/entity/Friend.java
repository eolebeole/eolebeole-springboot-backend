package eolebeole.bemealmap.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Friend")
@Table(name="friendTable")
@IdClass(FriendId.class)
public class Friend {
    @Id
    @Column
    private int userId;

    @Id
    @Column
    private int userId2;

    @Column
    private Date date;
}
