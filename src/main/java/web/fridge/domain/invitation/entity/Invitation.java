package web.fridge.domain.invitation.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.fridge.domain.family.Family;
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
    @JoinColumn(name = "family_id")
    private Family family;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Invitation(Long invitationId, InvitationStatus status, Family family, Member member) {
        this.invitationId = invitationId;
        this.status = status;
        this.family = family;
        this.member = member;
    }
}
