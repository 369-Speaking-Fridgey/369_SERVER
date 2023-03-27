package web.fridge.domain.fridge.entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum FridgeType {
    PERSONAL("PERSONAL", "personal"),
    GROUP("GROUP", "group"),
    STOPPED("STOPPED", "stop");


    private final String key;
    private final String status;
}
