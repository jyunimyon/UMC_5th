package umc.jyuny_springprj.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.jyuny_springprj.apiPayload.ApiResponse;
import umc.jyuny_springprj.converter.TempConverter;
import umc.jyuny_springprj.service.TempService.TempQueryService;
import umc.jyuny_springprj.web.dto.TempResponse;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {
    private final TempQueryService tempQueryService;
    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testAPI(){
        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }
    // @RequestParam: springboot에서 restcontroller에서 queryString을 받아오는 방법
    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));

    }
}
