package eolebeole.bemealmap.domain;

import eolebeole.bemealmap.domain.entity.Place;
import eolebeole.bemealmap.domain.kakao.KakaoService;
import eolebeole.bemealmap.domain.kakao.LocalRequest;
import eolebeole.bemealmap.domain.repository.PlaceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class KakaoServiceTest {

    private static Place place = Place.builder().id(968661366).placeName("한국아이티전문학원")
            .x(127.487453983683).y(36.6438019892317).build();

    @Autowired
    private KakaoService kakaoService;

    @Autowired
    private PlaceRepository placeRepository;

    @Test
    void testCategorySearch() throws IOException {
        List<Place> documents = kakaoService.categorySearch(LocalRequest.builder()
                .categoryGroupCode("FD6")
                .x(place.getX())
                .y(place.getY())
                .build());
        System.out.println(documents);
        assertEquals(15, documents.size());
    }

    @Test
    void testKeywordSearch() throws IOException {
        List<Place> documents = kakaoService.keywordSearch(
                LocalRequest.builder().query(place.getPlaceName()).build());
        Place first = documents.get(0);
        assertEquals(first.getX(), place.getX());
        assertEquals(first.getY(), place.getY());
        placeRepository.save(first);
    }

    @Test
    void testPlaceById() throws IOException {
        Place result = kakaoService.placeById(place.getId());
        System.out.println(result);
        assertEquals("충북 청주시 상당구 사직대로361번길 158-10", result.getRoadAddressName());
        assertEquals("충북 청주시 상당구 북문로3가 44-1", result.getAddressName());
    }

    @Test
    void transCoord() throws IOException {
        Place coord = kakaoService.transCoord(
                place.getX(), place.getY(),
                "WGS84", "WCONGNAMUL").get(0);
        assertEquals(608977, coord.getX());
        assertEquals(873987, coord.getY());
    }
}
