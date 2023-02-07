package web.fridge.domain.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.fridge.domain.post.entity.Exchange;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange,Long> {

}
