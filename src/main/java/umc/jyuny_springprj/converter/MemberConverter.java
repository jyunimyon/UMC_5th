package umc.jyuny_springprj.converter;

import umc.jyuny_springprj.apiPayload.code.MemberResponseDTO;
import umc.jyuny_springprj.apiPayload.code.MemberRequestDTO;
import umc.jyuny_springprj.domain.Member;
import umc.jyuny_springprj.domain.enums.Gender;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Member toMember(MemberRequestDTO.JoinDTO request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberFavorList(new ArrayList<>())
                .build();
    }
}
