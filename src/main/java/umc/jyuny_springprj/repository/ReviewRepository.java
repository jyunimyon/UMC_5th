package umc.jyuny_springprj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.jyuny_springprj.domain.Review;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
