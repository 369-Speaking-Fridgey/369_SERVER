package web.fridge.domain.food;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.fridge.domain.member.annotation.AuthMember;
import web.fridge.domain.member.entity.Member;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;

    @GetMapping
    public ResponseEntity<?> findAllFood(@AuthMember Member member){
        List<Food> foodList = foodService.foodFind(member);
        return new ResponseEntity<>(foodList, HttpStatus.OK);
    }

}
