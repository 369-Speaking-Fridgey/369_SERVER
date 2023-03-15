package web.fridge.domain.food;

import org.springframework.data.jpa.repository.JpaRepository;
import web.fridge.domain.food.entity.Fridge;

public interface FridgeRepository extends JpaRepository<Fridge, Long> {
}
