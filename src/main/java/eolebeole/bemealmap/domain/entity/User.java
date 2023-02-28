package eolebeole.bemealmap.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="User")
@Table(name="userTable")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column
    private String email;

    @Column
    private String pwd;

    @Column
    private Date birth;

    @Column
    private String name;

    @Column
    private String nick;

    @Column
    private Long code;

    @Column
    private Long imgId;

    @Column
    private int gender;
}
