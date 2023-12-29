package umc.jyuny_springprj.converter;

import umc.jyuny_springprj.apiPayload.code.StoreRequestDTO;
import umc.jyuny_springprj.apiPayload.code.StoreResponseDTO;
import umc.jyuny_springprj.domain.Review;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static StoreResponseDTO.AddReviewResultDTO toAddReviewResultDTO(Review review){
        return StoreResponseDTO.AddReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Review toReview(StoreRequestDTO.AddReviewDTO request){
        return Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .build();
    }

}
