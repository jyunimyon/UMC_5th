package umc.jyuny_springprj.apiPayload.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.jyuny_springprj.apiPayload.code.BaseErrorCode;
import umc.jyuny_springprj.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException{ // RuntimeException이 발생하면 MasterExceptionHandler가 감지
    private BaseErrorCode code;
    public ErrorReasonDTO getErrorReason(){
        return this.code.getReason();
    }
    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
