package web.fridge.domain.food.controller.dto;

import lombok.Getter;

@Getter
public class FoodStatusRequestDTO {
    private Long foodId;
    private String status;
}
