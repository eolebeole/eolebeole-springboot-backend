package eolebeole.bemealmap.domain.kakao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import eolebeole.bemealmap.domain.entity.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class KakaoService {
    @Autowired
    private KakaoApiService kakaoApiService;

    @Autowired
    private ObjectMapper objectMapper;

    private Map<String, Object> asMap(Object object) {
        return objectMapper.convertValue(object, new TypeReference<>() {
        });
    }

    public List<Place> categorySearch(LocalRequest request) throws IOException {
        Call<Local> call = kakaoApiService.categorySearch(asMap(request));
        return handleResponse(call).getDocuments();
    }

    private <T> T handleResponse(Call<T> call) throws IOException {
        Response<T> response = call.execute();
        if (response.isSuccessful()) {
            return response.body();
        }
        Error error = objectMapper.readValue(response.errorBody().byteStream(), Error.class);
        error.setStatusCode(response.code());
        throw new IOException(error.toString());
    }

    public List<Place> keywordSearch(LocalRequest request) throws IOException {
        Call<Local> call = kakaoApiService.keywordSearch(asMap(request));
        return handleResponse(call).getDocuments();
    }

    public Place placeById(int id) throws IOException {
        Call<Local> call = kakaoApiService.placeById(id);
        Local.BasicInfo info = handleResponse(call).getBasicInfo();
        Place place = transCoord(info.getWpointx(), info.getWpointy(),
                "WCONGNAMUL", "WGS84").get(0);
        place.setPlaceId(id);
        place.setPlaceName(info.getPlacenamefull());
        place.setAddressName(info.getAddress().getName(false));
        place.setRoadAddressName(info.getAddress().getName(true));
        return place;
    }

    public List<Place> transCoord(double x, double y, String input, String output) throws IOException {
        return handleResponse(kakaoApiService.transCoord(x, y, input, output)).getDocuments();
    }
}
