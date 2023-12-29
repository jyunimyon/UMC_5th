package umc.jyuny_springprj.apiPayload.exception.handler;

import umc.jyuny_springprj.apiPayload.code.BaseErrorCode;

public class RegionHandler extends GeneralException{
    public RegionHandler(BaseErrorCode errorCode){super(errorCode);};
}
