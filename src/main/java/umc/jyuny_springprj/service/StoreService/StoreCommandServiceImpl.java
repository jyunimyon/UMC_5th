package umc.jyuny_springprj.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.jyuny_springprj.apiPayload.code.StoreRequestDTO;
import umc.jyuny_springprj.apiPayload.code.status.ErrorStatus;
import umc.jyuny_springprj.apiPayload.exception.handler.RegionHandler;
import umc.jyuny_springprj.converter.ReviewConverter;
import umc.jyuny_springprj.converter.StoreConverter;
import umc.jyuny_springprj.domain.Region;
import umc.jyuny_springprj.domain.Review;
import umc.jyuny_springprj.domain.Store;
import umc.jyuny_springprj.repository.MemberRepository;
import umc.jyuny_springprj.repository.RegionRepository;
import umc.jyuny_springprj.repository.ReviewRepository;
import umc.jyuny_springprj.repository.StoreRepository;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
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

    @Override
    @Transactional
    public Review addReview(StoreRequestDTO.AddReviewDTO request) {
        Review newReview= ReviewConverter.toReview(request);
        // ⬇️ 송은님 코드 참고. joinStore도 비슷하게 바꾸면 좋을듯. 이렇게 하면 불필요한 handler 작성 안 해도 되는듯
        newReview.setStore(storeRepository.findById(request.getStoreId()).get());
        newReview.setMember(memberRepository.findById(request.getMemberId()).get());
        /*기본적으로 Optional은 값이 존재하지 않을 수도 있기 때문에 오류가 난다.
         get() 메서드를 호출하여 Optional 값을 가져오면 해당 Optional 값이 반드시 존재한다고 가정하기 때문에 오류가 나지 않는다.
         따라서 진짜 값이 있다고 확신할 수 있을 때 사용해야 한다. 하지만 우리는 dto에서 어노테이션으로 검증을 미리 할 것이기에 이렇게 작성해도 된다!
         */
        return reviewRepository.save(newReview);
    }
}
