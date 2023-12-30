package umc.jyuny_springprj.domain.mapping;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.jyuny_springprj.domain.Member;
import umc.jyuny_springprj.domain.Mission;
import umc.jyuny_springprj.domain.Region;
import umc.jyuny_springprj.domain.base.BaseEntity;
import umc.jyuny_springprj.domain.enums.MissionStatus;

import javax.persistence.*;

@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class MemberMission extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'PROGRESS'")
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;
    public void setMember(Member member) {
        this.member = member;
        member.getMemberMissionList().add(this);
    }
    public void setMission(Mission mission) {
        this.mission = mission;
        mission.getMemberMissionList().add(this);
    }

}
