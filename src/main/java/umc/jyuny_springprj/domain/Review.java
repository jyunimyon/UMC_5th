package umc.jyuny_springprj.domain;
import lombok.*;
import umc.jyuny_springprj.domain.base.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String body;

    @Column(nullable = false)
    private Float score;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="store_id")
    private Store store;

    // 아마 앞으로 setStore와 setMember를 추가해야할 것이야..
    public void setStore(Store store) {
        this.store = store;
        store.getReviews().add(this);
    }
    public void setMember(Member member) {
        this.member = member;
        member.getReviewList().add(this);
    }

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewImage> reviewImageList=new ArrayList<>();
}