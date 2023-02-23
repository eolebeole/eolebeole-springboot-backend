package eolebeole.bemealmap.domain.kakao;

import lombok.Data;

@Data
public class Error {
    private String errorType;
    private String message;
    private int statusCode;
}
