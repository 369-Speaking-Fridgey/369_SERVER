package web.fridge.domain.food.controller.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FoodEditRequestDTO {
    private Long foodId;
    private String name;
    private String quantity;
    private String memo;
    private String type;
    private String freezeType;
    private LocalDateTime expiryDate;
}
