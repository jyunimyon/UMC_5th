package umc.jyuny_springprj.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
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
@DynamicUpdate
@DynamicInsert
// 위 두개의 dynamic 어노테이션들은 insert와 update시 null인 경우는 그냥 쿼리를 보내지 않도록 해준다
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

    //@Column(nullable = false,length = 50)
    // 이메일을 소셜 로그인에서 처리한 후 나머지 정보를 기입 받는 것이 맞는 순서이나, 소셜 로그인 없이 하는 중이므로 nullable로 설정
    private String email;

    @ColumnDefault("0")
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
