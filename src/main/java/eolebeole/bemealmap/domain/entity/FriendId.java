package eolebeole.bemealmap.domain.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class FriendId implements Serializable {
    @Id
    @Column
    private int userId;

    @Id
    @Column
    private int userId2;

}
