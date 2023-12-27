package umc.jyuny_springprj.apiPayload.code;

// ErrorStatus에서 사용하려고 내 마음대로 만든 것들
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class ErrorReasonDTO {
    private String message;
    private String code;
    private boolean isSuccess;
    private HttpStatus httpStatus;
}
