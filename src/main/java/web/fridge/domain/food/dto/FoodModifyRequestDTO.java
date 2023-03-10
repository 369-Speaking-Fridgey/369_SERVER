package web.fridge.domain.food.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodModifyRequestDTO {
    private Long foodId;
    private String name;
    private String quantity;
    private String type;
    private String freezeType;
    private String memo;
    private LocalDateTime expiryDate;
}
