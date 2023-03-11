package web.fridge.domain.food;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.fridge.domain.food.dto.FoodAddRequestDTO;
import web.fridge.domain.food.dto.FoodModifyRequestDTO;
import web.fridge.domain.member.entity.Member;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public List<Food> foodFind(Member member) {
        return foodRepository.findAllByMember(member);
    }

    @Transactional
    public Boolean addFood(Member member, List<FoodAddRequestDTO> requestDTOList) {
        List<Food> foodList = new ArrayList<>();
        for (FoodAddRequestDTO dto : requestDTOList){
            foodList.add(dto.toEntity(member));
        }
        foodRepository.saveAll(foodList);
        return Boolean.TRUE;
    }

    @Transactional
    public Boolean removeFood(Member member, Long id) {
        Food food = foodRepository.findFoodByFoodIdAndMember(id, member).orElseThrow(() -> new IllegalArgumentException("해당 식재료를 찾을 수 없습니다."));
        foodRepository.delete(food);
        return Boolean.TRUE;
    }

    @Transactional
    public void modifyFood(Member member, FoodModifyRequestDTO requestDTO) {
        Food food = foodRepository.findFoodByFoodIdAndMember(requestDTO.getFoodId(), member).orElseThrow(() -> new IllegalArgumentException("해당 식재료를 찾을 수 없습니다."));
        food.setFoodAttributes(requestDTO);
    }
}
