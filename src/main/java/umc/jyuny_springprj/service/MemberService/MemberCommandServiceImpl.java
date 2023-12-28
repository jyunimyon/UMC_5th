package umc.jyuny_springprj.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.jyuny_springprj.apiPayload.code.MemberRequestDTO;
import umc.jyuny_springprj.apiPayload.code.status.ErrorStatus;
import umc.jyuny_springprj.apiPayload.exception.handler.FoodCategoryHandler;
import umc.jyuny_springprj.converter.MemberConverter;
import umc.jyuny_springprj.converter.MemberFavorConverter;
import umc.jyuny_springprj.domain.FoodCategory;
import umc.jyuny_springprj.domain.Member;
import umc.jyuny_springprj.domain.mapping.MemberFavor;
import umc.jyuny_springprj.repository.FoodCategoryRepository;
import umc.jyuny_springprj.repository.MemberRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{
    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDTO request) {

        // Member 객체를 만드는 작업을 서비스 단에서 하지 않는다. 서비스에서는 비즈니스 로직에만 집중한다 ➡️ converter에서 진행
        Member newMember= MemberConverter.toMember(request);
        // 사용자 선호 리스트 처리하기
        List<FoodCategory> foodCategoryList = request.getFavorCategory().stream()
                .map(category ->{
                    return foodCategoryRepository.findById(category).orElseThrow(()->new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());
        List<MemberFavor> memberFavorList = MemberFavorConverter.toMemberFavorList(foodCategoryList);

        memberFavorList.forEach(memberFavor -> {memberFavor.setMember(newMember);});

        return memberRepository.save(newMember);
    }


}
