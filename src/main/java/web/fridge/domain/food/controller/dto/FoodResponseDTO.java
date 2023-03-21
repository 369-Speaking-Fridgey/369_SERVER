package web.fridge.domain.food.controller.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import org.springframework.lang.Nullable;
import web.fridge.domain.food.entity.Food;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class FoodResponseDTO {
    private Long foodId;
    private String name;
    private String quantity;
    private String memo;
    private String type;
    private String freezeType;
    private LocalDateTime expiryDate;

    @Builder
    public FoodResponseDTO(Food entity) {
        this.foodId = entity.getFoodId();
        this.name = entity.getName();
        this.quantity = entity.getQuantity();
        this.memo = entity.getMemo();
        this.type = entity.getType();
        this.freezeType = entity.getFreezeType();
        this.expiryDate = entity.getExpiryDate();
    }
}
