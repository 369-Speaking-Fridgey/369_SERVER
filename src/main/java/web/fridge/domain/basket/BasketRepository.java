package web.fridge.domain.basket;

import org.springframework.data.jpa.repository.JpaRepository;
import web.fridge.domain.basket.entity.Basket;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}
