package web.fridge.domain.food.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.fridge.domain.food.controller.dto.FoodTrackingDTO;
import web.fridge.domain.food.repository.FoodTrackingRepository;
import web.fridge.domain.member.entity.Member;

@Service
@RequiredArgsConstructor
public class FoodTrackingService {
    private final FoodTrackingRepository foodTrackingRepository;
    public FoodTrackingDTO trackingFoodInfo(Member member) {
        return FoodTrackingDTO.builder()
                .createdByMember(foodTrackingRepository.countFoodCreatedByMemberAtCurrentMonth(member))
                .consumedByMember(foodTrackingRepository.countFoodConsumedByMemberAtCurrentMonth(member))
                .wastedByMember(foodTrackingRepository.countFoodConsumedByMemberAtCurrentMonth(member))
                .build();
    }
}
