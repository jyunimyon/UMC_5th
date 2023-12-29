package umc.jyuny_springprj.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.jyuny_springprj.apiPayload.code.StoreRequestDTO;
import umc.jyuny_springprj.apiPayload.code.status.ErrorStatus;
import umc.jyuny_springprj.apiPayload.exception.handler.RegionHandler;
import umc.jyuny_springprj.converter.StoreConverter;
import umc.jyuny_springprj.domain.Region;
import umc.jyuny_springprj.domain.Store;
import umc.jyuny_springprj.repository.RegionRepository;
import umc.jyuny_springprj.repository.StoreRepository;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{
    public final StoreRepository storeRepository;
    public final RegionRepository regionRepository;
    @Override
    @Transactional
    public Store joinStore(StoreRequestDTO.JoinStoreDTO request) {
        Store newStore= StoreConverter.toStore(request);
        Region region=regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        // ✅연관관계 매핑✅
        newStore.setRegion(region);
        return storeRepository.save(newStore);
    }
}
