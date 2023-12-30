package umc.jyuny_springprj.service.MemberService;

import umc.jyuny_springprj.apiPayload.code.MemberRequestDTO;
import umc.jyuny_springprj.domain.Member;
import umc.jyuny_springprj.domain.mapping.MemberMission;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDTO request);
    MemberMission challengeMission(MemberRequestDTO.ChallengeMissionDTO request);
}
