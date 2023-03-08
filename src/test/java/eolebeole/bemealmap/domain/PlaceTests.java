package eolebeole.bemealmap.domain;

import eolebeole.bemealmap.domain.entity.Place;
import eolebeole.bemealmap.domain.place.PlaceService;
import eolebeole.bemealmap.domain.repository.PlaceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PlaceTests {
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private PlaceService placeService;

    @Test
    void testGet() throws IOException {
        Place place = placeService.getPlace(16507806);
        assertNotNull(place);
    }

    @Test
    void testInsert() {
        Place place = new Place();
        // 값 저장
        place.setId(968661366);
        place.setPlaceName("한국아이티전문학원");
        placeRepository.save(place);

        // 값 불러오기
        Optional<Place> place2 = placeRepository.findById(place.getId());

        // 저장된 값과 불러온 값 일치 여부
        assertEquals(place.getId(), place2.get().getId());
    }

    @Test
    void testUpdate() {
        Place place = new Place();
        place.setId(968661366);
        place.setPlaceName("한국아이티전문학원");
        placeRepository.save(place);

        place.setPlaceName(place.getPlaceName() + "추가");
        placeRepository.save(place);
    }

}
