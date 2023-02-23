package eolebeole.bemealmap.domain.kakao;

import eolebeole.bemealmap.domain.entity.Place;
import lombok.Data;

import java.util.List;

@Data
public class Local {
    private BasicInfo basicInfo;
    private List<Place> documents;

    @Data
    public static class BasicInfo {
        private Integer cid;
        private String placenamefull;
        private String mainphotourl;
        private Address address;
        private Integer wpointx;
        private Integer wpointy;
    }
}
