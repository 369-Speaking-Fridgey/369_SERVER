package web.fridge.domain.food.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.fridge.domain.food.controller.dto.FoodAddRequestDTO;
import web.fridge.domain.food.controller.dto.FoodEditRequestDTO;
import web.fridge.domain.food.controller.dto.FoodStatusRequestDTO;
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

    public List<Food> findFoodList(Long fridgeId, String type, String freezeType) {
        if (type != null && freezeType != null){
            return foodRepository.findAllByFridge_FridgeIdAndTypeAndFreezeTypeOrderByExpiryDate(fridgeId, type, freezeType);
        }
        return foodRepository.findAllByFridge_FridgeIdOrderByExpiryDate(fridgeId);
    }

    public Food findFoodDetail(Member member, Long foodId) {
        return foodRepository.findById(foodId)
                .orElseThrow(() -> new IllegalArgumentException("음식을 찾을 수 없습니다."));
    }

    @Transactional
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
                    .expiryDate(dto.getExpiryDate()).build());
        }
        return foodList;
    }

    @Transactional
    public Food modifyFood(FoodEditRequestDTO requestDTO) {
        Food food = foodRepository.findById(requestDTO.getFoodId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 식재료입니다."));
        food.update(requestDTO);
        return food;
    }

    @Transactional
    public Food modifyFoodStatus(FoodStatusRequestDTO requestDTO) {
        Food food = foodRepository.findById(requestDTO.getFoodId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 식재료입니다."));
        food.updateStatus(requestDTO);
        return food;
    }
}
