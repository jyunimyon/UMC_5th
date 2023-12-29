package umc.jyuny_springprj.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.jyuny_springprj.apiPayload.ApiResponse;
import umc.jyuny_springprj.apiPayload.code.StoreRequestDTO;
import umc.jyuny_springprj.apiPayload.code.StoreResponseDTO;
import umc.jyuny_springprj.converter.ReviewConverter;
import umc.jyuny_springprj.converter.StoreConverter;
import umc.jyuny_springprj.domain.Review;
import umc.jyuny_springprj.domain.Store;
import umc.jyuny_springprj.service.StoreService.StoreCommandService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreRestController {
    private final StoreCommandService storeCommandService;
    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.JoinStoreResultDTO> joinStore(@RequestBody @Valid StoreRequestDTO.JoinStoreDTO request){
        Store store=storeCommandService.joinStore(request);
        return ApiResponse.onSuccess(StoreConverter.toJoinStoreResultDTO(store));
    }

    @PostMapping("/review")
    public ApiResponse<StoreResponseDTO.AddReviewResultDTO> addReview(@RequestBody @Valid StoreRequestDTO.AddReviewDTO request){
        Review review=storeCommandService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toAddReviewResultDTO(review));
    }
}
