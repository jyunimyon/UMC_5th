package umc.jyuny_springprj.converter;

import lombok.RequiredArgsConstructor;
import umc.jyuny_springprj.apiPayload.code.StoreRequestDTO;
import umc.jyuny_springprj.apiPayload.code.StoreResponseDTO;
import umc.jyuny_springprj.domain.Region;
import umc.jyuny_springprj.domain.Store;
import umc.jyuny_springprj.repository.RegionRepository;

import java.time.LocalDateTime;

@RequiredArgsConstructor // regionRepository의 생성자 주입
public class StoreConverter {

    public static StoreResponseDTO.JoinStoreResultDTO toJoinStoreResultDTO(Store store){
        return StoreResponseDTO.JoinStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Store toStore(StoreRequestDTO.JoinStoreDTO request){
        Region region=Region.builder()
                .id(request.getRegionId())
                .build(); // 그냥 아무 region 객체나 생성해서 넣어 두고
        
        return Store.builder()
                .address(request.getAddress())
                .name(request.getName())
                .region(region)
                .build();
    }
}
