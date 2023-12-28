package umc.jyuny_springprj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.jyuny_springprj.domain.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {

}
