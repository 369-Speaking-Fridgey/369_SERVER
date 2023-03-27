package web.fridge.domain.food.service;

import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.fridge.domain.food.controller.dto.FoodTrackingDTO;
import web.fridge.domain.food.entity.FoodStatus;
import web.fridge.domain.food.repository.FoodTrackingRepository;
import web.fridge.domain.member.entity.Member;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FoodTrackingService {
    private final FoodTrackingRepository foodTrackingRepository;
    public FoodTrackingDTO trackingFoodInfo(Member member) {
        Map<FoodStatus, Long> foodStatusLongMap = foodTrackingRepository.countFoodCreatedByMemberAtCurrentMonth(member);
        return FoodTrackingDTO.builder()
                .createdByMember(foodStatusLongMap.get(FoodStatus.NONE))
                .consumedByMember(foodStatusLongMap.get(FoodStatus.CONSUMED))
                .consumedByMember(foodStatusLongMap.get(FoodStatus.WASTED))
                .build();
    }
}
