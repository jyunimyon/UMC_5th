package umc.jyuny_springprj.apiPayload.exception.handler;

import umc.jyuny_springprj.apiPayload.code.BaseErrorCode;

public class TempHandler extends GeneralException{
    public TempHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
