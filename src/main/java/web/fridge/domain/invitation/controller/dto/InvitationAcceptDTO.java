package web.fridge.domain.invitation.controller.dto;

import lombok.Getter;

/**
 * isAccepted
 * - False - Reject
 * - True - Accept
 */
@Getter
public class InvitationAcceptDTO {
    private Long fridgeId;
    private Boolean isAccepted;
}
