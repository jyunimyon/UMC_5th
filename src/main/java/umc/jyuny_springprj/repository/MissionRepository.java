package umc.jyuny_springprj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.jyuny_springprj.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission,Long> {
}
