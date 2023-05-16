package web.fridge.domain.food.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.fridge.domain.food.controller.dto.FoodAddRequestDTO;
import web.fridge.domain.food.controller.dto.FoodEditRequestDTO;
import web.fridge.domain.food.controller.dto.FoodResponseDTO;
import web.fridge.domain.food.controller.dto.FoodStatusRequestDTO;
import web.fridge.domain.food.entity.Food;
import web.fridge.domain.food.service.FoodService;
import web.fridge.domain.member.annotation.AuthMember;
import web.fridge.domain.member.entity.Member;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(value = "food", produces = "application/json; charset=utf8")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @GetMapping("/fridge/{fridgeId}")
    public ResponseEntity<?> foodListFindByType
            (@AuthMember Member member, @PathVariable Long fridgeId
             )
    {
        List<Food> foodList = foodService.findFoodList(fridgeId, null, null);
        for (Food food : foodList) {
            log.info(food.getType());
            log.info(food.getFreezeType());
            log.info(food.getName());
        }
        List<FoodResponseDTO> responseDTOList = foodList.stream().map(FoodResponseDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(responseDTOList, HttpStatus.OK);
    }

    @GetMapping("/{foodId}")
    public ResponseEntity<?> foodDetailFind(@AuthMember Member member, @PathVariable Long foodId){
        Food food = foodService.findFoodDetail(member, foodId);
        return new ResponseEntity<>(new FoodResponseDTO(food), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> foodListAdd(@AuthMember Member member, @RequestBody List<FoodAddRequestDTO> requestDTOList){
        List<Food> foodList = foodService.addFood(requestDTOList);
        return new ResponseEntity<>("식재료를 저장했습니다.", HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> foodEdit(@AuthMember Member member, @RequestBody FoodEditRequestDTO requestDTO){
        Food food = foodService.modifyFood(requestDTO);
        return new ResponseEntity<>(new FoodResponseDTO(food), HttpStatus.OK);
    }

    @PutMapping("/status")
    public ResponseEntity<?> foodStatusModify(@AuthMember Member member, @RequestBody FoodStatusRequestDTO requestDTO){
        Food food = foodService.modifyFoodStatus(requestDTO);
        return new ResponseEntity<>(new FoodResponseDTO(food), HttpStatus.OK);
    }

}
