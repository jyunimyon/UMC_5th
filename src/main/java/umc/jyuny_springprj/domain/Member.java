package umc.jyuny_springprj.domain;

import lombok.*;
import umc.jyuny_springprj.domain.base.BaseEntity;
import umc.jyuny_springprj.domain.enums.Gender;
import umc.jyuny_springprj.domain.enums.MemberStatus;
import umc.jyuny_springprj.domain.enums.SocialType;
import umc.jyuny_springprj.domain.mapping.MemberAgree;
import umc.jyuny_springprj.domain.mapping.MemberMission;
import umc.jyuny_springprj.domain.mapping.MemberFavor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 20)
    private String name;

    @Column(nullable = false,length = 40)
    private String address;

    @Column(nullable = false,length = 40)
    private String specAddress; // 실제 Spring Data JPA 사용시, spec_address로 바꿔줌

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    private LocalDate inactiveDate;

    @Column(nullable = false,length = 50)
    private String email;

    private Integer point;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberFavor> memberFavorList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
