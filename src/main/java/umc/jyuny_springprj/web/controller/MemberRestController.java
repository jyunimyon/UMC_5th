package umc.jyuny_springprj.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.jyuny_springprj.apiPayload.ApiResponse;
import umc.jyuny_springprj.apiPayload.code.MemberRequestDTO;
import umc.jyuny_springprj.apiPayload.code.MemberResponseDTO;
import umc.jyuny_springprj.converter.MemberConverter;
import umc.jyuny_springprj.domain.Member;
import umc.jyuny_springprj.service.MemberService.MemberCommandService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDTO request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
