package eolebeole.bemealmap.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Img")
@Table(name="imgTable")
public class Img {

    @Id
    @Column
    private int imgId;
}
