package eolebeole.bemealmap.domain;

import eolebeole.bemealmap.domain.entity.Place;
import eolebeole.bemealmap.domain.repository.PlaceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PlaceTests {
    @Autowired
    private PlaceRepository placeRepository;

    @Test
    void testInsert() {
        Place place = new Place();
        // 값 저장
        place.setPlaceId(968661366);
        place.setPlaceName("한국아이티전문학원");
        placeRepository.save(place);

        // 값 불러오기
        Optional<Place> place2 = placeRepository.findById(place.getPlaceId());

        // 저장된 값과 불러온 값 일치 여부
        assertEquals(place.getPlaceId(), place2.get().getPlaceId());
    }

    @Test
    void testUpdate() {
        Place place = new Place();
        place.setPlaceId(968661366);
        place.setPlaceName("한국아이티전문학원");
        placeRepository.save(place);

        place.setPlaceName(place.getPlaceName() + "추가");
        placeRepository.save(place);
    }

}
