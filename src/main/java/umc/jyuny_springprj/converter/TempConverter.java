package umc.jyuny_springprj.converter;

import umc.jyuny_springprj.web.dto.TempResponse;

public class TempConverter {
    // converter 함수 이름은 to<만들려는 대상>
    public static TempResponse.TempTestDTO toTempTestDTO(){
        return TempResponse.TempTestDTO.builder()
                .testString("This is Test")
                .build();
    }
    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag){
        return TempResponse.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}
