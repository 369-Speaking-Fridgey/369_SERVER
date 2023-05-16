package web.fridge.domain.fridge.controller.dto;

import lombok.Builder;
import lombok.Getter;
import web.fridge.domain.fridge.entity.Fridge;
import web.fridge.domain.member.entity.Member;

@Getter
public class FridgeResponseDTO {
    private String email;
    private Long fridgeId;
    private String name;

    @Builder
    public FridgeResponseDTO(Member member, Fridge fridge) {
        this.email = member.getEmail();
        this.fridgeId = fridge.getFridgeId();
        this.name = fridge.getName();
    }
}
