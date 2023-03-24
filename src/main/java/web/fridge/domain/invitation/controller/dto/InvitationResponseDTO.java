package web.fridge.domain.invitation.controller.dto;

import web.fridge.domain.invitation.entity.Invitation;

public class InvitationResponseDTO {
    public Long invitationId;
    public Long fridgeId;
    public String invitedMemberEmail;
    public String status;

    public InvitationResponseDTO(Invitation invitation){
        this.invitationId = invitation.getInvitationId();
        this.fridgeId = invitation.getFridge().getFridgeId();
        this.invitedMemberEmail = invitation.getMember().getEmail();
        this.status = invitation.getStatus().getKey();
    }
}
