package umc.jyuny_springprj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.jyuny_springprj.domain.Store;

public interface StoreRepository extends JpaRepository<Store,Long> {
    //JpaRepository<엔티티, ID>에서 두 번째 인자는 해당 엔티티의 ID 필드의 자료형을 지정해야 한다
}
