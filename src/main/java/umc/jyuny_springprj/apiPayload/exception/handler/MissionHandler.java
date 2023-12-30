package umc.jyuny_springprj.apiPayload.exception.handler;

import umc.jyuny_springprj.apiPayload.code.BaseErrorCode;

public class MissionHandler extends GeneralException{
    public MissionHandler(BaseErrorCode errorCode){super(errorCode);}
}
