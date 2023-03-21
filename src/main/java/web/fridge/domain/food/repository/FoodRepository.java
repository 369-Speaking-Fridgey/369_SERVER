package web.fridge.domain.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.fridge.domain.food.entity.Food;
import web.fridge.domain.member.entity.Member;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findAllByFridge_FridgeIdOrderByExpiryDate(Long fridgeId);

    List<Food> findAllByFridge_FridgeIdAndTypeAndFreezeTypeOrderByExpiryDate(Long fridgeId, String type, String freezeType);
}
