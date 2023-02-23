package eolebeole.bemealmap.domain.kakao;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface KakaoApiService {

    @GET("local/search/category.json")
    Call<Local> categorySearch(@QueryMap Map<String, Object> queryMap);

    @GET("local/search/keyword.json")
    Call<Local> keywordSearch(@QueryMap Map<String, Object> queryMap);

    @GET("//place.map.kakao.com/main/v/{cid}")
    Call<Local> placeById(@Path("cid") int id);

    @GET("local/geo/transcoord.json")
    Call<Local> transCoord(
            @Query("x") double x, @Query("y") double y,
            @Query("input_coord") String input,
            @Query("output_coord") String output);
}
