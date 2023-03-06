package eolebeole.bemealmap.domain.place;

import eolebeole.bemealmap.domain.entity.Place;
import eolebeole.bemealmap.domain.kakao.KakaoService;
import eolebeole.bemealmap.domain.kakao.LocalRequest;
import eolebeole.bemealmap.domain.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PlaceService {
    @Autowired
    private KakaoService kakaoService;

    @Autowired
    private PlaceRepository placeRepository;

    public List<Place> getAllPlace(LocalRequest request) throws IOException {
        request.setCategoryGroupCode("FD6");
        return kakaoService.categorySearch(request);
    }

    public Place getPlace(Integer placeId) throws IOException {
        Place place = placeRepository.findById(placeId).orElse(null);
        if (place == null ){
            place = kakaoService.placeById(placeId);
            placeRepository.save(place);
        }
        return place;
    }

}

