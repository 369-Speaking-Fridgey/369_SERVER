package web.fridge.domain.food.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.fridge.domain.food.entity.Food;
import web.fridge.domain.food.repository.FoodRepository;
import web.fridge.domain.member.entity.Member;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;
    public List<Food> findFoodByMemberAndFridgeId(Member member, Long fridgeId) {
        return foodRepository.findAllByFridge_FridgeId(fridgeId);
    }

    public Food findFoodDetail(Member member, Long foodId) {
        return foodRepository.findById(foodId)
                .orElseThrow(() -> new IllegalArgumentException("음식을 찾을 수 없습니다."));
    }
}
