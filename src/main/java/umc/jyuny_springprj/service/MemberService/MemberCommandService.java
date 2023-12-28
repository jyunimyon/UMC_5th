package umc.jyuny_springprj.service.MemberService;

import umc.jyuny_springprj.apiPayload.code.MemberRequestDTO;
import umc.jyuny_springprj.domain.Member;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDTO request);
}
