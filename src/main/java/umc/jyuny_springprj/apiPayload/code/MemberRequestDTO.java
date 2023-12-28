package umc.jyuny_springprj.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class MemberRequestDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinDTO{
        String name;
        Integer gender;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String address;
        String specAddress;
        List<Long> favorCategory;
    }
}
