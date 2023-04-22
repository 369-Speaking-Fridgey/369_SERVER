package web.fridge.domain.food.controller.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FoodAddRequestDTO {
    private Long fridgeId;
    private String name;
    private String quantity;
    private String memo;
    private String type;
    private String freezeType;
    private LocalDateTime expiryDate;
}
