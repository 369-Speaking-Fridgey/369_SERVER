package web.fridge.domain.invitation.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InvitationStatus {
    IN_QUEUE("STATUS_IN_QUEUE", "queued"),
    REJECTED("STATUS_REJECTED", "rejected"),
    ACCEPTED("STATUS_ACCEPTED", "accept");

    private final String key;
    private final String status;
}
