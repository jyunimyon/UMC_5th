package umc.jyuny_springprj.service.TempService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.jyuny_springprj.apiPayload.code.status.ErrorStatus;
import umc.jyuny_springprj.apiPayload.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{
    public void CheckFlag(Integer flag){
        if(flag==1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}