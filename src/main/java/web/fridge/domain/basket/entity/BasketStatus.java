package web.fridge.domain.basket.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BasketStatus {
    IN_QUEUE("STATUS_IN_QUEUE", "queued"),
    DELETED("STATUS_DELETED", "deleted"),
    BOUGHT("STATUS_BOUGHT", "done"),
    REPEAT("STATUS_REPEAT", "repeat");


    private final String key;
    private final String status;
}
