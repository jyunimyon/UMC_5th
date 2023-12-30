package umc.jyuny_springprj.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.jyuny_springprj.apiPayload.code.MemberRequestDTO;
import umc.jyuny_springprj.apiPayload.code.status.ErrorStatus;
import umc.jyuny_springprj.apiPayload.exception.handler.FoodCategoryHandler;
import umc.jyuny_springprj.apiPayload.exception.handler.MissionHandler;
import umc.jyuny_springprj.converter.MemberConverter;
import umc.jyuny_springprj.converter.MemberFavorConverter;
import umc.jyuny_springprj.domain.FoodCategory;
import umc.jyuny_springprj.domain.Member;
import umc.jyuny_springprj.domain.Mission;
import umc.jyuny_springprj.domain.mapping.MemberFavor;
import umc.jyuny_springprj.domain.mapping.MemberMission;
import umc.jyuny_springprj.repository.FoodCategoryRepository;
import umc.jyuny_springprj.repository.MemberMissionRepository;
import umc.jyuny_springprj.repository.MemberRepository;
import umc.jyuny_springprj.repository.MissionRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{
    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDTO request) {

        // Member 객체를 만드는 작업을 서비스 단에서 하지 않는다. 서비스에서는 비즈니스 로직에만 집중한다 ➡️ converter에서 진행
        Member newMember= MemberConverter.toMember(request);
        // 사용자 선호 리스트 처리하기
        List<FoodCategory> foodCategoryList = request.getFavorCategory().stream()
                .map(category ->{
                    return foodCategoryRepository.findById(category).orElseThrow(()->new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                    // 안 좋은 검증 로직. 이 다음에 validation 어노테이션으로 리팩토링 할 것임 
                }).collect(Collectors.toList());
        List<MemberFavor> memberFavorList = MemberFavorConverter.toMemberFavorList(foodCategoryList);

        memberFavorList.forEach(memberFavor -> {memberFavor.setMember(newMember);});

        return memberRepository.save(newMember);
    }

    @Override
    @Transactional
    public MemberMission challengeMission(MemberRequestDTO.ChallengeMissionDTO request) {
        // 일단 service단에서 유효성 검증
        // ⬇️ 유효성 검증은 송은님 코드 참고
        Mission mission = missionRepository.findById(request.getMissionId()).get();
        // request의 missionId를 가진 mission에 대해

        boolean isChallenge = mission.getMemberMissionList().stream() // allMatch 메소드: 스트림의 모든 요소가 주어진 조건을 만족하는지를 확인하는 역할. return true or false
                // 해당 미션의 memberMission 리스트 중 memberId가 request와 동일한 사람이 있으면 오류
                .allMatch(memberMission -> memberMission.getMember().getId()!=request.getMemberId());
        if (!isChallenge) {
            throw new MissionHandler(ErrorStatus.MISSION_ALREADY_CHALLENGE);
        }


        MemberMission newMemberMission=MemberMission.builder().build();
        newMemberMission.setMember(memberRepository.findById(request.getMemberId()).get());
        //newMemberMission.setMission(missionRepository.findById(request.getMissionId()).get());
        newMemberMission.setMission(mission);
        return memberMissionRepository.save(newMemberMission);
    }
}
