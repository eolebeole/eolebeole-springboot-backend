package eolebeole.bemealmap.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pwd;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    @Column
    private String name;

    @Column
    private String nick;

    @Column
    private Integer code;

    @Column
    private Long imgId;

    @Column
    private Integer gender;

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Token> tokens;
}
