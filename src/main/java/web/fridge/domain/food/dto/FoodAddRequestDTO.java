package web.fridge.domain.food.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import web.fridge.domain.food.entity.Food;

import javax.persistence.Column;
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
