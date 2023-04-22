package web.fridge.domain.food.entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum FoodStatus {
    NONE("STATUS_NONE", "none"),
    CONSUMED("STATUS_CONSUMED", "consumed"),
    WASTED("STATUS_WASTED", "wasted");

    private final String key;
    private final String status;
}
