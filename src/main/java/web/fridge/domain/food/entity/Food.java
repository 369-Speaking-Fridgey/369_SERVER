package web.fridge.domain.food.entity;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import web.fridge.domain.food.controller.dto.FoodEditRequestDTO;
import web.fridge.domain.food.controller.dto.FoodStatusRequestDTO;
import web.fridge.domain.fridge.entity.Fridge;
import web.fridge.global.entity.BaseTimeEntity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "food")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Food extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;

    @ManyToOne
    @JoinColumn(name = "fridge_id")
    private Fridge fridge;

    @Column(length = 36)
    @NotNull
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private FoodStatus status;

    @NotNull
    private String quantity;

    @Nullable
    @Column(length = 225)
    private String memo;

    @NotNull
    @Column(length = 36)
    private String type;

    @NotNull
    @Column(length = 45)
    private String freezeType;

    @NotNull
    @Column(length = 45)
    private LocalDateTime expiryDate;

    @Builder
    public Food(Long foodId, Fridge fridge, String name, String quantity, String memo, String type, String freezeType, LocalDateTime expiryDate) {
        this.foodId = foodId;
        this.fridge = fridge;
        this.name = name;
        this.status = FoodStatus.NONE;
        this.quantity = quantity;
        this.memo = memo;
        this.type = type;
        this.freezeType = freezeType;
        this.expiryDate = expiryDate;
    }

    public void update(FoodEditRequestDTO dto){
        this.name = dto.getName();
        this.type = dto.getType();
        this.quantity = dto.getQuantity();
        this.memo = dto.getMemo();
        this.freezeType = dto.getFreezeType();
        this.expiryDate = dto.getExpiryDate();
    }

    public void updateStatus(FoodStatusRequestDTO requestDTO) {
        if (Objects.equals(requestDTO.getStatus(), "CONSUMED")){
            this.status = FoodStatus.CONSUMED;
        }
        else if (Objects.equals(requestDTO.getStatus(), "WASTED")){
            this.status = FoodStatus.WASTED;
        }
    }
}
