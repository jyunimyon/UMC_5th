package umc.jyuny_springprj.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.jyuny_springprj.validation.annotation.ExistMember;
import umc.jyuny_springprj.validation.annotation.ExistRegion;
import umc.jyuny_springprj.validation.annotation.ExistStore;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StoreRequestDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinStoreDTO{
        @NotBlank
        String name;
        @Size(min = 5, max = 12)
        String address;
        @ExistRegion
        Long regionId;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddReviewDTO{
        @NotBlank
        String body;
        @NotNull
        Float score;
        @ExistMember
        Long memberId;
        @ExistStore
        Long storeId;
    }
}
