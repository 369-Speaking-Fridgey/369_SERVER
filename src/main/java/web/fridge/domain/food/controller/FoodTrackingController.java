package web.fridge.domain.food.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.fridge.domain.food.controller.dto.FoodTrackingDTO;
import web.fridge.domain.food.service.FoodTrackingService;
import web.fridge.domain.member.annotation.AuthMember;
import web.fridge.domain.member.entity.Member;

import java.util.Map;

@RestController
@RequestMapping("/food/tracking")
@RequiredArgsConstructor
public class FoodTrackingController {

    private final FoodTrackingService foodTrackingService;

    @GetMapping
    public ResponseEntity<?> foodTracking(@AuthMember Member member){
        FoodTrackingDTO responseDTO = foodTrackingService.trackingFoodInfo(member);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
