package web.fridge.domain.food;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.fridge.domain.food.dto.FoodAddRequestDTO;
import web.fridge.domain.member.annotation.AuthMember;
import web.fridge.domain.member.entity.Member;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;

    @GetMapping
    public ResponseEntity<?> foodFindAll(@AuthMember Member member){
        List<Food> foodList = foodService.foodFind(member);
        return new ResponseEntity<>(foodList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> foodAdd(@AuthMember Member member, @RequestBody List<FoodAddRequestDTO> requestDTOList){
        foodService.addFood(member, requestDTOList);
        return new ResponseEntity<>("식재료가 등록되었습니다.", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> foodRemove(@AuthMember Member member, @PathVariable Long id){
        foodService.removeFood(member, id);
        return new ResponseEntity<>("식재료가 삭제되었습니다.", HttpStatus.OK);
    }

}
