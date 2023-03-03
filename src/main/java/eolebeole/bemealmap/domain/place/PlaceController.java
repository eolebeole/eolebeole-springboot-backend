package eolebeole.bemealmap.domain.place;

import eolebeole.bemealmap.domain.entity.Place;
import eolebeole.bemealmap.domain.kakao.LocalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    // "url?x=12312.12&y= 123123.123" 입력방식
    @GetMapping
    public ResponseEntity<List<Place>> getAllPlace(LocalRequest request) throws IOException {
        List<Place> placeList = placeService.getAllPlace(request);
        return ResponseEntity.status(HttpStatus.OK).body(placeList);
    }

    @GetMapping("./{placeId}")
    public ResponseEntity<Place> getPlace(@PathVariable Integer placeId) throws IOException{
        Place place = placeService.getPlace(placeId);
        return ResponseEntity.status(HttpStatus.OK).body(place);
    }
}
