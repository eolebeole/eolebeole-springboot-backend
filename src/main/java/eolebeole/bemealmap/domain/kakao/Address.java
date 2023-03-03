package eolebeole.bemealmap.domain.kakao;

import lombok.Data;

@Data
public class Address {
    /* 새로운 주소 ? */
    private NewAddr newaddr;
    /* 지역명 ? */
    private Region region;
    /* 도로명 주소 ? */
    private String addrbunho;
    /* 상세 주소 ? */
    private String addrdetail;

    /**
     * 건물 번호를 포함한 주소를 가져옵니다.
     *
     * @param asStreet {@code true}인 경우 도로명 주소, {@code false}인 경우 지번 주소
     */

    public String getName(boolean asStreet) {
        return String.join(" ",
                asStreet ? region.getNewaddrfullname() : region.getFullname(),
                asStreet ? newaddr.getNewaddrfull() : addrbunho
        );
    }

    @Data
    public static class NewAddr {
        private String newaddrfull;
        private String bsizonno;
    }

    @Data
    public static class Region {
        private String name3;
        private String fullname;
        private String newaddrfullname;
    }
}
