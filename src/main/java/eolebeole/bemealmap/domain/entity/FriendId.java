package eolebeole.bemealmap.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

// 기본키를 두개 넣기 위한 Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FriendId implements Serializable {
    @Id
    @Column
    private int userId1;

    @Id
    @Column
    private int userId2;
}
