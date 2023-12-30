package umc.jyuny_springprj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.jyuny_springprj.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission,Long> {
}
