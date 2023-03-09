package eolebeole.bemealmap.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://bemealmap.es6.kr/")
                .allowedOriginPatterns("http://*.es6.kr:[*]")
                .allowedOriginPatterns("http://127.0.0.1:[*]")
                .allowedOriginPatterns("http://localhost:[*]")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
