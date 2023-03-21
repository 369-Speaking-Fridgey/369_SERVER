package web.fridge.domain.food.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.fridge.domain.food.dto.FoodResponseDTO;
import web.fridge.domain.food.entity.Food;
import web.fridge.domain.food.service.FoodService;
import web.fridge.domain.member.annotation.AuthMember;
import web.fridge.domain.member.entity.Member;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "food", produces = "application/json; charset=utf8")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;


    @GetMapping("/{fridgeId}")
    public ResponseEntity<?> foodListFind(@AuthMember Member member, @PathVariable Long fridgeId){
        List<Food> foodList = foodService.findFoodByMemberAndFridgeId(member, fridgeId);
        List<FoodResponseDTO> responseDTOList = foodList.stream().map(FoodResponseDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(responseDTOList, HttpStatus.OK);
    }


}
