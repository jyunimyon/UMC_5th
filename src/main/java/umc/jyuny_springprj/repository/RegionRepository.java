package umc.jyuny_springprj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.jyuny_springprj.domain.Region;

public interface RegionRepository extends JpaRepository<Region,Long> {
}
