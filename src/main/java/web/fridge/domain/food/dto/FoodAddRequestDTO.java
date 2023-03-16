package web.fridge.domain.food.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.fridge.domain.food.entity.Food;
import web.fridge.domain.food.entity.Fridge;
import web.fridge.domain.member.entity.Member;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodAddRequestDTO {
    private String name;
    private String quantity;
    private String type;
    private String freezeType;
    private LocalDateTime expiryDate;

    public Food toEntity() {
        return Food.builder()
                .name(this.getName())
                .quantity(this.getQuantity())
                .type(this.getType())
                .freezeType(this.getFreezeType())
                .expiryDate(this.getExpiryDate())
                .build();
    }
}
