package web.fridge.domain.family.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    MEMBER("ROLE_MEMBER", "MEMBER"),
    OWNER("ROLE_OWNER", "OWNER"),
    REMOVED("ROLE_REMOVED", "REMOVED");

    private final String key;
    private final String title;
}
