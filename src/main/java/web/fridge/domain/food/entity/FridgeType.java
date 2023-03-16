package web.fridge.domain.food.entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum FridgeType {
    PERSONAL("PERSONAL", "personal"),
    GROUP("GROUP", "group");

    private final String key;
    private final String status;
}
