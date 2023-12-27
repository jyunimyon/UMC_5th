package umc.jyuny_springprj.apiPayload.code;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@Builder
// 여기도 내 맘대로 수정
public class ReasonDTO {
    private String message;
    private String code;
    private boolean isSuccess;
    private HttpStatus httpStatus;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
