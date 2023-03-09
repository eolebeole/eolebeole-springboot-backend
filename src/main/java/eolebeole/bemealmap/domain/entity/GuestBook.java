package eolebeole.bemealmap.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="GuestBook")
@Table(name="guestBookTable")
public class GuestBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    private int userId;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;

    @JsonIgnore
    private int guestId;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "guestId", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private User guest;

    @Column
    private String content;

    private Timestamp createdAt;

    @Column
    private int like;
}
