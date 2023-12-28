package umc.jyuny_springprj.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.jyuny_springprj.apiPayload.code.BaseCode;
import umc.jyuny_springprj.apiPayload.code.ReasonDTO;

@Getter
@AllArgsConstructor
// 여기도 내 맘대로 수정 ..
public enum SuccessStatus implements BaseCode {
    _OK(HttpStatus.OK,"2000","Ok");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    public ReasonDTO getReason(){
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }
    public ReasonDTO getReasonHttpStatus(){
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }

}
