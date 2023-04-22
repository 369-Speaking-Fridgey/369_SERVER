package web.fridge.domain.family;

import org.springframework.data.jpa.repository.JpaRepository;
import web.fridge.domain.family.entity.Family;
import web.fridge.domain.fridge.entity.Fridge;
import web.fridge.domain.member.entity.Member;

import java.util.List;
import java.util.Optional;

public interface FamilyRepository extends JpaRepository<Family, Long> {
    List<Family> findByMember(Member member);
    List<Family> findAllByFridge(Fridge fridge);

    Optional<Family> findByMemberAndFridge_FridgeId(Member member, Long fridgeId);

    Optional<Family> findByMember_MemberIdAndFridge_FridgeId(Long memberId, Long fridgeId);

    List<Family> findAllByFridge_FridgeId(Long fridgeId);
}
