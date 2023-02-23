package eolebeole.bemealmap.domain.entity;

import eolebeole.bemealmap.domain.s3.S3File;
import lombok.*;

import javax.persistence.*;

@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Img")
@Table(name="imgTable")
public class Img implements S3File {

    @Id
    @Column
    @GeneratedValue
    private int imgId;

    @Column
    private String bucketName;

    @Column
    private String keyName;

    @Transient
    private String url;
}
