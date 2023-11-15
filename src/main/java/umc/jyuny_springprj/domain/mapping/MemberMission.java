package umc.jyuny_springprj.domain.mapping;
import lombok.*;
import umc.jyuny_springprj.domain.Member;
import umc.jyuny_springprj.domain.Mission;
import umc.jyuny_springprj.domain.base.BaseEntity;
import umc.jyuny_springprj.domain.enums.MissionStatus;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class MemberMission extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;
}
