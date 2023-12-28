package umc.jyuny_springprj.apiPayload.exception.handler;

import umc.jyuny_springprj.apiPayload.code.BaseErrorCode;

public class FoodCategoryHandler extends GeneralException{
    public FoodCategoryHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
