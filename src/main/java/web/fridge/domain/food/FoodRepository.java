package web.fridge.domain.food;

import org.springframework.data.jpa.repository.JpaRepository;
import web.fridge.domain.member.entity.Member;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findAllByMember(Member member);
}
