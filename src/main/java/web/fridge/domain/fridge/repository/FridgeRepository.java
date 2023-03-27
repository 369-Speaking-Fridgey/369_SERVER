package web.fridge.domain.fridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.fridge.domain.fridge.entity.Fridge;

public interface FridgeRepository extends JpaRepository<Fridge, Long> {
}
