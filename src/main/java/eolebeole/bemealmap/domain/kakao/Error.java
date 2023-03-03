package eolebeole.bemealmap.domain.kakao;

import lombok.Data;

/* 무슨 에러 ? */
@Data
public class Error {
    private String errorType;
    private String message;
    private int statusCode;
}
