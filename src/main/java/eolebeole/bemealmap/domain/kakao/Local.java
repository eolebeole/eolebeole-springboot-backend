package eolebeole.bemealmap.domain.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import eolebeole.bemealmap.domain.entity.Place;
import lombok.Data;

import java.util.List;

@Data
public class Local {
    @JsonProperty("basicInfo")
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
