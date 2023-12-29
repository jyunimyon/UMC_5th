package umc.jyuny_springprj.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.jyuny_springprj.validation.annotation.ExistRegion;

import javax.validation.constraints.NotBlank;
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
}
