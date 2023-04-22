package web.fridge.domain.invitation;

import org.springframework.data.jpa.repository.JpaRepository;
import web.fridge.domain.invitation.entity.Invitation;
import web.fridge.domain.invitation.entity.InvitationStatus;
import web.fridge.domain.member.entity.Member;

import java.util.List;
import java.util.Optional;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {
    List<Invitation> findAllByMember(Member member);

    List<Invitation> findAllByMemberAndStatus(Member member, InvitationStatus status);

    Optional<Invitation> findByMemberAndFridge_FridgeId(Member member, Long fridgeId);
}
