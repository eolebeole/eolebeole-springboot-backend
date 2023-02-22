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
        place.setPlaceId(968661366);
        place.setPlaceName("한국아이티전문학원");
        placeRepository.save(place);

        Optional<Place> place2 = placeRepository.findById(place.getPlaceId());
        assertEquals(place.getPlaceId(), place2.get().getPlaceId());
    }

}
