package web.fridge.domain.food.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.fridge.domain.food.dto.FoodAddRequestDTO;
import web.fridge.domain.food.entity.Food;
import web.fridge.domain.food.entity.Fridge;
import web.fridge.domain.food.repository.FoodRepository;
import web.fridge.domain.food.repository.FridgeRepository;
import web.fridge.domain.member.entity.Member;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;
    private final FridgeRepository fridgeRepository;

    public List<Food> findFoodByMemberAndFridgeId(Member member, Long fridgeId) {
        return foodRepository.findAllByFridge_FridgeId(fridgeId);
    }

    public Food findFoodDetail(Member member, Long foodId) {
        return foodRepository.findById(foodId)
                .orElseThrow(() -> new IllegalArgumentException("음식을 찾을 수 없습니다."));
    }

    public List<Food> addFood(List<FoodAddRequestDTO> requestDTOList) {
        List<Food> foodList = new ArrayList<>();
        Fridge fridge = fridgeRepository.findById(requestDTOList.get(0).getFridgeId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 냉장고입니다."));
        for (FoodAddRequestDTO dto : requestDTOList){
            foodList.add(Food.builder()
                    .fridge(fridge)
                    .name(dto.getName())
                    .quantity(dto.getQuantity())
                    .type(dto.getType())
                    .memo(dto.getMemo())
                    .freezeType(dto.getFreezeType())
                    .expiryDate(dto.getExpiryDate())
                    .build());
        }
        return foodList;
    }
}
