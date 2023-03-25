package web.fridge.domain.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.fridge.domain.fridge.entity.Fridge;

public interface FridgeRepository extends JpaRepository<Fridge, Long> {
}
