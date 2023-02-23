package eolebeole.bemealmap.domain.kakao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class KakaoConfig {
    @Value("${external.kakao.rest-api-key}")
    public String restApiKey;

    @Bean
    public OkHttpClient httpClient() {
        return new OkHttpClient.Builder().addInterceptor(chain -> {
            okhttp3.Request request = chain.request().newBuilder()
                    .addHeader("Authorization", "KakaoAK " + restApiKey)
                    .addHeader("Content-Type", "application/json; charset=utf-8")
                    .build();
            return chain.proceed(request);
        }).build();
    }

    @Bean
    public KakaoApiService kakaoApiService(ObjectMapper objectMapper) {
        return retrofit(objectMapper).create(KakaoApiService.class);
    }

    @Bean
    public Retrofit retrofit(ObjectMapper objectMapper) {
        objectMapper
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return new Retrofit.Builder()
                .baseUrl("https://dapi.kakao.com/v2/")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .client(httpClient())
                .build();
    }
}
