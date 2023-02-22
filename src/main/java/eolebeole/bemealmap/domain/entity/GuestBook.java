package eolebeole.bemealmap.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="GuestBook")
@Table(name="guestBookTable")
public class GuestBook {

    @Id
    @Column
    private int userId;

    @Column
    private String content;

    @Column
    private int like;
}
