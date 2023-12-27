package umc.jyuny_springprj.apiPayload.code;

//여기도 내 마음대로 ErrorReason -> ErrorReasonDTO
public interface BaseErrorCode {
    public ErrorReasonDTO getReason();
    public ErrorReasonDTO getReasonHttpStatus();
}
