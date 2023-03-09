package eolebeole.bemealmap.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Friend")
@Table(name = "friendTable")
@IdClass(FriendId.class)
public class Friend {
    @Id
    @Column
    @JsonIgnore
    private int userId1;

    @Id
    @Column
    @JsonIgnore
    private int userId2;

    @JoinColumn(name = "userId2", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonProperty("friend")
    private User user2;

    @Column
    private Date date;
}
