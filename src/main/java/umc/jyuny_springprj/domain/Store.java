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
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String address;

    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    private Region region;

    @OneToMany(mappedBy = "store",cascade = CascadeType.ALL)
    private List<Review> reviews=new ArrayList<>();
    
    //✅연관관계 매핑✅ setMember 만들기
    public void setRegion(Region region) {
        this.region = region;
        region.getStoreList().add(this);
    }
}