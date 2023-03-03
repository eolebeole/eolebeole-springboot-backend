package eolebeole.bemealmap.domain.kakao;

import lombok.Builder;
import lombok.Data;

/**
 * 카카오맵 장소 검색 요청을 위한 클래스
 */
@Data
@Builder
public class LocalRequest {
    /**
     * 검색을 원하는 질의어 (query)
     */
    private String query;
    /**
     * 결과를 한정할 카테고리 그룹 코드 (categoryGroupCode)
     */
    private String categoryGroupCode;
    /**
     * 중심 좌표의 X값 혹은 longitude (x)
     */
    private Double x;
    /**
     * 중심 좌표의 Y값 혹은 latitude (y)
     */
    private Double y;
    /**
     * 중심 좌표부터의 반경거리. 단위 meter (radius)
     */
    private Integer radius;
    /**
     * 사각형 범위내 검색을 위한 좌측 X 좌표, 좌측 Y 좌표, 우측 X 좌표, 우측 Y 좌표 (rect)
     */
    private String rect;
    /**
     * 결과 페이지 번호. 1~45 사이의 값 (page)
     */
    private Integer page;
    /**
     * 한 페이지에 보여질 문서 수. 1~30 사이의 값 (size)
     */
    private Integer size;
    /**
     * 결과 정렬 순서. distance or accuracy (sort)
     */
    private String sort;
}
