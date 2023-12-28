package umc.jyuny_springprj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.jyuny_springprj.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
