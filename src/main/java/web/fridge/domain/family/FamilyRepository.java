package web.fridge.domain.family;

import org.springframework.data.jpa.repository.JpaRepository;
import web.fridge.domain.food.entity.Fridge;
import web.fridge.domain.member.entity.Member;

import java.util.List;

public interface FamilyRepository extends JpaRepository<Family, Long> {
    List<Family> findByMember(Member member);

    List<Family> findByFridgeId(Long fridgeId);
}
