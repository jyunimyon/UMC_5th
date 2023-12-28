package umc.jyuny_springprj.domain.mapping;
import lombok.*;
import umc.jyuny_springprj.domain.Member;
import umc.jyuny_springprj.domain.base.BaseEntity;
import umc.jyuny_springprj.domain.FoodCategory;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class MemberFavor extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id")
    private FoodCategory foodCategory;

    public void setMember(Member member){
        if(this.member!=null)
            member.getMemberFavorList().remove(this);
        this.member=member;
        member.getMemberFavorList().add(this);
    }
    public void setFoodCategory(FoodCategory foodCategory){
        this.foodCategory = foodCategory;
    }

}
