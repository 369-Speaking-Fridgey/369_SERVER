package web.fridge.domain.invitation;

import org.springframework.data.jpa.repository.JpaRepository;
import web.fridge.domain.invitation.entity.Invitation;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {
}
