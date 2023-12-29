package umc.jyuny_springprj.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.jyuny_springprj.apiPayload.code.BaseErrorCode;
import umc.jyuny_springprj.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),
    //Member Error
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST,"MEMBER4001","사용자가 없습닌다"),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST,"MEMBER4002","닉네임은 필수입니다"),

    //Article Error
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND,"ARTICLE4001","게시글이 없습니다"),
    //For test
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST,"TEMP4001","FOR TEST"),
    
    // Food Category Error
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND,"FOOD4001","존재하지 않는 카테고리입니다"),

    // Region Error
    REGION_NOT_FOUND(HttpStatus.NOT_FOUND,"REGION4001","존재하지 않는 지역입니다"),

    // Store Error
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND,"STORE4001","존재하지 않는 식당입니다");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    //interface의 메소드를 "오버라이딩"하여 DTO를 만든다.
    public ErrorReasonDTO getReason(){
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build(); // 빌더 패턴
    }
    public ErrorReasonDTO getReasonHttpStatus(){
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
