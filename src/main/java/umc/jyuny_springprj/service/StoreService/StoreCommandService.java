package umc.jyuny_springprj.service.StoreService;

import umc.jyuny_springprj.apiPayload.code.StoreRequestDTO;
import umc.jyuny_springprj.domain.Review;
import umc.jyuny_springprj.domain.Store;

public interface StoreCommandService {

    Store joinStore(StoreRequestDTO.JoinStoreDTO request);
    Review addReview(StoreRequestDTO.AddReviewDTO request);
}
