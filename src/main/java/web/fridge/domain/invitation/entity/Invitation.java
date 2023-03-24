package web.fridge.domain.invitation.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.fridge.domain.food.entity.Fridge;
import web.fridge.domain.member.entity.Member;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invitationId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private InvitationStatus status;

    @ManyToOne
    @JoinColumn(name = "fridge_id")
    private Fridge fridge;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Invitation(Long invitationId, InvitationStatus status, Fridge fridge, Member member) {
        this.invitationId = invitationId;
        this.status = status;
        this.fridge = fridge;
        this.member = member;
    }

    public void changeStatusAccepted(Boolean isAccepted) {
        if (isAccepted == Boolean.FALSE){
            this.status = InvitationStatus.REJECTED;
        }
        else {
            this.status = InvitationStatus.ACCEPTED;
        }
    }
}
