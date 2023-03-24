package web.fridge.domain.food.controller.dto;

import lombok.Getter;

@Getter
public class FridgeMemberRemoveDTO {
    private Long fridgeId;
    private Long memberId;
}
