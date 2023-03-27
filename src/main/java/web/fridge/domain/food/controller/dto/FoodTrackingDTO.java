package web.fridge.domain.food.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FoodTrackingDTO {
    private Long createdByMember;
    private Long consumedByMember;
    private Long wastedByMember;

    @Builder
    public FoodTrackingDTO(Long createdByMember, Long consumedByMember, Long wastedByMember) {
        this.createdByMember = createdByMember;
        this.consumedByMember = consumedByMember;
        this.wastedByMember = wastedByMember;
    }
}
