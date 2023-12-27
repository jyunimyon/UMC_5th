package umc.jyuny_springprj.domain;
import lombok.*;
import umc.jyuny_springprj.domain.base.BaseEntity;
import umc.jyuny_springprj.domain.mapping.MemberMission;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer reward;

    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDate deadline;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String condition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "mission",cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList=new ArrayList<>();
}